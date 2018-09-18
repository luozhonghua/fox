package com.st.fox.system.auth.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import com.st.fox.core.commons.constants.SecurityConstant;
import com.st.fox.core.configuration.JwtConfiguration;

/**
 * @author luozhonghua 认证服务器逻辑实现
 * 提供认证、授权服务
 * 对称加密，表示认证服务端和认证客户端的共用一个密钥
 *
 */
@Configuration
@Order(Integer.MIN_VALUE)
@EnableAuthorizationServer
public class FwAuthorizationConfiguration extends AuthorizationServerConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(FwAuthorizationConfiguration.class);

	@Autowired
	private AuthServerConfiguration	authServerConfiguration;

	@Autowired
	private JwtConfiguration		jwtConfiguration;

	@Autowired
	private AuthenticationManager	authenticationManager; //使用默认的认证管家

	@Autowired
	private UserDetailsService		userDetailsService;

	@Autowired
	private RedisConnectionFactory	redisConnectionFactory;

    /**
     *  配置客户端详情信息(内存或JDBC来实现)
     * @param clients
     * @throws Exception
     */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //clients.jdbc() TODO 数据库存储-ui管理:n个客户端
        logger.info("-------------ClientId= "+authServerConfiguration.getClientId());
        logger.info("-------------ClientSecret= "+authServerConfiguration.getClientSecret());
        logger.info("-------------Scope= "+authServerConfiguration.getScope());
		clients.inMemory()
				.withClient(authServerConfiguration.getClientId()) //接受的clientId
				.secret(authServerConfiguration.getClientSecret()) //默认secret
				.authorizedGrantTypes(SecurityConstant.REFRESH_TOKEN, SecurityConstant.PASSWORD, SecurityConstant.AUTHORIZATION_CODE) //授权模式
				.scopes(authServerConfiguration.getScope()) //范围:用户认证 or 服务认证
				// true 直接跳转到客户端页面，false 跳转到用户确认授权页面
				.autoApprove(true);
	}

    /**
     *  spring security token的生成方式
     * @param endpoints 用来配置授权以及令牌的访问端点和令牌服务（比如：配置令牌的签名与存储方式）
     */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(tokenEnhancer(), jwtAccessTokenConverter()));
		endpoints.tokenStore(redisTokenStore())
				.tokenEnhancer(tokenEnhancerChain)
				.authenticationManager(authenticationManager)
				.reuseRefreshTokens(false)
				.userDetailsService(userDetailsService);
	}

    /**
     *
     * @param security  用来配置令牌端点的安全约束
     * @throws Exception
     */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.allowFormAuthenticationForClients()
				// 获取JWt加密key: /oauth/token_key 采用RSA非对称加密时候使用。对称加密禁止访问
				// .tokenKeyAccess("isAuthenticated()")
				.checkTokenAccess("permitAll()"); //能够获取token的
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

    /**
     * AccessToken转换器-定义token的生成方式，这里使用JWT生成token，对称加密只需要加入key等其他信息（自定义）
     * @return
     */
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		FwJwtAccessTokenConverter jwtAccessTokenConverter = new FwJwtAccessTokenConverter();
		jwtAccessTokenConverter.setSigningKey(jwtConfiguration.getJwtkey());
        logger.info("-------------Initializing JWT with public key:\n" + authServerConfiguration.getPublicKey());

		// 采用RSA非对称加密
		// JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
		// jwtAccessTokenConverter.setSigningKey(authServerConfiguration.getPrivateKey());
		// jwtAccessTokenConverter.setVerifierKey(authServerConfiguration.getPublicKey());
		return jwtAccessTokenConverter;
	}

	/**
	 * tokenstore 定制化处理 1. 如果使用的 redis-cluster 模式请使用 FwRedisTokenStore FwRedisTokenStore tokenStore = new
	 * FwRedisTokenStore();
	 * tokenStore.setRedisTemplate(redisTemplate);
	 */
	@Bean
	public TokenStore redisTokenStore() {
		RedisTokenStore tokenStore = new RedisTokenStore(redisConnectionFactory);
		tokenStore.setPrefix(SecurityConstant.PREFIX);
		return tokenStore;
	}

	/**
	 * jwt 生成token 定制化处理
	 * 
	 * @return TokenEnhancer
	 */
	@Bean
	public TokenEnhancer tokenEnhancer() {
		return (accessToken, authentication) -> {
			final Map<String, Object> additionalInfo = new HashMap<>(1);
			additionalInfo.put("license", SecurityConstant.LICENSE);
			((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInfo);
			return accessToken;
		};
	}
}
