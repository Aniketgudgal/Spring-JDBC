package com.crud.Service;

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
}
