package com.utn.transithomes;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface ServiciosRefugios {
    @GET("hogares")
    Call<ListadoDeRefugios> hogares(@Header("Authorization") String authorization, @Query("offset") int offset);
}
