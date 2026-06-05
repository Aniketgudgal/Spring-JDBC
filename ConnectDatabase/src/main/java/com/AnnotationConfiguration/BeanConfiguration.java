package com.AnnotationConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"com.AnnotationConfiguration"})
public class BeanConfiguration {
	
	@Bean(name = "driver")
	public DriverManagerDataSource getConntection()
	{
		DriverManagerDataSource driver = new DriverManagerDataSource();
		driver.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driver.setUrl("jdbc:mysql://localhost:3306/demo_123");
		driver.setUsername("root");
		driver.setPassword("Pass@12345");
		return driver;
	}
}
