package com.utn.transithomes;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdapterApiRestHogaresDeTransito implements AdapterRefugios{
    private static AdapterApiRestHogaresDeTransito instancia = null;
    private static final String urlAPI = "https://api.refugiosdds.com.ar/api/";
    private Retrofit retrofit;

    private static final String token = "Bearer xcW92X2qJDbNbkFT9S0pIGoEETkqx5fcMNgJKRzIjk5Pb6wVi1KMxsQvpKc0";

    private AdapterApiRestHogaresDeTransito(){
        this.retrofit = new Retrofit.Builder()
                .baseUrl(urlAPI)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static AdapterApiRestHogaresDeTransito getInstancia() {
        if (instancia == null){
            instancia = new AdapterApiRestHogaresDeTransito();
        }
        return instancia;
    }

    public ListadoDeRefugios listadoDeRefugios(int offset) throws IOException {
        ServiciosRefugios serviciosRefugios = this.retrofit.create(ServiciosRefugios.class);
        Call<ListadoDeRefugios> pedidoHogares = serviciosRefugios.hogares(token, offset);
        Response<ListadoDeRefugios> responseHogares = pedidoHogares.execute();
        return responseHogares.body();
    }


    public List<Hogar> obtenerHogaresTransito(){

        List<Hogar> listadaAuxiliar = new ArrayList<>();

        ListadoDeRefugios listadoDeRefugios;
        int offset = 0;
        try {
            while (true) {
                offset++;

                listadoDeRefugios = this.listadoDeRefugios(offset);
                listadaAuxiliar.addAll(listadoDeRefugios.hogares);
            }
        }
        catch (Exception e){
        }
        return listadaAuxiliar;
    }




}
