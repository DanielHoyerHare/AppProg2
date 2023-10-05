package com.example.finalprojectapp.services;

import com.example.finalprojectapp.models.HairColor;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IHairColorService {
    @GET("HairColor")
    Call<ArrayList<HairColor>> getAllHairColors();

    @GET("HairColor/{id}")
    Call<HairColor> getHairColorById(@Path("id") int id);
}
