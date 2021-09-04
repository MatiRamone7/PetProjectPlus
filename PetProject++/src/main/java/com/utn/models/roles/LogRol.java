package com.utn.models.roles;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "logrol")
public class LogRol implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "fechaNacimiento", columnDefinition = "DATE")
    private Date fechaHora;

    @ManyToOne
    @JoinColumn(name = "rol_id", referencedColumnName = "id")
    private Rol rol;


    public String generarLogRol(){
        String strDateFormat = "hh: mm: ss a dd-MMM-aaaa";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        return objSDF.format(this.fechaHora);
    }

    public Integer getId() {
        return id;
    }

    public Date getFechaHora() { return fechaHora; }
    public void setFechaHora(Date fechaHora) { this.fechaHora = fechaHora; }

    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }
}