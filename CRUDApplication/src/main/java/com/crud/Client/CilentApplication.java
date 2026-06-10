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
			System.out
					.println("1.Insert Employee \n2.View Employee \n3. Update Employee \n4. Delete Employee \n5. Exit");
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
					System.out.println("Problem to Add Employee Age Greate than 18: " + e2);
				}
				break;
			case 2:
				List<Employee> al = empService.getEmployees();
				al.forEach((emp) -> System.out.println(emp));
				break;
			case 3:
				System.out.println("Select Following Updates of Employee");
				System.out.println("1. Name Update \n2. Email Update \n3. Age Update \n4.Exit");
				int update = sc.nextInt();
				switch (update) {
				case 1:
					System.out.println("Enter the Employee Id: ");
					int id = sc.nextInt();
					System.out.print("Enter the Name: ");
					String empName = sc.next();
					if (empService.updateEmployee(id, empName)) {
						System.out.println("Name Updated Successfully.....");
					} else {
						System.out.println("Problem to Update Name");
					}
					break;
				case 2:
					System.out.println("Enter the Employee Id: ");
					id = sc.nextInt();
					System.out.print("Enter the Email Id: ");
					String empEmail = sc.next();
					if (empService.updateEmployeeEmail(id, empEmail)) {
						System.out.println("Email Update Succesfully");
					} else {
						System.out.println("Problem to Update Email");
					}
					break;
				case 3:
					System.out.println("Enter the Employee Id: ");
					id = sc.nextInt();
					System.out.print("Enter the Age: ");
					int empAge = sc.nextInt();
					if (empService.updateEmployee(id, empAge)) {
						System.out.println("Employee Age Updated Successfully...");
					} else {
						System.out.println("Problem to Update Age");
					}
					break;
				case 4:
					break;
				default:
					System.out.println("Enter Valid input");
					break;
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
