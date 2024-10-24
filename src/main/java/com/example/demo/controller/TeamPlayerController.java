package com.example.demo.controller;

import java.security.PublicKey;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Player;
import com.example.demo.service.TeamPlayerService;

@RestController
public class TeamPlayerController {

	@Autowired
	private TeamPlayerService service;

	@PostMapping("Players")
	public List<Player> saveAllPlayer(@RequestBody List<Player> list) {
		List<Player> players = service.InsertPlayers(list);
		return players;

	}

	@GetMapping("Players")
	public List<Player> getAllPlayer() {
		List<Player> players = service.GetPlayers();
		return players;
	}

	@GetMapping("Players/{id}")
	public Player PlayerById(@PathVariable("id") int id) {
		Player players = service.getPlayerById(id);
		return players;
	}

}
