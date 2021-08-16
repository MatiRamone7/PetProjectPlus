package com.utn.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="publicacion")
public class Publication implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Column(name = "foto")
    private String foto;

    @Column(name = "lugarEncuentro")
    private String lugarEncuentro;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ongId")
    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    private Ong ong;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getLugarEncuentro() {
        return lugarEncuentro;
    }

    public void setLugarEncuentro(String lugarEncuentro) {
        this.lugarEncuentro = lugarEncuentro;
    }

    public Ong getOng() {
        return ong;
    }

    public void setOng(Ong ong) {
        this.ong = ong;
    }
}
