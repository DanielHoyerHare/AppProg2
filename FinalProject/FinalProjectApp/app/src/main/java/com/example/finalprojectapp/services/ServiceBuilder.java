package com.example.finalprojectapp.services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBuilder {

    private static final String URL = "http://192.168.0.168:8080/PeopleAPI/api/";

    private static Retrofit retrofit =
            new Retrofit.Builder().baseUrl(URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();

    public static <S> S buildService(Class<S> serviceType){
        return retrofit.create(serviceType);
    }
}

