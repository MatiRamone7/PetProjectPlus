package com.utn.controllers;

import com.utn.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.utn.services.IUserService;

@RestController
@RequestMapping("/")
public class APIRestController {

	@Autowired
	IUserService userService;
	
	@GetMapping("users")
	public Iterable<User> GetUsers() {
		return userService.GetUsers();
	}
	
	@GetMapping("users/{id}")
	public User GetUserById(@PathVariable Integer id) {
		return userService.GetUserById(id);
	}

	@PostMapping("users")
	public User Create(@RequestBody User user) {
		return userService.Create(user);
	}

	/*
	@PutMapping("/{id}")
	public Car Update(@RequestBody Car car, @PathVariable Integer id) {
		return carService.Update(car);
	}

	@DeleteMapping("/{id}")
	public void Delete(@PathVariable Integer id) {
		carService.Delete(id);
	}
	*/
}
