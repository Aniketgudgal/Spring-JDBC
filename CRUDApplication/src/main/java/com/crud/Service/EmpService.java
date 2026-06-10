package com.crud.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crud.Model.Employee;
import com.crud.Repositry.EmpRepo;

@Component("empService")
public class EmpService {
	@Autowired
	EmpRepo empRepo;
	public boolean insertEmployee(Employee emp)
	{
		return empRepo.insetEmployee(emp);
	}
	public List<Employee> getEmployees()
	{
		return empRepo.getEmployee();
	}
	public boolean updateEmployee(int id, String name)
	{
		return empRepo.updateEmployee(id, name);
	}
	public boolean updateEmployee(int id, int age)
	{
		return empRepo.updateEmployee(id, age);
	}
	public boolean updateEmployeeEmail(int id, String email)
	{
		return empRepo.updateEmployeeEmail(id, email);
	}
}
