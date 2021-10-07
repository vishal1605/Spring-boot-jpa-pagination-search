package com.firstboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.firstboot.controller.BootFilter;

@Configuration
public class BootConfig implements WebMvcConfigurer {
	
	
	@Bean
	public BootFilter getInterceptor() {
		return new BootFilter();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getInterceptor()).addPathPatterns("/register");
		
		
	}
	
	

}
