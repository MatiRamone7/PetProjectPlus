package com.utn.contactservices.services;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.io.IOException;

import com.utn.contactservices.MWhatsapp;

public class Wabox {
    private static MWhatsapp instancia = null;
    private static final String urlApi = "https://www.waboxapp.com/api/send/chat";
    private Retrofit retrofit;

    public Wabox() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(urlApi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static MWhatsapp instancia(){
        if(instancia== null){
            instancia = new MWhatsapp();
        }
        return instancia;
    }

    public WhatsappRespuesta enviarWhatsapp(String token, String numero, String to, String id, String texto) throws IOException {
        WhatsappWaboxService waboxService = this.retrofit.create(WhatsappWaboxService.class);
        Call<WhatsappRespuesta> respuesta = waboxService.contactarUsuario(token,numero,to,id,texto);
        Response<WhatsappRespuesta> responseRespuesta = respuesta.execute();
        return responseRespuesta.body();
    }
}