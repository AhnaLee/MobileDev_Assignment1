package com.example.com1toast2;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;

import io.github.muddz.styleabletoast.StyleableToast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View v) {
        StyleableToast.makeText(this, "Hello World!", R.style.exampleToast).show();

    }
}