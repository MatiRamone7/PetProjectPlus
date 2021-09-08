package com.utn.models.users;

import javax.persistence.*;

import com.utn.utils.IValidationSesion;
import com.utn.utils.SesionResponse;

public class Sesion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    public String username;

    @Column(name = "password")
    private String password;

    @Transient
    public IValidationSesion validationSesion;

    public Sesion(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public IValidationSesion getValidationSesion() {
        return validationSesion;
    }

    public void setValidationSesion(IValidationSesion validationSesion) {
        this.validationSesion = validationSesion;
    }

    public void login(){
        //TODO login logout
    }

    public void logout(){

    }

    public SesionResponse validarUsuarioYPass(String user, String pass){
        return null;
    }

    public SesionResponse registrar(IValidationSesion sesion){
        return null;
    }

    public void registrarse(IValidationSesion sesion){

    }

    public void sesion(IValidationSesion sesion){

    }
}
