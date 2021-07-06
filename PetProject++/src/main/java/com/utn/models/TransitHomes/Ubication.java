package com.utn.models.TransitHomes;


import com.google.gson.annotations.SerializedName;

public class Ubication {
    private String direccion;
    private double lat;
    @SerializedName("long")
    private double lon;

    public Ubication(String direccion, double lat, double lon) {
        this.direccion = direccion;
        this.lat = lat;
        this.lon = lon;
    }

    public String getDireccion() {
        return direccion;
    }

    public double getLat() {
        return lat;
    }

    public double getLong() {
        return lon;
    }
}
