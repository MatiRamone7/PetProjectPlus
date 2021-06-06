package com.utn.utils;

import java.util.ArrayList;
import java.util.List;

public class SesionResponse {
    private List<String> error;
    private boolean status;

    public SesionResponse(){
        status = true;
        error = new ArrayList<String>();
    }

    public SesionResponse(boolean status, String mensaje) {
        error = new ArrayList<String>();

        this.status = status;
        if(!status)
            this.error.add(mensaje);
    }

    public boolean isStatus() {
        return status;
    }

    public List<String> getError() {
        return error;
    }

    public void add(SesionResponse response){
        status &= response.isStatus();
        error.addAll(response.error);
    }
}
