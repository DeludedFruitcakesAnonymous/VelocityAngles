package ga.deluded_fruitcakes_anonymous.velocityangles;

/**
 * Created by Isaac on 8/3/2016.
 */
public class Square {
  @Override
    public boolean onTouchEvent(MotionEvent e) {
        // MotionEvent reports input details from the touch screen
        // and other input controls. In this case, you are only
        // interested in events where the touch position changed.

        float x = e.getX();
        float y = e.getY();

        switch (e.getAction()) {
            case MotionEvent.ACTION_DOWN:
                Toast.makeText(getContext(), "Screen Touched at " + x + ", " + y, Toast.LENGTH_SHORT).show();

        }
}
