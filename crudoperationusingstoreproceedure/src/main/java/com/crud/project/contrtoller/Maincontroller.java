package com.crud.project.contrtoller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.project.service.Emloyeeservice;

@RestController
@RequestMapping("/api/maheshdalle")
public class Maincontroller {
	@Autowired
	Emloyeeservice service;

	@PostMapping("/insert/data")
	public ResponseEntity<String> insertData(@RequestParam String name, @RequestParam double sal) {
		service.insertData(name, sal);
		return ResponseEntity.ok("Data inserted successfully.");
	}

	@GetMapping("/getalldata")
	public ResponseEntity<List<Map<String, Object>>> getAllData() {
		List<Map<String, Object>> data = service.getAlldata();
		return ResponseEntity.ok(data);

	}

	@PutMapping("/update")
	public ResponseEntity<String> updateData(@RequestParam int id, @RequestParam String name,
			@RequestParam double sal) {
		service.updateData(id, name, sal);
		return ResponseEntity.ok("Data updated successfully.");
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam int id) {
		service.delete(id);
		return ResponseEntity.ok("data deleted successfully");
	}
	
	@GetMapping("/getdatabyid")
	public ResponseEntity<List<Map<String, Object>>> getdataByid(@RequestParam int id)
	{
		List<Map<String, Object>> data=service.getDatabyid(id);
		return ResponseEntity.ok(data);
	}

}
