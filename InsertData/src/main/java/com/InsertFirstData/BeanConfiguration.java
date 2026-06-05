package com.InsertFirstData;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class BeanConfiguration {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ConfigurationDB.xml");
		DriverManagerDataSource dm = (DriverManagerDataSource) context.getBean("driver");
		if(dm != null)
		{
			System.out.println("DB Connected");
		}
		else
		{
			System.out.println("Problem to Connect");
		}
	}

}
