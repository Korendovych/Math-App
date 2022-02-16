package com.example.appmath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

public class Circulo extends AppCompatActivity {

    private Formulas6 Formulas6;
    private EditText edtACC;
    private TextView tvAreaCC, tvPerimetroCC, tvDiagonalCC;
    private Button btnCalcularCC, btnVacioCC;
    private ImageButton imageButtonCC, imgBtnINFOCC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulo);


        getSupportActionBar().hide();

        imageButtonCC=(ImageButton) findViewById(R.id.imageButtonCC);
        imgBtnINFOCC=(ImageButton) findViewById(R.id.imgBtnINFOCC);
        btnCalcularCC=(Button) findViewById(R.id.btnCalcularCC);
        btnVacioCC=(Button) findViewById(R.id.btnVacioCC);

        edtACC=(EditText) findViewById(R.id.edtACC);

        tvAreaCC=(TextView) findViewById(R.id.tvAreaCC);
        tvPerimetroCC=(TextView) findViewById(R.id.tvPerimetroCC);
        tvDiagonalCC=(TextView) findViewById(R.id.tvDiagonalCC);


        imgBtnINFOCC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Formulas6=new Formulas6();
                getSupportFragmentManager().beginTransaction().add(android.R.id.content, Formulas6).commit();
            }
        });


        btnCalcularCC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double radio = Double.parseDouble(edtACC.getText().toString());

                double diametro, perimetro, area;


                area=3.14*(radio*radio);
                tvAreaCC.setText(area+"");
                perimetro=2*3.14*radio;
                tvPerimetroCC.setText(perimetro+"");
                diametro=2*radio;
                tvDiagonalCC.setText(diametro+"");


            }
        });

        btnVacioCC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvPerimetroCC.setText(" ");
                tvAreaCC.setText(" ");
                tvDiagonalCC.setText(" ");
                edtACC.setText(" ");
            }
        });




        imageButtonCC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Circulo.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }
}