package ga.deluded_fruitcakes_anonymous.velocityangles;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.RectF;

public class DrawableObject{

RectF bounds = new RectF();
    Bitmap bitmap;
    float xPos, yPos,width,height;
    public DrawableObject(Bitmap bitmap, float xPos,float yPos,float width, float height){
        this.xPos = xPos;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.bitmap = bitmap;
        if(width>0&& height >0){
        setBounds();
    }}
    public void setBounds(){
        bounds.set(xPos - width * .5f,yPos-height*.5f,xPos+width*.5f,yPos+height*.5f);
    }
    public void update(Canvas canvas){
        if(bitmap == null)System.out.println("BC:SCREW THIS BITMAP, IT IS NOT REAL  AND NEITHER IS THE UNIVERSE");
        else canvas.drawBitmap(bitmap,null,bounds,null);

    }
}
