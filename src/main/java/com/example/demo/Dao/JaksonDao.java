package com.example.demo.Dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.Entity.Village;

public interface JaksonDao extends CrudRepository<Village, Integer> {

}
