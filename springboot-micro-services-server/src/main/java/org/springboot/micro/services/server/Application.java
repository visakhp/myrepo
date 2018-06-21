package org.springboot.micro.services.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author PadmakVis
 */
@EnableEurekaServer
@SpringBootApplication
public class Application
{
	private static final Class<Application> applicationClass = Application.class;
	
	public static void main(String[] args)
	{
		SpringApplication.run(applicationClass);
	}
}
