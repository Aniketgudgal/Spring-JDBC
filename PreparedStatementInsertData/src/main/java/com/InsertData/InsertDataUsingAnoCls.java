package com.InsertData;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

public class InsertDataUsingAnoCls {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		JdbcTemplate temp = (JdbcTemplate)context.getBean("temp");
		if(temp != null)
		{
			Scanner sc = (Scanner)context.getBean("sc");
			System.out.print("Enter the Student Name: ");
			final String name = sc.nextLine();
			System.out.print("Enter the roll Number: ");
			final int roll = sc.nextInt();
			PreparedStatementSetter pst = new PreparedStatementSetter() {
				
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					ps.setString(1, name);
					ps.setInt(2, roll);
				}
			};
			int result = temp.update("insert into student values ('0',?,?)", pst);
			if (result > 0) {
				System.out.println("Data inserted");
			} else {
				System.out.println("Problem to insert data");
			}
		}
		else {
			System.out.println("problem to connect");
		}
		context.close();
	}
}
