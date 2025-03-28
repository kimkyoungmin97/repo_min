package com.a5a5lab.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.a5a5lab.common.intercepter.CheckLoginSessionInterceptor;

@Configuration
public class WebMvcConfigurerImpl implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CheckLoginSessionInterceptor())
//				.order(1)
				.addPathPatterns("/*Xdm*")
				.excludePathPatterns(
						"/loginXdm",
						"/signinXdmProc",
						"/signoutXdmProc"
						);
				
	 WebMvcConfigurer.super.addInterceptors(registry);
	}
	

}
