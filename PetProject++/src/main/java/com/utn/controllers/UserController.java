package com.utn.controllers;

import com.utn.contactservices.mensajesPredeterminados.CInteresDeAdopcion;
import com.utn.contactservices.mensajesPredeterminados.IMensajePredet;
import com.utn.models.users.Usuario;
import com.utn.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Map;

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

    @GetMapping("notificarUsuario/{id}")
    public void NotifyUser(@RequestBody Map<String, Object> datos, @PathVariable Integer id) throws IOException {
        Usuario user = this.GetUserById(id);
        String cuerpo = (String) datos.get("cuerpo");
        String asunto = (String) datos.get("asunto");

        IMensajePredet mensaje = new IMensajePredet() {
            @Override
            public String cuerpo() {
                return cuerpo;
            }

            @Override
            public String asunto() {
                return asunto;
            }

            @Override
            public void cambiarTexto(String input) {

            }
        };

        user.contactar(mensaje);
    }
}
