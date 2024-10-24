package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Dao.JaksonDao;
import com.example.demo.Entity.Village;

@Component
public class JaksonService {

	@Autowired
	private JaksonDao dao;

	public List<Village> InsertUsers(List<Village> villages) {
		List<Village> list = (List<Village>) dao.saveAll(villages);
		return list;
	}
	
	public List<Village> fetchData() {
		List<Village> all = (List<Village>) dao.findAll();
		return all;
	}

}
