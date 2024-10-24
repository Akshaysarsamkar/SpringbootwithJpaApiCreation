package com.example.demo.Dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entity.Car;

public interface CarDao extends CrudRepository<Car, Integer> {
	
	List<Car> findByCarNameEquals(String name);
	List<Car> findByIdBetween(int a,int b); 
	

}
