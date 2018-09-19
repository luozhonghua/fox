package com.st.fox.system.server.oauth.resource.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * ResourceServerConfigurerAdapter 用于保护 OAuth2 要开放的资源，同时主要作用于client端以及token的认证(Bearer Auth)，
 * 由于后面 OAuth2 服务端后续还需要提供用户信息，所以也是一个 Resource Server，默认拦截了所有的请求，也可以通过重新方法方式自定义自己想要拦截的资源 URL 地址
 * @ClassName:  ResourceConfigurer
 * @Description:REST API Resource Server.
 * @author: luozhonghua
 * @date:   2018年7月19日 下午2:39:35
 * @version V1.0
 * 
 */
@Configuration
@EnableWebSecurity
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true) // Allow method annotations like @PreAuthorize
public class ResourceConfigurer extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable();
        http.authorizeRequests().anyRequest().authenticated();
    }

}
