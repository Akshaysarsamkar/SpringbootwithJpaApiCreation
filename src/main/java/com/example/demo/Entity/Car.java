package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String carName;
	private String carModel;
	private float price;
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Car(int id, String carName, String carModel, float price) {
		super();
		this.id = id;
		this.carName = carName;
		this.carModel = carModel;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCarName() {
		return carName;
	}
	public void setCarName(String carName) {
		this.carName = carName;
	}
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", carName=" + carName + ", carModel=" + carModel + ", price=" + price + "]";
	}
	
	
	
	

}
