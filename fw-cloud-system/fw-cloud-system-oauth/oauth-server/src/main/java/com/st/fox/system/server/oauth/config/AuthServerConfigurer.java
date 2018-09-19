package com.st.fox.system.server.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.KeyStoreKeyFactory;

import java.security.KeyPair;

/**   
 * @ClassName:  AuthServerConfigurer
 * @Description:OAuth认证服务配置
 * @author: luozhonghua
 * @date:   2018年7月19日 下午2:10:07
 * @version V1.0
 * 
 */
@Configuration
@EnableAuthorizationServer
@Order(6)
public class AuthServerConfigurer extends AuthorizationServerConfigurerAdapter {

	@Value("${jwt.certificate.store.file}")
	private Resource keystore;

	@Value("${jwt.certificate.store.password}")
	private String keystorePassword;

	@Value("${jwt.certificate.key.alias}")
	private String keyAlias;

	@Value("${jwt.certificate.key.password}")
	private String keyPassword;

	@Autowired
	private UserDetailsService userDetailsService;

    /**
     * 配置客户端详情信息(内存或JDBC来实现)
     * @param clients
     * @throws Exception
     */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
				.withClient("first").secret("passwordforauthserver")
				.redirectUris("http://localhost:8080/").authorizedGrantTypes("authorization_code", "refresh_token")
				.scopes("myscope").autoApprove(true).accessTokenValiditySeconds(30).refreshTokenValiditySeconds(1800)
			   .and()
				.withClient("second").secret("passwordforauthserver")
				.redirectUris("http://localhost:8081/").authorizedGrantTypes("authorization_code", "refresh_token")
				.scopes("myscope").autoApprove(true).accessTokenValiditySeconds(30).refreshTokenValiditySeconds(1800)
                .and()
                .withClient("third").secret("passwordforauthserver")
                .redirectUris("http://localhost:8082/").authorizedGrantTypes("authorization_code", "refresh_token")
                .scopes("myscope").autoApprove(true).accessTokenValiditySeconds(30).refreshTokenValiditySeconds(1800)
                .and()
                .withClient("client1").secret("passwordforauthserver")
                .redirectUris("http://localhost:8181/").authorizedGrantTypes("authorization_code", "refresh_token")
                .scopes("myscope").autoApprove(true).accessTokenValiditySeconds(30).refreshTokenValiditySeconds(1800)
                .and()
                .withClient("client2").secret("passwordforauthserver")
                .redirectUris("http://localhost:8182/").authorizedGrantTypes("authorization_code", "refresh_token")
                .scopes("myscope").autoApprove(true).accessTokenValiditySeconds(30).refreshTokenValiditySeconds(1800);
	}

    /**
     * 配置 JwtAccessToken 转换器
     * @param endpoints
     * @throws Exception
     */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.accessTokenConverter(jwtAccessTokenConverter()).userDetailsService(userDetailsService);
	}

    /**
     * 使用非对称加密算法来对Token进行签名
     * @return
     */
	@Bean
	public JwtAccessTokenConverter jwtAccessTokenConverter() {
		KeyStoreKeyFactory keyStoreKeyFactory = new KeyStoreKeyFactory(keystore, keystorePassword.toCharArray());
		KeyPair keyPair = keyStoreKeyFactory.getKeyPair(keyAlias, keyPassword.toCharArray());
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setKeyPair(keyPair);
		return converter;
	}
}
