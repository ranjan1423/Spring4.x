package com.mywebstore.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppDispatcherServletInitializer  extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class [] {DataSourceConfig.class};
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class [] {WebMvcConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		 return new String[] { "/" };
	}
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
	}
}
