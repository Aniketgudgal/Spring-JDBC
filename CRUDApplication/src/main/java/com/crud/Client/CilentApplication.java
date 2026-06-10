package com.crud.Client;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.crud.Config.Config;
import com.crud.Model.Employee;
import com.crud.Service.EmpService;

public class CilentApplication {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		EmpService empService = (EmpService) context.getBean("empService");
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
				try {
					if (empService.insertEmployee(e)) {
						System.out.println("Employee Added Successfully...");
					} else {
						System.out.println("Problem to Add Employee");
					}
				} catch (Exception e2) {
					System.out.println("Problem to Add Employee Age Greate than 18: "+e2);
				}
				break;
			case 2:
				List<Employee> al = empService.getEmployees();
				al.forEach((emp)->System.out.println(emp.getId()+"\t"+emp.getName()+"\t"+emp.getEmail()+"\t"+emp.getAge()));
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
