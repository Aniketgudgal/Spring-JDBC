package com.AnnotationConfiguration;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class AnnotationBeanApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfiguration.class);
		DriverManagerDataSource dm = (DriverManagerDataSource) context.getBean("driver");
		System.out.println(dm != null ? "Database Connected": "problem to connect");
	}

}
