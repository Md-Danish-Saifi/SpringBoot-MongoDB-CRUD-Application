package com.mongo.demo.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.mongo.demo.model.EmployeeModel;
import com.mongo.demo.repository.EmployeeRepository;
import com.mongo.demo.service.EmployeeService;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	EmployeeRepository emprepo;
	@Autowired
	EmployeeService empser;
	
	@RequestMapping("/")
	@ResponseBody
	public String welcome() {
		return "welcom on spring boot mongoDB controller";

	}	
	
	@GetMapping("/allemp")
	@ResponseBody
	public Map<String,Object> allEmployee() {
		Map<String, Object> data = new HashMap<>();
		List<EmployeeModel> lst = new ArrayList<>();
		try {
			lst = emprepo.findAll();
		} catch (Exception e) {
			data.put("Result", "Failed to get information");
			return data;
		}
		data.put("Result", "Success");
		data.put("products", lst);
		return data;

	}
	@PostMapping("/save")
	public Map<String, Object> saveEmployee(@RequestBody EmployeeModel emp) {
		Map<String, Object> data = new HashMap<>();
		EmployeeModel exist = emprepo.findByEmail(emp.getEmail());
		if(exist!=null)
		{
			data.put("Result", "Success");
			data.put("products", "user "+emp.getName()+" already registerd ");
			return data;
			
		}
		empser.saveEmployee(emp);
		data.put("Result", "Success");
		data.put("products", "user "+ emp.getName()+" successfully registerd");
		return data;
		
	}
	
	@PostMapping("/login")
	public Map<String,Object> logInEmployee(@RequestBody EmployeeModel emp) {
		Map<String, Object> data = new HashMap<>();
		
		EmployeeModel exist = emprepo.findByEmailAndPassword(emp.getEmail(),emp.getPassword());
		if(exist!=null)
		{
			data.put("userInfo", exist);
			return data;
			
		}
		data.put("userInfo", "invalid credentials/not found");
		return data;
	}
	@PostMapping("/delete")
	public Map<String, Object> deleteEmployee(@RequestBody EmployeeModel emp) {
		Map<String, Object> data = new HashMap<>();
		EmployeeModel exist = emprepo.findByEmail(emp.getEmail());
		if(exist!=null)
		{
			emprepo.deleteByEmail(emp.getEmail());
			data.put("Result", "Success");
			data.put("products", "user "+emp.getName()+" deleted successfully ");
			return data;
			
		}
		data.put("Result", "Failed");
		data.put("products", "user "+emp.getName()+" not  found ");
		return data;
		
	}
	@PostMapping("/update")
	public Map<String, Object> updateEmployee(@RequestBody EmployeeModel emp) {
		Map<String, Object> data = new HashMap<>();
		EmployeeModel exist = emprepo.findByEmail(emp.getEmail());
		if(exist!=null)
		{
			exist.setDesignation(emp.getDesignation());
			exist.setEmail(emp.getEmail());
			exist.setName(emp.getName());
			exist.setPassword(emp.getPassword());
			empser.saveEmployee(exist);
			data.put("Result", "Success");
			data.put("products", "user "+emp.getName()+" successfully updated");
			return data;
		}
		data.put("Result", "Failed");
		data.put("products", "user not found");
		return data;
		
	}
}
