package com.utn.models.roles;

import java.text.SimpleDateFormat;
import java.util.Date;

public class LogRol {

    private Date fechaHora;

    private Rol rol;


    public String generarLogRol(){
        String strDateFormat = "hh: mm: ss a dd-MMM-aaaa";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        return objSDF.format(this.fechaHora);
    }
}