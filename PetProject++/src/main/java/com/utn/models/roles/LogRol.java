package com.utn.models.roles;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogRol {
    private Date fechaHora;
    private Rol rol;

    public LogRol(Date fechaHora, Rol rol) {
        this.fechaHora = fechaHora;
        this.rol = rol;
    }

    public String generarLogRol(){
        String strDateFormat = "hh: mm: ss a dd-MMM-aaaa";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        return objSDF.format(this.fechaHora);
    }

    //getter and setter
    public Date getFechaHora() {
        return fechaHora;
    }
    public void setFechaHora(Date fechaHora) {
        this.fechaHora = fechaHora;
    }

    public Rol getRol() {
        return rol;
    }
    public void setRol(Rol rol) {
        this.rol = rol;
    }
}