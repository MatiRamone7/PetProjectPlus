package com.utn.controllers;

import com.utn.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping
    public Iterable<User> GetUsers() {
        return userService.GetUsers();
    }

    @GetMapping("/{id}")
    public User GetUserById(@PathVariable Integer id) {
        return userService.GetUserById(id);
    }

    @PostMapping
    public User Create(@RequestBody User user) {
        return userService.Create(user);
    }

    @PutMapping("/{id}")
    public User Update(@RequestBody User user, @PathVariable Integer id) {
        return userService.Update(user, id);
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable Integer id) {
        userService.Delete(id);
    }
}
