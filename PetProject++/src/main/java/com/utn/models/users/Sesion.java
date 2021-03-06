package com.utn.models.users;

import javax.persistence.*;

import com.utn.utils.IValidationSesion;
import com.utn.utils.SesionResponse;

import java.io.Serializable;

@Entity
@Table(name="sesion")
public class Sesion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username", nullable = false)
    public String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Transient
    public IValidationSesion validationSesion;

    public Sesion(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Sesion() {

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
    
    //TODO login logout registrarse y ver todo esto de acá abajo (jose)

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
