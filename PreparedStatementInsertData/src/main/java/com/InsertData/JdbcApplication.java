package com.InsertData;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class JdbcApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		JdbcTemplate temp = (JdbcTemplate)context.getBean("temp");
		if(temp != null)
		{
			Scanner sc = (Scanner)context.getBean("sc");
			PreStatement p = (PreStatement)context.getBean("pmt");
			System.out.print("Enter the name: ");
			p.setName(sc.next());
			System.out.print("Enter the Department id: ");
			p.setDeptId(sc.nextInt());
			System.out.print("Enter the Salary: ");
			p.setSalary(sc.nextInt());
			System.out.print("Enter joining date: ");
			p.setJoinData(sc.nextInt());
			int result = temp.update("insert into employee value('0',?,?,?,?)", p);
			if(result > 0)
			{
				System.out.println("Data Inserted");
			}
			else
			{
				System.out.println("Problem to insert data");
			}
		}
		else
		{
			System.out.println("Problem to Connect DB");
		}
	}

}
