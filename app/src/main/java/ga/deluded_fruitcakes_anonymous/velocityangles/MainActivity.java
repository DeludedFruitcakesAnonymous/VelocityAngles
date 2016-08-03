package net.iplustech.mytoast;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MyView v;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        v = new MyView(this);
        setContentView(v);
    }
    public void explode(View v){
        //0.0
        EditText t_inputText = (EditText) findViewById(R.id.t_wordInput);
        boolean validInputs = false;
        String message = "default message";
        try {
            message = t_inputText.getText().toString();
            validInputs = true;
        } catch (Exception e) {
            // invalid inputs stays false.
        }
        Monster m = new Monster(message);
        Toast.makeText(v.getContext(), m.name,Toast.LENGTH_SHORT).show();

    }
    public void explode2(View v){
        //0.1
        Toast.makeText(v.getContext(), "I WILL DO THY TOAST OF THYSELF DUH Now you do Really suck Alot; for duh jhdgjnhavgbiaugfkbsuvgfhgkbhfgvkhvgfdkbvjhgfsbkjhvgfkjhegvfjhgfuhgbkjhfhfbkjhfgbkjhfgbkajhevgbvfauytfbkvjhbfyboieugfbvsliugboiwuy4tiro",
                Toast.LENGTH_SHORT).show();
    }
}
