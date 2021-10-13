package com.utn.loginSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping({"/","/login"})
    public String index() {
        return "indexPrueba";
    }

    @GetMapping({"/index"})
    public String index2() {
        return "index_General";
    }

    @GetMapping("/menu")
    public String menu() {
        return "menu";
    }

    @GetMapping("/user")
    public String user() {
        return "perfil";
    }

    @GetMapping("/admin")
    public String admin() {
        return "pantallaAdmin";
    }
}
