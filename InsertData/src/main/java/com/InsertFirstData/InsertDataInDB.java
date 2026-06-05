package com.InsertFirstData;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class InsertDataInDB {

	public static void main(String[] args) {
		DriverManagerDataSource driver = new DriverManagerDataSource();
		driver.setDriverClassName("com.mysql.cj.jdbc.Driver");
		driver.setUrl("jdbc:mysql://localhost:3305/demo_123");
		driver.setUsername("root");
		driver.setPassword("Pass@12345");
		if(driver != null)
		{
			System.out.println("Database is Connected");
		}
		else
		{
			System.out.println("Problem to connect");
		}
	}

}
