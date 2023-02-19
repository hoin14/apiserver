package com.code.api.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpringMvcConfig implements WebMvcConfigurer{
	
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/**").addResourceLocations("classpath:/templates/").setCachePeriod(31556926);
		//registry.addResourceHandler("/css/**").addResourceLocations("/css/").setCachePeriod(31556926);
		//registry.addResourceHandler("/images/**").addResourceLocations("/images/").setCachePeriod(31556926);
		//registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
		
	}
	
}
