package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Car;
import com.example.demo.service.CarService;

@RestController
public class TestApiWithJsp {

	@Autowired
	private CarService service;

	@PostMapping("/addCar")
	private Car AddCar(Car car) {
		car.setCarModel("M65");
		car.setCarName("BMW");
		car.setPrice(8.5f);
		Car addCar = service.AddCar(car);
		return addCar;
	}

	@PostMapping("/addCars")
	public List<Car> AddCars(@RequestBody List<Car> list) {
		return service.addCars(list);
	}

	@GetMapping("/Carinfo")
	public List<Car> getAllCarInfo() {
		return service.AllCarInfo();
	}

	@GetMapping("Carinfo/{id}")
	public Car GetUSerById(@PathVariable("id") int id) {
		Car findCarById = service.FindCarById(id);
		return findCarById;
	}

	// delete Mapping
	@DeleteMapping("Carinfo/{id}")
	public void DeleteData(@PathVariable int id) {
		service.deletecar(id);
	}

	// Put Mapping
	@PutMapping("Carinfo/{id}")
	public Car Update(Car car, @PathVariable("id") int id) {

		car.setCarModel("S31");
		car.setCarName("Swift");
		car.setPrice(15.45f);
		Car updateInfo = service.updateInfo(car, id);
		return updateInfo;
	}

	//GetMapping
	@GetMapping("CarInfoId")
	public List<Car> getByid() {
		List<Car> getCars = service.GetCars(1, 51);
		return getCars;
	}

}
