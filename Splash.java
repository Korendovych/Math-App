package com.example.appmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //ocultamos el titulo
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onStart() {
        //herencia
        super.onStart();

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                finish();
            }
        }, 4000);


    }
}