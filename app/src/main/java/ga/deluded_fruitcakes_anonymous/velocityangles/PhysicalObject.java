package ga.deluded_fruitcakes_anonymous.velocityangles
import android.graphics.Bitmap;
import android.graphics.Canvas;

/**
 * Created by azamp19 on 8/2/2016.
 */
public class PhysicalObject extends DrawableObject {
float xVel, yVel,xAcceleration,yAcceleration;
int Points;

    public PhysicalObject(Bitmap bitmap, float xPos, float yPos, float width, float height) {
        super(bitmap, xPos, yPos, width, height);
    }
    private void MoveByPhysics(){

        xVel += xAcceleration;
        yVel += yAcceleration;
        xPos  += xVel;
        yPos += yVel;
        setBounds();
    }
    @Override
    public void update(Canvas canvas){
        MoveByPhysics();
        super.update(canvas);
    }
    public boolean collidedWith(DrawableObject other){
        boolean ret = false;
        if(bounds.contains(other.bounds)) ret= true;

     return ret;
    }

}
