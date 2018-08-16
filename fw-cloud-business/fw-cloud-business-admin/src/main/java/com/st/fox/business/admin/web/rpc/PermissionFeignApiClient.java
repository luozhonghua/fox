package com.st.fox.business.admin.web.rpc;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.st.fox.business.admin.service.MenuService;
import com.st.fox.business.commons.permission.Module;
import com.st.fox.business.commons.web.BaseController;
import com.st.fox.business.commons.web.aop.PrePermissions;
import com.st.fox.commons.utils.StringHelper;
import com.st.fox.core.beans.system.AuthMenu;
import com.st.fox.system.api.PermissionFeignApi;
import com.st.fox.system.api.model.AuthPermission;

@RestController
@PrePermissions(value = Module.API, required = false)
@Api(value = "API - PermissionFeignApi", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class PermissionFeignApiClient extends BaseController implements PermissionFeignApi {

	@Autowired
	private MenuService	menuService;

	@Override
	@ApiOperation(httpMethod = GET, value = "通过角色获取菜单权限")
	@ApiImplicitParam(name = "roleCode", value = "用户roleCode", required = true, dataType = "string", paramType = "path")
	public Set<AuthPermission> findMenuByRole(@PathVariable("roleCode") String roleCode) {
		Set<AuthPermission> permissions = new HashSet<AuthPermission>();
		if (StringHelper.isBlank(roleCode)) return permissions;

		Set<AuthMenu> menus = menuService.findMenuByRole(roleCode);
		if (null == menus || menus.size() == 0) return permissions;

		menus.stream().forEach(r -> {
			permissions.add(new AuthPermission(r.getUrl()));
		});

		return permissions;
	}

}
