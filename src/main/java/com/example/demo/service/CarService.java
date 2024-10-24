package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.Dao.CarDao;
import com.example.demo.Entity.Car;

@Component
public class CarService {

	@Autowired
	private CarDao dao;

	public Car AddCar(Car c) {
		Car car = dao.save(c);
		return car;
	}

	public List<Car> addCars(List<Car> list) {
		Iterable<Car> all = dao.saveAll(list);
		return (List<Car>) all;
	}

	public List<Car> AllCarInfo() {
		List<Car> all = (List<Car>) dao.findAll();
		return all;
	}

	public Car FindCarById(int id) {
		Optional<Car> byId = dao.findById(id);
		Car car = byId.get();
		return car;
	}

	// DeteleMapping
	public void deletecar(int id) {
		Optional<Car> id2 = dao.findById(id);
		Car car = id2.get();
		dao.delete(car);
	}

	// put Mapping

	public Car updateInfo(Car car, int id) {
		Optional<Car> byId = dao.findById(id);
		Car car2 = byId.get();
		car2.setCarModel(car.getCarModel());
		car2.setCarName(car.getCarName());
		car2.setPrice(car.getPrice());
		Car save = dao.save(car2);
		return save;
	}

	public List<Car> GetCars(int a, int b) {

		List<Car> byIdBetween = dao.findByIdBetween(a, b);

		return byIdBetween;

	}

}
