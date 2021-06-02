package com.utn.contactservices;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface WhatsappWaboxService {
    @POST("https://www.waboxapp.com/api/send/chat?token=my_token&uid=34666123456&to=34666789123&custom_uid=msg0001&text=Hello+dude")
    Call<WhatsappRespuesta> contactarUsuario(
            @Field("code") String token,
            @Field("name") String numero,
            @Field("description") String to,
            @Field("description") String custom_uid,
            @Field("description") String mensaje);
}
