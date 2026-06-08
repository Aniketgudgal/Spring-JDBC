package com.InsertData;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component("pmt")
@Setter
@Getter
public class PreStatement implements PreparedStatementSetter{
	private String name;
	private int deptId;
	private int salary;
	private int joinData;
	@Override
	public void setValues(PreparedStatement ps) throws SQLException {
		ps.setString(1, name);
		ps.setInt(2, deptId);
		ps.setInt(3, salary);
		ps.setInt(4, joinData);
	}

}
