package com.utn.controllers;

import com.utn.models.Ong;
import com.utn.services.IOngService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/ongs")
public class OngController {

    @Autowired
    IOngService ongService;

    @PostMapping
    public Ong Create(@RequestBody Ong ong) throws IOException {
        return ongService.Create(ong);
    }
}
