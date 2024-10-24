package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Village {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int vid;
	private String villageName;
	private float Population;

	@OneToOne(cascade = CascadeType.ALL)
	@JsonManagedReference
	private Sarpanch sarpanch;

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getVillageName() {
		return villageName;
	}

	public void setVillageName(String villageName) {
		this.villageName = villageName;
	}

	public float getPopulation() {
		return Population;
	}

	public void setPopulation(float population) {
		Population = population;
	}

	public Sarpanch getSarpanch() {
		return sarpanch;
	}

	public void setSarpanch(Sarpanch sarpanch) {
		this.sarpanch = sarpanch;
	}

	@Override
	public String toString() {
		return "Village [vid=" + vid + ", villageName=" + villageName + ", Population=" + Population + ", sarpanch="
				+ sarpanch + "]";
	}

}
