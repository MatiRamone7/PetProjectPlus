package com.utn.controllers;

import com.utn.services.ICaracteristicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/caracteristicas")
public class CaracteristicaController {

    /*
        Caracteristica
    */
    @Autowired
    ICaracteristicaService caracteristicaService;
}