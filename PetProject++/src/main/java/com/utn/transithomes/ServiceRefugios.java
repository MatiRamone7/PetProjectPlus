package com.utn.transithomes;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class ServiceRefugios {
    private static ServiceRefugios instancia = null;
    private static final String urlAPI = "https://api.refugiosdds.com.ar/api/";
    private Retrofit retrofit;

    private static final String token = "Bearer xcW92X2qJDbNbkFT9S0pIGoEETkqx5fcMNgJKRzIjk5Pb6wVi1KMxsQvpKc0";

    private ServiceRefugios(){
        this.retrofit = new Retrofit.Builder()
                .baseUrl(urlAPI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static ServiceRefugios getInstancia() {
        if (instancia == null){
            instancia = new ServiceRefugios();
        }
        return instancia;
    }

    public RefugeeList listadoDeRefugios(int offset) throws IOException {
        RefugiosService refugiosService = this.retrofit.create(RefugiosService.class);
        Call<RefugeeList> pedidoHogares = refugiosService.hogares(token, offset);
        Response<RefugeeList> responseHogares = pedidoHogares.execute();
        return responseHogares.body();
    }
}
