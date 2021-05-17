package com.utn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.utn.services.IUserService;

@RestController
@RequestMapping("/")
public class APIRestController {

	@Autowired
	IUserService userService;
	
	@GetMapping("users")
	public String GetUsers() {
		return userService.GetUsers().toString();
	}
	
	@GetMapping("users/{id}")
	public String GetUserById(@PathVariable Integer id) {
		return userService.GetUserById(id).toString();
	}
}
