package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Sarpanch {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;

	@OneToOne(mappedBy = "sarpanch")
	@JsonBackReference
	private Village village;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Village getVillage() {
		return village;
	}


	public void setVillage(Village village) {
		this.village = village;
	}

	@Override
	public String toString() {
		return "Sarpanch [id=" + id + ", name=" + name + ", village=" + village + "]";
	}

}
