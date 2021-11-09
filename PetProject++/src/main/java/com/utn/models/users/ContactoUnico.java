package com.utn.models.users;

import javax.persistence.*;

import com.utn.models.contactservices.*;

import java.io.Serializable;
import java.io.IOException;
@Entity
@Table(name="contacto")
public class ContactoUnico implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "mail")
    public String mail;

    @Column(name = "celular")
    public String celular;

    /*@Convert(converter = MedioConverter.class)
    public IMedio medio;*/

    public ContactoUnico(String unMail, String unCelular){
        this.mail = unMail;
        this.celular = unCelular;
    }

    public ContactoUnico(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMail(String mail) { this.mail = mail; }

    public void setCelular(String celular) { this.celular = celular; }

    public String getMail() { return mail; }

    public String getCelular() { return celular; }

/*
    public IMedio getMedio() {
        return medio;
    }

    public void setMedio(IMedio medio) {
        this.medio = medio;
    }
*/
    public void contactar(String asunto, String cuerpo) throws IOException {
        //IMedio.contactar(asunto,cuerpo,this);
       /* MMail m = new MMail();
        MSMS s = new MSMS();
        m.contactar(asunto,cuerpo,this);
        s.contactar(asunto,cuerpo,this);*/
        System.out.println(" \n MENSAJE ENVIADO AL RESCATISTA -------------------------------------------   \n ");
        System.out.println(asunto);
        System.out.println(cuerpo);
    }

}
