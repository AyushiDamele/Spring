package com.telusko;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

// Replacement of web.xml file for annotation based configuration
public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override 
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {TeluskoConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] {"/"} ;
	}

}
