package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class IplTeam {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int tid;
	
	private String teamName;

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	@Override
	public String toString() {
		return "IplTeam [tid=" + tid + ", teamName=" + teamName + "]";
	}

}
