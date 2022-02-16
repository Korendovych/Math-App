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

public class Escaleno extends AppCompatActivity {

    private Formulas3 Formulas3;
    private EditText edtAE, edtBE, tvCE;
    private TextView tvAnguloAE, tvAnguloBE, tvAnguloGE, tvAreaE, tvPerimetroE;
    private Button btnCalcularE, btnVacioE;
    private ImageButton imageButtonE, imgBtnINFOE;
    private Spinner spinner1E, spinner2E, spinner3E;

    private final static String[] names = {"Radians", "Grados"};

    private double anA, anB;
    private double gradosA, gradosB, gradosG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escaleno);

        getSupportActionBar().hide();

        imageButtonE=(ImageButton) findViewById(R.id.imageButtonE);
        imgBtnINFOE=(ImageButton) findViewById(R.id.imgBtnINFOE);
        btnCalcularE=(Button) findViewById(R.id.btnCalcularE);
        btnVacioE=(Button) findViewById(R.id.btnVacioE);

        edtAE=(EditText) findViewById(R.id.edtAE);
        edtBE=(EditText) findViewById(R.id.edtBE);
        tvCE=(EditText) findViewById(R.id.tvCE);

        tvAnguloAE=(TextView) findViewById(R.id.tvAnguloAE);
        tvAnguloBE=(TextView) findViewById(R.id.tvAnguloBE);
        tvAnguloGE=(TextView) findViewById(R.id.tvAnguloGE);
        tvAreaE=(TextView) findViewById(R.id.tvAreaE);
        tvPerimetroE=(TextView) findViewById(R.id.tvPerimetroE);

        ArrayAdapter adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, names);
        spinner1E=(Spinner) findViewById(R.id.spinner1E);
        spinner2E=(Spinner) findViewById(R.id.spinner2E);
        spinner3E=(Spinner) findViewById(R.id.spinner3E);
        spinner1E.setAdapter(adapter);
        spinner2E.setAdapter(adapter);
        spinner3E.setAdapter(adapter);


        imgBtnINFOE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Formulas3=new Formulas3();
                getSupportFragmentManager().beginTransaction().add(android.R.id.content, Formulas3).commit();
            }
        });




        btnCalcularE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double a = Double.parseDouble(edtAE.getText().toString());
                double b = Double.parseDouble(edtBE.getText().toString());
                double c = Double.parseDouble(tvCE.getText().toString());
                double perimetro, area;




                    double s = (a+b+c) /2;
                    double ar = s*(s-a)*(s-b)*(s-c);
                    area=Math.sqrt(ar);

                    tvAreaE.setText(area+"");
                    perimetro=a+b+c;
                    tvPerimetroE.setText(perimetro+"");


                    spinner1E.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            double anguloA= ( (b*b)+(c*c)-(a*a) ) / (2*b*c);
                            anA= Math.acos(anguloA);
                            tvAnguloAE.setText(anA+"");
                        }

                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            String resp = adapter.getItem(position).toString();
                            if(resp.equalsIgnoreCase("Grados")){
                                double anguloA=Math.toDegrees(anA);
                                gradosA=anguloA;
                                tvAnguloAE.setText(anguloA+"");
                            } else{
                                double anguloA= ( (b*b)+(c*c)-(a*a) ) / (2*b*c);
                                anA= Math.acos(anguloA);
                                tvAnguloAE.setText(anA+"");}
                        }


                    });
                    double anguloA= ( (b*b)+(c*c)-(a*a) ) / (2*b*c);
                    anA= Math.acos(anguloA);
                    tvAnguloAE.setText(anA+"");

                    spinner2E.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            String resp = adapter.getItem(position).toString();
                            if(resp.equalsIgnoreCase("Grados")){
                                double anguloB=Math.toDegrees(anB);
                                gradosB=anguloB;
                                tvAnguloBE.setText(anguloB+"");
                            } else {
                                double anguloB= ( (a*a)+(c*c)-(b*b) ) / (2*a*c);
                                anB= Math.acos(anguloB);
                                tvAnguloBE.setText(anB+"");
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            double anguloB= ( (a*a)+(c*c)-(b*b) ) / (2*a*c);
                            anB= Math.acos(anguloB);
                            tvAnguloBE.setText(anB+"");
                        }
                    });
                    double anguloB= ( (a*a)+(c*c)-(b*b) ) / (2*a*c);
                    anB= Math.acos(anguloB);
                    tvAnguloBE.setText(anB+"");

                    spinner3E.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            String resp = adapter.getItem(position).toString();
                            if(resp.equalsIgnoreCase("Grados")){
                                gradosG = 180-gradosA-gradosB;
                                tvAnguloGE.setText(gradosG+"");
                            } else {
                                double anguloG = Math.toRadians(gradosG);
                                tvAnguloGE.setText(anguloG+"");}
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            double anguloG2 = Math.toRadians(gradosG);
                            tvAnguloGE.setText(anguloG2+"");
                        }
                    });
                    gradosG = 180-gradosA-gradosB;
                    double anguloG3 = Math.toRadians(gradosG);
                    tvAnguloGE.setText(anguloG3+"");
            }
        });

        btnVacioE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvPerimetroE.setText(" ");
                tvAreaE.setText(" ");
                tvAnguloGE.setText(" ");
                tvAnguloBE.setText(" ");
                tvAnguloAE.setText(" ");
                tvCE.setText(" ");
                edtAE.setText(" ");
                edtBE.setText(" ");
            }
        });




        imageButtonE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Escaleno.this, MainActivity.class);
                startActivity(intent);
            }
        });











    }
}