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

public class Equilatero extends AppCompatActivity {

    private Formulas1 Formulas1;
    private EditText edtA, edtB;
    private TextView tvC, tvAnguloA, tvAnguloB, tvAnguloG, tvArea, tvPerimetro;
    private Button btnCalcular, btnVacio;
    private ImageButton imageButton, imgBtnINFO;
    private Spinner spinner1, spinner2, spinner3;

    private final static String[] names = {"Radians", "Grados"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equilatero);

        getSupportActionBar().hide();

        imageButton=(ImageButton) findViewById(R.id.imageButton);
        imgBtnINFO=(ImageButton) findViewById(R.id.imgBtnINFO);
        btnCalcular=(Button) findViewById(R.id.btnCalcular);
        btnVacio=(Button) findViewById(R.id.btnVacio);

        edtA=(EditText) findViewById(R.id.edtA);
        edtB=(EditText) findViewById(R.id.edtB);

        tvC=(TextView) findViewById(R.id.tvC);
        tvAnguloA=(TextView) findViewById(R.id.tvAnguloA);
        tvAnguloB=(TextView) findViewById(R.id.tvAnguloB);
        tvAnguloG=(TextView) findViewById(R.id.tvAnguloG);
        tvArea=(TextView) findViewById(R.id.tvArea);
        tvPerimetro=(TextView) findViewById(R.id.tvPerimetro);

        ArrayAdapter adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, names);
        spinner1=(Spinner) findViewById(R.id.spinner1);
        spinner2=(Spinner) findViewById(R.id.spinner2);
        spinner3=(Spinner) findViewById(R.id.spinner3);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);


        imgBtnINFO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Formulas1=new Formulas1();
                getSupportFragmentManager().beginTransaction().add(android.R.id.content, Formulas1).commit();
            }
        });

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double a = Double.parseDouble(edtA.getText().toString());
                double b = Double.parseDouble(edtB.getText().toString());
                double c, perimetro, area;

                if(a!=b){
                    tvC.setText("ERROR lado a y lado b tienen longitud diferrente");
                }
                if(a==b){
                    c = a;
                    tvC.setText(c+"");
                    area=(Math.sqrt(3)/4)*(a*a);
                    tvArea.setText(area+"");
                    perimetro=3*a;
                    tvPerimetro.setText(perimetro+"");

                    spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            double anguloA = Math.toRadians(60);
                            tvAnguloA.setText(anguloA+"");
                        }

                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            String resp = adapter.getItem(position).toString();
                            if(resp.equalsIgnoreCase("Grados")){
                                tvAnguloA.setText("60");
                            } else{
                            double anguloA = Math.toRadians(60);
                            tvAnguloA.setText(anguloA+"");}
                        }


                    });
                    double anguloA = Math.toRadians(60);
                    tvAnguloA.setText(anguloA+"");

                    spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            String resp = adapter.getItem(position).toString();
                            if(resp.equalsIgnoreCase("Grados")){
                                tvAnguloB.setText("60");
                            } else {
                            double anguloB = Math.toRadians(60);
                            tvAnguloB.setText(anguloB+"");}
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            double anguloB = Math.toRadians(60);
                            tvAnguloB.setText(anguloB+"");
                        }
                    });
                    double anguloB = Math.toRadians(60);
                    tvAnguloB.setText(anguloB+"");

                    spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            String resp = adapter.getItem(position).toString();
                            if(resp.equalsIgnoreCase("Grados")){
                                tvAnguloG.setText("60");
                            } else {
                            double anguloG = Math.toRadians(60);
                            tvAnguloG.setText(anguloG+"");}
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            double anguloG = Math.toRadians(60);
                            tvAnguloG.setText(anguloG+"");
                        }
                    });
                    double anguloG = Math.toRadians(60);
                    tvAnguloG.setText(anguloG+"");

                }

            }
        });

        btnVacio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvPerimetro.setText(" ");
                tvArea.setText(" ");
                tvAnguloG.setText(" ");
                tvAnguloB.setText(" ");
                tvAnguloA.setText(" ");
                tvC.setText(" ");
                edtA.setText(" ");
                edtB.setText(" ");
            }
        });




        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Equilatero.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }
}