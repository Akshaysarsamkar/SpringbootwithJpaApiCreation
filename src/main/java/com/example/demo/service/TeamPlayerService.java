package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Dao.TeamPlayerDao;
import com.example.demo.Entity.Player;

@Component
public class TeamPlayerService {

	@Autowired
	private TeamPlayerDao dao;

	public List<Player> InsertPlayers(List<Player> list) {
		List<Player> saveAll = (List<Player>) dao.saveAll(list);
		return saveAll;
	}

	public List<Player> GetPlayers() {
		List<Player> all = (List<Player>) dao.findAll();
		return all;
	}

	public Player getPlayerById(int id) {

		Optional<Player> byId = dao.findById(id);
		Player player = byId.get();
		return player;

	}
}
