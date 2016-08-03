package net.iplustech.mytoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import ga.deluded_fruitcakes_anonymous.velocityangles.GameView;
import ga.deluded_fruitcakes_anonymous.velocityangles.R;

public class MainActivity extends AppCompatActivity {
    GameView v;
    int width,height;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        height = displaymetrics.heightPixels;
        width = displaymetrics.widthPixels;
        v = new GameView(this);
        setContentView(v);
    }



}
