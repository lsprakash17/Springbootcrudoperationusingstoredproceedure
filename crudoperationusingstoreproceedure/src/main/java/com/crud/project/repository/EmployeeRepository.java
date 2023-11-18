package com.crud.project.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeRepository {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public EmployeeRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insertData( String name, double Salary) {
		String querry = "CALL sp_create_employee(?,?)";
		jdbcTemplate.update(querry,name,Salary);
	}

	public List<Map<String, Object>> getData() {
		String sql = "CALL sp_get_all_employees";
		return jdbcTemplate.queryForList(sql);
	}

	public void updateData(int id, String newname, double salary) {
		String sql = "CALL sp_update_employee(?,?,?)";
		jdbcTemplate.update(sql, id, newname, salary);
	}
	
	 public void deleteData(int id) {
	        String sql = "CALL sp_delete_employee(?)";
	        jdbcTemplate.update(sql, id);
	    }
	 
	 public List<Map<String, Object>> getDataById( int id) {
	        String sql = "CALL sp_get_employee_by_id(?)";
	        return jdbcTemplate.queryForList(sql, id);
	    }
	 


}
