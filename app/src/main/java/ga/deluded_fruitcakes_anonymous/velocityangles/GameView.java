package ga.deluded_fruitcakes_anonymous.velocityangles;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Isaac on 8/3/2016.
 */
public class GameView extends View {
    float centerX, centerY;
    float borderHeight, MinHeight,MaxWidth, MinWidth;
    String Message = "hello";
    DrawableObject drawableObject;
    PhysicalObject physicalObject;
    float x2;
    float y2;
    float x3;
    float y3;
    Bitmap bitmapBase = BitmapFactory.decodeResource(getResources(), R.drawable.joystick_base);
    Bitmap bitmapTop = BitmapFactory.decodeResource(getResources(), R.drawable.joystick_top);
    public GameView(Context context, float sHeight, float sWidth) {
        super(context);
        borderHeight = sHeight * 0.1f;
        centerX = sWidth * 0.5f;
        centerY = sHeight * 0.5f;
        CreateJoystick();
    }
    public void CreateJoystick(){
        drawableObject = new DrawableObject(bitmapBase,centerX, centerY,200,200);
        physicalObject = new PhysicalObject(bitmapTop,centerX,centerY,100,100);
    }
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        // MotionEvent reports input details from the touch screen
        // and other input controls. In this case, you are only
        // interested in events where the touch position changed.

        float x = e.getX();
        float y = e.getY();

        if (y >= borderHeight) {
            switch (e.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    Toast.makeText(getContext(), "Joystick moved to " + (x - centerX) + ", " + (y - centerY), Toast.LENGTH_SHORT).show();
                    physicalObject.xAcceleration = x-centerX;
                    physicalObject.yAcceleration = y-centerY;
                    x3 = x;
                    y3 = y;
                    break;
                case MotionEvent.ACTION_MOVE:
                    physicalObject.xAcceleration = x-x3;
                    physicalObject.yAcceleration = y-y3;
                    physicalObject.xVelocity = 0;
                    physicalObject.yVelocity = 0
                    break;
                case MotionEvent.ACTION_UP:
                    joystickReturn();
                    break;
            }
        }
        return true;
    }
    public void joystickReturn(){
        physicalObject.xPos = centerX;
        physicalObject.yPos = centerY;
        physicalObject.xAcceleration = 0;
        physicalObject.yAcceleration = 0;
        physicalObject.xVelocity = 0;
        physicalObject.yVelocity = 0;
    }
    public void onDraw(Canvas canvas){
        drawableObject.update(canvas);
        physicalObject.update(canvas);
        Paint paint = new Paint();
        paint.setTextSize(100);
        paint.setColor(Color.BLACK);
        canvas.drawText(Message,100,100,paint);
        if((physicalObject.yPos <= y2 +5) && (physicalObject.yPos >= y2-5) ){
            Message = " Y = true";
            if((physicalObject.xPos <=x2 +5) && (physicalObject.xPos >= x2-5) ){
                Message = " X = true";

                physicalObject.xVelocity = 0;
                physicalObject.yVelocity = 0;
                physicalObject.xAcceleration = 0;
                physicalObject.yAcceleration = 0;

            }}
        try{
            Thread.sleep(100);
        }catch(InterruptedException e){
            
        }
    invalidate();}
}
