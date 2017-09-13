package com.springbootclient.weatherappclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.springbootclient.weatherappclient"})
public class WeatherappclientApplication extends SpringBootServletInitializer
{

	public static void main(String[] args)
	{
		SpringApplication.run(WeatherappclientApplication.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)
	{
		return application.sources(WeatherappclientApplication.class);
	}

}
