package com.st.fox.business.admin.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.st.fox.business.admin.aop.AuthorizationInterceptor;
import com.st.fox.business.admin.aop.TokenArgumentResolver;

/**
 * @author luozhonghua
 */
@Configuration
public class WebMvcConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	private AuthorizationInterceptor	authorizationInterceptor;

	@Override
	public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
		argumentResolvers.add(new TokenArgumentResolver());
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// 注册监控拦截器
		registry.addInterceptor(authorizationInterceptor).addPathPatterns("/**");
		super.addInterceptors(registry);
	}
}
