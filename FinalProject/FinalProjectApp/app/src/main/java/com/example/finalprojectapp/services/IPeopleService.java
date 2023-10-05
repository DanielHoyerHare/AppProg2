package com.example.finalprojectapp.services;

import com.example.finalprojectapp.models.People;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface IPeopleService {
    @GET("People")
    Call<ArrayList<People>> getAllPeople();

    @GET("People/{id}")
    Call<People> getPeopleById(@Path("id") int id);

    @POST("People")
    Call<People> addPeople(@Body People p);

    @PUT("People")
    Call<People> updatePeople(@Body People p);

    @DELETE("People/{id}")
    Call<People> deletePeopleById(@Path("id") int id);
}
