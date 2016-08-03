package ga.deluded_fruitcakes_anonymous.velocityangles;

import android.view.MotionEvent;

/**
 * Created by Isaac on 8/3/2016.
 */
public class Joystick {
  float centerX, centerY;
  float borderHeight;
  public Joystick(float sWidth, float sHeight){
    borderHeight = sHeight * 0.7;
    centerX = sWidth * 0.5;
    centerY = sHeight * 0.9;
  }
  @Override
    public boolean onTouchEvent(MotionEvent e) {
        // MotionEvent reports input details from the touch screen
        // and other input controls. In this case, you are only
        // interested in events where the touch position changed.

        float x = e.getX();
        float y = e.getY();
    if(y >= borderHeight){
        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Toast.makeText(getContext(), "Screen Touched at " + (x-centerX) + ", " + (y-centerY), Toast.LENGTH_SHORT).show();

        }}
}
