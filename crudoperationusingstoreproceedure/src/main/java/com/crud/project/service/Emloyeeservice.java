package com.crud.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.project.repository.EmployeeRepository;

@Service
public class Emloyeeservice {

	@Autowired
	EmployeeRepository employeeRepository;

	public void insertData(String name, double sal) {
		// TODO Auto-generated method stub
		employeeRepository.insertData(name, sal);

	}

	public List<Map<String, Object>> getAlldata() {

		// TODO Auto-generated method stub
		return employeeRepository.getData();
	}

	public void updateData(int id,String name, double sal) {
		// TODO Auto-generated method stub
		
		employeeRepository.updateData(id,name, sal);

	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		
		employeeRepository.deleteData(id);
		
	}
	public List<Map<String, Object>> getDatabyid(int id)
	{
		return employeeRepository.getDataById(id);
	}

}
