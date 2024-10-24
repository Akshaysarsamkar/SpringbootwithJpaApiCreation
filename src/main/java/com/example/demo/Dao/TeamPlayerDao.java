package com.example.demo.Dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entity.Player;

public interface TeamPlayerDao extends CrudRepository<Player, Integer> {
   
}
