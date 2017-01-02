package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class MybatisDemoMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ConfigurableApplicationContext configContext = SpringApplication.run(MybatisDemoMain.class, args);
		System.out.println("\n\n configContext: " + configContext.getBeanDefinitionCount());
		
		

	}

}
