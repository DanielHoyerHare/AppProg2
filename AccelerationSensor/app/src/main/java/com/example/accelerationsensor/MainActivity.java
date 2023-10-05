package com.example.accelerationsensor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener, View.OnClickListener {

    LinearLayout theLayout;

    TextView txtX, txtY, txtZ;

    SensorManager sm;

    Sensor accSensor;

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        theLayout = findViewById(R.id.theLayout);

        txtX = findViewById(R.id.txtX);
        txtY = findViewById(R.id.txtY);
        txtZ = findViewById(R.id.txtZ);

        btn = findViewById(R.id.btn);
        btn.setOnClickListener(this);

        sm = (SensorManager)getSystemService(Context.SENSOR_SERVICE);
    }

    @Override
    protected void onResume() {
        super.onResume();
        accSensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener((SensorEventListener) this, accSensor, 10000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sm.unregisterListener((SensorEventListener) this, accSensor);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == accSensor.getType()){
            updateGUI(event.values);
        }
    }

    public void updateGUI(float[] values){
        txtX.setText(String.format("%2.1f", values[0]));
        txtY.setText(String.format("%2.1f", values[1]));
        txtZ.setText(String.format("%2.1f", values[2]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    @Override
    public void onClick(View v) {
        sm.unregisterListener((SensorEventListener) this, accSensor);
        MyGraphics mg = new MyGraphics(this);
        sm.registerListener((SensorEventListener) mg, accSensor, 10000);
        theLayout.addView(mg);
    }
}