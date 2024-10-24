package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Village;
import com.example.demo.service.JaksonService;

@RestController
public class JaksonAnnotationController {

	@Autowired
	private JaksonService service;

	@PostMapping("/AddData")
	public List<Village> AddUsers(@RequestBody List<Village> villages) {
		List<Village> insertUsers = service.InsertUsers(villages);
		return insertUsers;
	}

	@GetMapping("/data")
	public List<Village> getVillage() {
		List<Village> fetchData = service.fetchData();
		return fetchData;
	}

}
