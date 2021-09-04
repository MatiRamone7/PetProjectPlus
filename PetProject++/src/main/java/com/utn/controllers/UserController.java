package com.utn.controllers;

import com.utn.models.users.Usuario;
import com.utn.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    IUserService userService;

    @GetMapping
    public Iterable<Usuario> GetUsers() {
        return userService.GetUsers();
    }

    @GetMapping("/{id}")
    public Usuario GetUserById(@PathVariable Integer id) {
        return userService.GetUserById(id);
    }

    @PostMapping
    public Usuario Create(@RequestBody Usuario user) {
        return userService.Create(user);
    }

    @PutMapping("/{id}")
    public Usuario Update(@RequestBody Usuario user, @PathVariable Integer id) {
        return userService.Update(user, id);
    }

    @DeleteMapping("/{id}")
    public void Delete(@PathVariable Integer id) {
        userService.Delete(id);
    }
}
