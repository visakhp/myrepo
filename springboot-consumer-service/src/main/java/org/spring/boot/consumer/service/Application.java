package org.spring.boot.consumer.service;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author PadmakVis
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Application extends SpringBootServletInitializer
{

	private static final Class<Application> applicationClass = Application.class;
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
		return application.sources(applicationClass);
	}

}
