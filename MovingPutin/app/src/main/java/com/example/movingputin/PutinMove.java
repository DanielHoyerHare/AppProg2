package com.example.movingputin;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.core.content.ContextCompat;

public class PutinMove extends View implements Runnable {

    int x = 100, y = 100;
    int xInc = 2, yInc = 2;
    int h, w;

    int viewH, viewW;
    Drawable drwPutin;

    public PutinMove(Context context) {
        super(context);
        drwPutin = ContextCompat.getDrawable(context, R.drawable.putin);
        assert drwPutin != null;
        h = drwPutin.getIntrinsicHeight()/4;
        w = drwPutin.getIntrinsicWidth()/4;

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewH = h-this.h;
        viewW = w-this.w;
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        drwPutin.setBounds(x, y, x+w, y+h);
        drwPutin.draw(canvas);
    }

    @Override
    public void run() {
        while(true){
            x += xInc;
            y += yInc;
            if(x > viewW || x < 0){
                xInc = -xInc;
            }
            if(y > viewH || y < 0){
                yInc = -yInc;
            }
            postInvalidate();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
