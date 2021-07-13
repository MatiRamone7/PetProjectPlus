package com.utn.models;

import javax.persistence.*;
import java.io.Serializable;
import com.utn.contactservices;

@Entity
@Table(name="contacto")
public class ContactoUnico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "mail")
    public String mail;

    @Column(name = "celular")
    public String celular;

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

    public ContactoUnico(String unMail, String unCelular){
        this.mail = unMail;
        this.celular = unCelular;
    }

    public void contactar(String asunto, String cuerpo) throws IOException {
        MMail.contactar(mail,asunto,cuerpo);
        MSMS.contactar(celular,asunto,cuerpo);
        MWhatsapp.contactar(celular,asunto,cuerpo);
    }

}
