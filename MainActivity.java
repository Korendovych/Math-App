package com.example.appmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    private ImageButton imgBtn1, imgBtn2, imgBtn3, imgBtn4, imgBtn5, imgBtn6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ocultamos el titulo
        getSupportActionBar().hide();

        imgBtn1=(ImageButton) findViewById(R.id.imgBtn1);
        imgBtn2=(ImageButton) findViewById(R.id.imgBtn2);
        imgBtn3=(ImageButton) findViewById(R.id.imgBtn3);
        imgBtn4=(ImageButton) findViewById(R.id.imgBtn4);
        imgBtn5=(ImageButton) findViewById(R.id.imgBtn5);
        imgBtn6=(ImageButton) findViewById(R.id.imgBtn6);



        imgBtn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Equilatero.class);
                startActivity(intent);

            }
        });

        imgBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Rectangulo.class);
                startActivity(intent);
            }
        });

        imgBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Escaleno.class);
                startActivity(intent);
            }
        });

        imgBtn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Cuadrado.class);
                startActivity(intent);
            }
        });

        imgBtn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RectanguloR.class);
                startActivity(intent);
            }
        });

        imgBtn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Circulo.class);
                startActivity(intent);
            }
        });





    }
}