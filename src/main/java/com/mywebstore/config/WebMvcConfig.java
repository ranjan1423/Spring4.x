package com.mywebstore.config;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.mywebstore")
public class WebMvcConfig extends WebMvcConfigurerAdapter {
	
	private static final Logger LOGGER = Logger.getLogger(WebMvcConfig.class);
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		super.addResourceHandlers(registry);
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        LOGGER.info("[WebMvcConfig] :: ResourceHandlers added....");
    }

	@Bean
	public ViewResolver viewResolver() {
		LOGGER.info("[WebMvcConfig] :: sViewResolver bean created....");
		InternalResourceViewResolver irvr = new InternalResourceViewResolver();
		irvr.setViewClass(JstlView.class);
		irvr.setPrefix("/WEB-INF/views/jsp/");
		irvr.setSuffix(".jsp");
		return irvr;
	}
}
