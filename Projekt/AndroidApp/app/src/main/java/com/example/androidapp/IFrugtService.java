package com.example.androidapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface IFrugtService {
    @GET("Frugt")
    Call<List<Frugt>> getAllFrugt();

    @GET("Frugt/{id}")
    Call<Frugt> getFrugtById(@Path("id") int id);

    @POST("Frugt")
    Call<Void> addFrugt(@Body Frugt frugt);

}
