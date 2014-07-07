package org.lanqiao.web.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import javacommon.ijdbc.RowMapper;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs) throws SQLException {

		return new Employee(rs.getInt("employee_id"), rs.getString("first_name"),
				rs.getString("last_name"), rs.getDouble("salary"));
	}

}
