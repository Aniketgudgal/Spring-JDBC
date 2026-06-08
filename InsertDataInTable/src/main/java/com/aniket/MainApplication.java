package com.aniket;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class MainApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigurationApp.class);
		JdbcTemplate temp = (JdbcTemplate) context.getBean("temp");
		temp.execute("insert into employee values('0','shivtej',1,4500,2026)");
		System.out.println("Data Inserted");
	}
}
