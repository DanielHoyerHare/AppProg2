package com.example.accelerationsensor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.View;

import androidx.core.content.ContextCompat;

public class MyGraphics extends View implements SensorEventListener {


    float x = 400, y = 300, w, h, xPace = 0, yPace = 0;
    int viewH, viewW;
    Drawable ball;
    MainActivity context;

    public MyGraphics(MainActivity context) {
        super(context);
        this.context = context;
        ball = ContextCompat.getDrawable(context, R.drawable.kugle_rwb);
        assert ball != null;
        h = ball.getIntrinsicHeight();
        w = ball.getIntrinsicWidth();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewH = h-(int)this.h;
        viewW = w-(int)this.w;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        ball.setBounds((int)x, (int)y, (int)(x+w), (int)(y+h));
        ball.draw(canvas);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if(event.sensor.getType() == context.accSensor.getType()){
            context.updateGUI(event.values);
            if (x > viewW && xPace > 0 ) {
                xPace = (float) (xPace*-0.5);
                x = viewW;
            }
            else if (x < 0 && xPace < 0) {
                xPace = (float) (xPace*-0.5);
                x = 0;
            }
            if (y > viewH && yPace > 0) {
                yPace = (float) (yPace*-0.5);
                y = viewH;
            }
            else if (y < 0 && yPace < 0) {
                yPace = (float) (yPace*-0.5);
                y = 0;
            }

            float xSlope = event.values[0],
                    ySlope = event.values[1];
            xPace -= xSlope;
            yPace += ySlope;

            x += xPace/100;
            y += yPace/100;
            postInvalidate();
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
