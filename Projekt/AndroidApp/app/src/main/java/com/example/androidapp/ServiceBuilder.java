package com.example.androidapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {

    private static final String URL = "http://10.0.2.2:8080/DanielAPITest/api/";

    private static Retrofit retrofit =
            new Retrofit.Builder().baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();

    public static <S> S buildService(Class<S> serviceType){
        return retrofit.create(serviceType);
    }
}
