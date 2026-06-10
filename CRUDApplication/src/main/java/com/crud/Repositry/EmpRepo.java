package com.crud.Repositry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.crud.Model.Employee;

@Component("empRepo")
public class EmpRepo {
	@Autowired
	JdbcTemplate getTemplate;
	public boolean insetEmployee(Employee emp)
	{
		return getTemplate.update("insert into employee value('0',?,?,?)", (t) ->{
			t.setString(1, emp.getName());
			t.setString(2, emp.getEmail());
			t.setInt(3, emp.getAge());
		}) > 0 ? true:false;
	}
}
