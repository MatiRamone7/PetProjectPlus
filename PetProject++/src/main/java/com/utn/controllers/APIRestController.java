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

	@PutMapping("users/{id}")
	public User Update(@RequestBody User user, @PathVariable Integer id) {
		return userService.Update(user, id);
	}

	@DeleteMapping("users/{id}")
	public void Delete(@PathVariable Integer id) {
		userService.Delete(id);
	}
}
