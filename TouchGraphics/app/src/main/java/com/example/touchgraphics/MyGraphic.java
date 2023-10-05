package com.example.touchgraphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class MyGraphic extends View implements View.OnTouchListener {

    int xPos = 200, yPos =300, radius = 100;
    int xPre, yPre;
    boolean move = false;

    public MyGraphic(Context context) {
        super(context);
        setOnTouchListener(this);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Paint paint = new Paint();
        paint.setColor(0xFF8617FF);
        canvas.drawCircle(xPos,yPos,radius,paint);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int x = (int)event.getX(),
                y = (int)event.getY();
        int action = event.getAction();
        switch(action){
            case MotionEvent.ACTION_DOWN:
                if (radius > Math.sqrt((x-xPos)*(x-xPos) + (y-yPos)*(y-yPos))){
                    move = true;
                    xPre = x;
                    yPre = y;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (move){
                    xPos += x - xPre;
                    yPos += y - yPre;
                    xPre = x;
                    yPre = y;
                    invalidate();
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;
    }
}
