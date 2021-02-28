package com.mongo.demo.controller;
import java.util.List;
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
	public List<EmployeeModel> allEmployee() {
		return emprepo.findAll();

	}
	@PostMapping("/save")
	public String saveEmployee(@RequestBody EmployeeModel emp) {
		EmployeeModel exist = emprepo.findByEmail(emp.getEmail());
		if(exist!=null)
		{
			return "employee "+emp.getName()+" already registerd ";
			
		}
		empser.saveEmployee(emp);
		return "employee "+ emp.getName()+" sexfully saved to database";
		
	}
	@PostMapping("/delete")
	public String deleteEmployee(@RequestBody EmployeeModel emp) {
		EmployeeModel exist = emprepo.findByEmail(emp.getEmail());
		if(exist!=null)
		{
			emprepo.deleteByEmail(emp.getEmail());
			return "employee "+ emp.getName()+" sexfully deleted from database";
			
		}
		return "employee "+emp.getName()+" not found ";
		
	}
	@PostMapping("/update")
	public String updateEmployee(@RequestBody EmployeeModel emp) {
		EmployeeModel exist = emprepo.findByEmail(emp.getEmail());
		if(exist!=null)
		{
			exist.setDesignation(emp.getDesignation());
			exist.setEmail(emp.getEmail());
			exist.setName(emp.getName());
			exist.setPassword(emp.getPassword());
			empser.saveEmployee(exist);
			return "employee "+ emp.getName()+" sexfully update in database";
			
		}
		return "employee "+emp.getName()+" not found ";
		
	}
}
