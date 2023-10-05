package com.example.movingputin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    FrameLayout theLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        theLayout = findViewById(R.id.theLayout);
        PutinMove putin = new PutinMove(this);
        theLayout.addView(putin);
        Thread t = new Thread(putin);
        t.start();
    }
}