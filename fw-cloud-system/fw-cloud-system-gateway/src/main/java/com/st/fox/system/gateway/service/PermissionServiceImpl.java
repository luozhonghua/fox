package com.st.fox.system.gateway.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;
import org.springframework.stereotype.Service;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;

import com.st.fox.commons.utils.StringHelper;
import com.st.fox.core.commons.constants.SecurityConstant;
import com.st.fox.core.commons.jwt.JwtUtil;
import com.st.fox.system.api.PermissionFeignApi;
import com.st.fox.system.api.model.AuthPermission;

@Slf4j
@Service("permissionService")
public class PermissionServiceImpl implements PermissionService {

	@Autowired
	private PermissionFeignApi		permissionFeignApi;

	@Autowired
	private RedisConnectionFactory	redisConnectionFactory;

	private AntPathMatcher			antPathMatcher	= new AntPathMatcher();

	@SuppressWarnings("unchecked")
	@Override
	public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
		// options 跨域配置，现在处理是通过前端配置代理，不使用这种方式，存在风险
		/*
		 * if (HttpMethod.OPTIONS.name().equalsIgnoreCase(request.getMethod())) { return true; }
		 */
		Object principal = authentication.getPrincipal();
		List<SimpleGrantedAuthority> grantedAuthorityList = (List<SimpleGrantedAuthority>) authentication
				.getAuthorities();
		boolean hasPermission = false;

		if (null == principal) return hasPermission;
		if (CollectionUtils.isEmpty(grantedAuthorityList)) return hasPermission;

		String token = JwtUtil.getToken(request);
		if (null == token) {
			log.warn("==> gateway|permissionService 未获取到Header Authorization");
			return hasPermission;
		}

		if (!"anonymousUser".equals(principal.toString())) {
			RedisTokenStore tokenStore = new RedisTokenStore(redisConnectionFactory);
			tokenStore.setPrefix(SecurityConstant.PREFIX);
			OAuth2AccessToken accessToken = tokenStore.readAccessToken(token);
			if (null == accessToken || accessToken.isExpired()) {
				log.warn("==> gateway|permissionService token 过期或者不存在");
				return hasPermission;
			}
		}

		// 接口层面做了缓存处理，后续可以继续优化
		Set<AuthPermission> permissions = new HashSet<AuthPermission>();
		for (SimpleGrantedAuthority authority : grantedAuthorityList) {
			permissions.addAll(permissionFeignApi.findMenuByRole(authority.getAuthority()));
		}

		// 网关处理是否拥有菜单权限，菜单下的功能权限校验由调用子模块负责
		String requestURI = request.getRequestURI();
		for (AuthPermission menu : permissions) {
			if (StringHelper.isNotEmpty(menu.getUrl())
					&& antPathMatcher.match(menu.getUrl(), requestURI)) {
				hasPermission = true;
				break;
			}
		}
		return hasPermission;
	}
}
