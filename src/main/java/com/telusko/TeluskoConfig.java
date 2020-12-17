package com.telusko;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

// Replacement of Dispatcher Servlet (i.e. telus ko-servlet.xml)
@Configuration
@ComponentScan({"com.telusko"})
public class TeluskoConfig {
	
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB_INF/");
		vr.setSuffix(".jsp");
		return vr;
	}

}
