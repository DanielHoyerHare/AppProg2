package com.example.finalprojectapp.services;

import com.example.finalprojectapp.models.ProgLang;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IProgLangService {
    @GET("ProgLang")
    Call<ArrayList<ProgLang>> getAllProgLangs();

    @GET("ProgLang/{id}")
    Call<ProgLang> getProgLangById(@Path("id") int id);
}
