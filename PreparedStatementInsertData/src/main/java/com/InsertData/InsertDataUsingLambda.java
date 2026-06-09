package com.InsertData;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class InsertDataUsingLambda {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		JdbcTemplate temp = (JdbcTemplate)context.getBean("");
	}

}
