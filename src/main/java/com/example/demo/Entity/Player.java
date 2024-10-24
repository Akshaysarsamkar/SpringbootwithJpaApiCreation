package com.example.demo.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Player {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pid;
	private String name;
	private String address;

	@OneToOne(cascade = CascadeType.ALL)
	private IplTeam iplTeam;

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public IplTeam getIplTeam() {
		return iplTeam;
	}

	public void setIplTeam(IplTeam iplTeam) {
		this.iplTeam = iplTeam;
	}

	@Override
	public String toString() {
		return "Player [pid=" + pid + ", name=" + name + ", address=" + address + ", iplTeam=" + iplTeam + "]";
	}

}
