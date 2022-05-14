package com.claim.Dealership;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;


import com.claim.springmvc.SpringMvcApplication;

@SpringBootApplication
@ComponentScan(basePackages="com.claim")
public class DealershipApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringMvcApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DealershipApplication.class, args);
	}

}
