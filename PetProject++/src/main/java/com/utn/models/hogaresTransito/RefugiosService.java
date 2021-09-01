package com.utn.models.hogaresTransito;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface RefugiosService {
    @GET("hogares")
    Call<RefugeeList> hogares(@Header("Authorization") String authorization, @Query("offset") int offset);
}
