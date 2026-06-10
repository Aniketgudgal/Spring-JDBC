package com.crud.Config;

import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages = {"com.crud"})
public class Config {
	@Bean
	public DriverManagerDataSource getSource()
	{
		DriverManagerDataSource dm = new DriverManagerDataSource();
		dm.setUrl("jdbc:mysql://localhost:3306/crud");
		dm.setUsername("root");
		dm.setPassword("Pass@12345");
		return dm;
	}
	@Bean(name = "getTemplate")
	public JdbcTemplate geTemplate()
	{
		return new JdbcTemplate(this.getSource());
	}
	@Bean(name = "sc")
	public Scanner getScanner()
	{
		return new Scanner(System.in);
	}
}
