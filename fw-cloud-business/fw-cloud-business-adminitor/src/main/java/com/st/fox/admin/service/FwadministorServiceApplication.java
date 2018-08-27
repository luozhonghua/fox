package com.st.fox.admin.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Controller
@Configuration
@EnableDiscoveryClient
@SpringBootApplication
@EnableEurekaClient
//@EnableWebMvc
@MapperScan(basePackages={"com.st.fox.admin.service.dao","com.framework.common.base"})
//@ComponentScan(basePackages = { "com.st.fox.admin.service.dao", "com.st.fox.core", "com.st.fox.business.commons.web", "com.st.fox.system.api" })
public class FWadministorServiceApplication extends WebMvcConfigurerAdapter  {
	
    public static void main(String[] args) {
    	SpringApplication.run(FWadministorServiceApplication.class, args);
    }

}	
