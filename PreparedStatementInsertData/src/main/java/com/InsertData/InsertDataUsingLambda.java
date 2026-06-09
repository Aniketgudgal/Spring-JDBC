package com.InsertData;

import java.sql.PreparedStatement;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

public class InsertDataUsingLambda {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		JdbcTemplate temp = (JdbcTemplate)context.getBean("temp");
		if (temp != null) {
			Scanner sc = (Scanner)context.getBean("sc");
			System.out.print("Enter the Student Name: ");
			final String name = sc.nextLine();
			System.out.print("Enter the roll number: ");
			final int rollNo = sc.nextInt();
			int result = temp.update("insert into student value ('0',?,?)",(PreparedStatement ps) -> {
				ps.setString(1, name);
				ps.setInt(2, rollNo);
				System.out.println("Data inserted");
				context.close();
			});
		} else {
			System.out.println("Problem to connect");
		}
	}

}
