package org.spring.boot.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author visakh
 *
 */
@SpringBootApplication
public class App 
{
	public static void main(String[] args)
	{
		System.out.println("Starting Spring Boot App...");
		ApplicationContext context = SpringApplication.run(App.class, args);
		String[] beans = context.getBeanDefinitionNames();
		for(String bean : beans)
		{
			System.out.println("Bean: " + bean);
		}
		System.out.println("Application Started...");
	}
}
