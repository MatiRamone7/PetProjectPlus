package com.utn.loginSecurity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {

    @GetMapping({"/","/login"})
    public String index() {
        return "indexPrueba";
    }

    @GetMapping({"/index2"})
    public String index2() {
        return "index2";
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
