package com.example.com1toast4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast (View v) {
        //Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show(); > to show defult message of toast
        Toast toast = Toast.makeText(this, "Hello", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL | Gravity.START, 90, 0); //Generate the position of the toast
        toast.show();
    }
}