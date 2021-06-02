package com.utn.contactservices;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class Whatsapp {
    private static Whatsapp instancia = null;
    private static final String urlApi = "https://www.waboxapp.com/api/send/chat";
    private Retrofit retrofit;

    private Whatsapp() {
        this.retrofit = new Retrofit.Builder()
                .baseUrl(urlApi)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static Whatsapp instancia(){
        if(instancia== null){
            instancia = new Whatsapp();
        }
        return instancia;
    }

    public WhatsappRespuesta enviarWhatsapp(String token, String numero, String to, String id, String texto) throws IOException {
        WhatsappWaboxService waboxService = this.retrofit.create(WhatsappWaboxService.class);
        Call<WhatsappRespuesta> respuesta = waboxService.contactarUsuario(token,numero,to,id,texto);
        Response<WhatsappRespuesta> responseRespuesta = respuesta.execute();
        return responseRespuesta.body();
    }

    public void contactar(String destinatario, String cuerpo) throws IOException {
        String token = "token de wabox";
        String numero = "minumero";
        String id = "id unico de mensaje";
        this.enviarWhatsapp(token, numero, destinatario, id, cuerpo);
    } //no anda al no haber cuenta de wabox
}
