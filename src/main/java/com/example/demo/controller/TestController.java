package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.service.UserService;

@RestController
public class TestController {

	@Autowired
	private UserService service;

	@GetMapping("/example")
	@ResponseBody
	public String getMappingExample() {
		return "this is get mapping example";
	}

	@GetMapping("/mapping")
	@ResponseBody
	public String anotherExample() {
		return "GetMapping Request is used for mapping get request onto specific handler methods";
	}

	@GetMapping("/users")
	@ResponseBody
	public User getuser() {
		User user = new User();
		user.setAddress("Cfdsf");
		user.setId(12);
		user.setName("Akshay");
		user.setSalary(2.5f);
		return user;
	}

	@GetMapping("/alluser")
	public ResponseEntity<List<User>> getAllUser() {

		List<User> userList = service.getAllUserList();

		if (userList.size() <= 0) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(userList));
	}

	@GetMapping("/User/{id}")
	public ResponseEntity<User> getusers(@PathVariable("id") int id) {

		User user = service.getUserById(id);
		if (user == null) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.of(Optional.of(user));
	}

	@GetMapping("/Users/{name}")
	public User UserByName(@PathVariable("name") String name) {
		return service.getUserByName(name);
	}

	// Post Mapping
	@PostMapping("/adduser")
	public User addUser(@RequestBody User user) {
		User addUser = service.AddUser(user);
		return addUser;
	}

	// Post Mapping
	@PostMapping("/addusers")
	public List<User> addUsers(@RequestBody List<User> user) {
		List<User> addUsers = service.AddUsers(user);
		System.out.println(user);
		return addUsers;
	}

	// delete Mapping
	@DeleteMapping("/user/{id}")
	public void DeleteUser(@PathVariable("id") int id) {
		service.deleteData(id);
	}

	// put mapping
	@PutMapping("/user/{id}")
	public User updateUser(User user, @PathVariable("id") int id) {
		user.setAddress("Ranjangav");
		user.setName("harshavandhan");
		user.setSalary(7.45f);
		User update = service.Update(user, id);
		return update;
	}
}
