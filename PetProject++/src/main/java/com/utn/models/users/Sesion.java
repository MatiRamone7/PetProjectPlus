package com.utn.models.users;

import javax.persistence.*;

import com.utn.utils.IValidationSesion;
import com.utn.utils.SesionResponse;

import java.io.Serializable;
import java.util.Set;

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

    @Column
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "authorities_users", joinColumns = @JoinColumn(name = "usuario_id"), inverseJoinColumns = @JoinColumn(name = "authority_id"))
    private Set<Authority> authority;

    @Transient
    public IValidationSesion validationSesion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Set<Authority> getAuthority() {
        return authority;
    }

    public void setAuthority(Set<Authority> authority) {
        this.authority = authority;
    }

    public void setAuthority(Authority authority) {
        this.authority.add(authority);
    }

    public IValidationSesion getValidationSesion() {
        return validationSesion;
    }

    public void setValidationSesion(IValidationSesion validationSesion) {
        this.validationSesion = validationSesion;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Sesion other = (Sesion) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
    }

    public Sesion(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Sesion() {
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
