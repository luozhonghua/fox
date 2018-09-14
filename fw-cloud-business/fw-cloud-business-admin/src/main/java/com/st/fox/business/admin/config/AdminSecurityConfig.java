package com.st.fox.business.admin.config;

import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;

/**
 * Created by luozhonghua on 2018/9/13.
 */
//@EnableOAuth2Sso
@Configuration
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class AdminSecurityConfig //extends WebSecurityConfigurerAdapter
{

    //@Override
//    public void configure(HttpSecurity http) throws Exception {
//        http.antMatcher("/**")
//                .authorizeRequests() //请求授权，后面的需要授权
//                .antMatchers("/", "/login**").permitAll()  //login无需权限验证
//                .anyRequest()
//                .authenticated(); //其他所有路径都需要权限校验
//    }

}