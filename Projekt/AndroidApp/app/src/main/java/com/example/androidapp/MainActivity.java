package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    TextView frugtName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frugtName = findViewById(R.id.frugtName);

        IFrugtService frugtService = ServiceBuilder.buildService(IFrugtService.class);

        Call<Frugt> request = frugtService.getFrugtById(1);
        request.enqueue(new Callback<Frugt>() {
            @Override
            public void onResponse(Call<Frugt> call, Response<Frugt> response) {
                frugtName.setText(response.body().getName());
            }

            @Override
            public void onFailure(Call<Frugt> call, Throwable t) {
                frugtName.setText(t.getMessage());
            }
        });

        Retrofit r;
    }
}