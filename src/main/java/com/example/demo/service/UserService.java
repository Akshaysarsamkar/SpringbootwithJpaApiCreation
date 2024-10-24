package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.demo.Entity.User;

@Component
public class UserService {

	public static List<User> users = new ArrayList<>();

	static {
		users.add(new User(152, "sam", "asfasd", 5.2f));
		users.add(new User(142, "ram", "dbfjs", 5.8f));
		users.add(new User(112, "sham", "Abcd", 5.7f));
	}

	public List<User> getAllUserList() {
		return users;
	}

	public User getUserById(int id) {
		User user = null;
		try {
			user = users.stream().filter(e -> e.getId() == id).findFirst().get();
		} catch (Exception e2) {
			e2.getStackTrace();
		}
		return user;
	}

	public User getUserByName(String name) {
		User user = null;

		user = users.stream().filter(e -> e.getName().equals(name)).findFirst().get();

		return user;
	}

	// PostMapping methods
	public User AddUser(User user) {
		users.add(user);
		return user;
	}

	public List<User> AddUsers(List<User> list) {

		list.forEach(e -> {
			users.add(e);
		});
		return users;
	}

	// delete Mapping
	public void deleteData(int id) {
		users = users.stream().filter(u -> u.getId() != id).collect(Collectors.toList());
	}

	// put mapping
	public User Update(User user, int id) {

		User user2 = users.stream().filter(e -> e.getId() == id).findFirst().get();
		user2.setAddress(user.getAddress());
		user2.setName(user.getName());
		user2.setSalary(user.getSalary());
		return user2;

	}
}
