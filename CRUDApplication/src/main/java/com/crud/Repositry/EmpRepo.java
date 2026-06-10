package com.crud.Repositry;

import java.util.ArrayList;
import java.util.List;

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
	public List<Employee> getEmployee()
	{
		List<Employee> al = (List<Employee>) getTemplate.query("select * from Employee",(r,n) ->{
			return new Employee(r.getInt(1), r.getString(2), r.getString(3), r.getInt(4));
		});
		return al;
	}
}
