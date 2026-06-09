package com.InsertData;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"com.InsertData"})
public class Config {
	
	@Bean("data")
	public DriverManagerDataSource getSource()
	{
		return new DriverManagerDataSource("jdbc:mysql://localhost:3306/demo_123","root","Pass@12345");
	}
	@Bean("temp")
	public JdbcTemplate getTemplate()
	{
		return new JdbcTemplate(this.getSource());
	}
	@Bean("sc")
	public Scanner getScanner()
	{
		return new Scanner(System.in);
	}
}  
