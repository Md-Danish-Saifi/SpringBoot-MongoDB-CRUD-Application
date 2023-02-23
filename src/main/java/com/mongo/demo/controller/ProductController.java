package com.mongo.demo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.demo.model.Products;
import com.mongo.demo.repository.EmployeeRepository;
import com.mongo.demo.repository.ProductRepository;
import com.mongo.demo.service.EmployeeService;

@RestController
public class ProductController {

	@Autowired
	ProductRepository repo;
	
	
	@GetMapping("/allproduct")
	@ResponseBody
	public Map<String,Object> allProduct() {
		Map<String, Object> data = new HashMap<>();
		List<Products> lst = new ArrayList<>();
		try {
			lst = repo.findAll();
		} catch (Exception e) {
			data.put("Result", "Failed to get information");
			return data;
		}
		data.put("Result", "Success");
		data.put("products", lst);
		return data;

	}
	@PostMapping("/addproduct")
	public Map<String, Object> saveEmployee(@RequestBody Products prd) {
		Map<String, Object> data = new HashMap<>();

		repo.save(prd);
		data.put("Result", "Success");
		data.put("products", "Product "+ prd.getName()+" successfully added");
		return data;
	}
}
