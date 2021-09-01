package com.utn.models.users;

import com.utn.utils.IValidationSesion;
import com.utn.utils.SesionResponse;

public class Sesion { //TODO todo esto
    public String username;
    private String password;
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
