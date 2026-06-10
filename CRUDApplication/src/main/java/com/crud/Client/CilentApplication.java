package com.crud.Client;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.crud.Config.Config;
import com.crud.Model.Employee;
import com.crud.Service.EmpService;

public class CilentApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		int exit = 0;
		Scanner sc = (Scanner) context.getBean("sc");
		System.out.println("Welcome to CRUD Application");
		do {
			System.out.println("1.Insert Employee \n2.View Employee \n3. Update Employee \n4. Delete Employee \n5. Exit");
			int choose = sc.nextInt();
			switch (choose) {
			case 1:
				System.out.print("Enter the name: ");
				String name = sc.next();
				System.out.println("Enter email Id: ");
				String email = sc.next();
				System.out.println("Enter the age: ");
				int age = sc.nextInt();
				Employee e = new Employee();
				e.setName(name);
				e.setEmail(email);
				e.setAge(age);
				EmpService empService = (EmpService) context.getBean("empService");
				if (empService.insertEmployee(e)) {
					System.out.println("Employee Added Successfully...");
				} else {
					System.out.println("Problem to Add Employee");
				}
				break;
			
			case 5:
				exit = 1;
				System.out.println("Exit");
				break;
			default:
				System.out.println("Enter Vaild Choose");
				break;
			}
		} while (exit != 1);
	}

}
