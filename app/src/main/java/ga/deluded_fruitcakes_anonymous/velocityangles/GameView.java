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
    DrawableObject drawableObject;
    PhysicalObject physicalObject;
    Bitmap bitmapBase = BitmapFactory.decodeResource(getResources(), R.drawable.joystick_base);
    Bitmap bitmapTop = BitmapFactory.decodeResource(getResources(), R.drawable.joystick_top);
    public GameView(Context context, float sHeight, float sWidth) {
        super(context);
        borderHeight = sHeight * 0.7f;
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
                    physicalObject.xAcceleration = y-centerY;
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
    }
    public void onDraw(Canvas canvas){
        drawableObject.update(canvas);
        physicalObject.update(canvas);
        Paint paint = new Paint();
        paint.setTextSize(100);
        paint.setColor(Color.BLACK);
        canvas.drawText("hello",100,100,paint);
        try{
            Thread.sleep(100);
        }catch(InterruptedException e){
            
        }
    invalidate();}
}
