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

public class Rectangulo extends AppCompatActivity {

    private Formulas2 Formulas2;
    private EditText edtAR, edtBR;
    private TextView tvCR, tvAnguloAR, tvAnguloBR, tvAnguloGR, tvAreaR, tvPerimetroR;
    private Button btnCalcularR, btnVacioR;
    private ImageButton imageButtonR, imgBtnINFOR;
    private Spinner spinner1R, spinner2R, spinner3R;

    private double alfa;

    private final static String[] names = {"Radians", "Grados"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo);

        getSupportActionBar().hide();

        imageButtonR=(ImageButton) findViewById(R.id.imageButtonR);
        imgBtnINFOR=(ImageButton) findViewById(R.id.imgBtnINFOR);
        btnCalcularR=(Button) findViewById(R.id.btnCalcularR);
        btnVacioR=(Button) findViewById(R.id.btnVacioR);

        edtAR=(EditText) findViewById(R.id.edtAR);
        edtBR=(EditText) findViewById(R.id.edtBR);

        tvCR=(TextView) findViewById(R.id.tvCR);
        tvAnguloAR=(TextView) findViewById(R.id.tvAnguloAR);
        tvAnguloBR=(TextView) findViewById(R.id.tvAnguloBR);
        tvAnguloGR=(TextView) findViewById(R.id.tvAnguloGR);
        tvAreaR=(TextView) findViewById(R.id.tvAreaR);
        tvPerimetroR=(TextView) findViewById(R.id.tvPerimetroR);

        ArrayAdapter adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, names);
        spinner1R=(Spinner) findViewById(R.id.spinner1R);
        spinner2R=(Spinner) findViewById(R.id.spinner2R);
        spinner3R=(Spinner) findViewById(R.id.spinner3R);
        spinner1R.setAdapter(adapter);
        spinner2R.setAdapter(adapter);
        spinner3R.setAdapter(adapter);


        imgBtnINFOR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Formulas2=new Formulas2();
                getSupportFragmentManager().beginTransaction().add(android.R.id.content, Formulas2).commit();
            }
        });



        btnCalcularR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double a = Double.parseDouble(edtAR.getText().toString());
                double b = Double.parseDouble(edtBR.getText().toString());
                double c, perimetro, area;
                alfa=Math.atan(a);

                if(a!=b){
                    tvCR.setText("ERROR lado a y lado b tienen longitud diferrente");
                }
                if(a==b){
                    double c2=(a*a)+(b*b);
                    c = Math.sqrt(c2);
                    tvCR.setText(c+"");
                    area=(b*a)/2;
                    tvAreaR.setText(area+"");
                    perimetro=a+b+c;
                    tvPerimetroR.setText(perimetro+"");


                    spinner1R.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            double anguloA = alfa;
                            tvAnguloAR.setText(anguloA+"");
                        }

                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            String resp = adapter.getItem(position).toString();
                            if(resp.equalsIgnoreCase("Grados")){
                                double anguloA=Math.toDegrees(alfa);
                                tvAnguloAR.setText(anguloA+"");
                            } else{
                                double anguloA = Math.toRadians(60);
                                tvAnguloAR.setText(anguloA+"");}
                        }


                    });
                    double anguloA = alfa;
                    tvAnguloAR.setText(anguloA+"");

                    spinner2R.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            String resp = adapter.getItem(position).toString();
                            if(resp.equalsIgnoreCase("Grados")){
                                double anguloA=Math.toDegrees(alfa);
                                double anguloB1=90-anguloA;
                                tvAnguloBR.setText(anguloB1+"");
                            } else {
                                double anguloA=Math.toDegrees(alfa);
                                double anguloB1=90-anguloA;
                                double anguloB = Math.toRadians(anguloB1);
                                tvAnguloBR.setText(anguloB+"");}
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            double anguloA=Math.toDegrees(alfa);
                            double anguloB1=90-anguloA;
                            double anguloB = Math.toRadians(anguloB1);
                            tvAnguloBR.setText(anguloB+"");
                        }
                    });
                    double anguloB = Math.toRadians(60);
                    tvAnguloBR.setText(anguloB+"");

                    spinner3R.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            String resp = adapter.getItem(position).toString();
                            if(resp.equalsIgnoreCase("Grados")){
                                tvAnguloGR.setText("90");
                            } else {
                                double anguloG = Math.toRadians(90);
                                tvAnguloGR.setText(anguloG+"");}
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            double anguloG = Math.toRadians(90);
                            tvAnguloGR.setText(anguloG+"");
                        }
                    });
                    double anguloG = Math.toRadians(60);
                    tvAnguloGR.setText(anguloG+"");

                }

            }
        });

        btnVacioR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvPerimetroR.setText(" ");
                tvAreaR.setText(" ");
                tvAnguloGR.setText(" ");
                tvAnguloBR.setText(" ");
                tvAnguloAR.setText(" ");
                tvCR.setText(" ");
                edtAR.setText(" ");
                edtBR.setText(" ");
            }
        });




        imageButtonR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Rectangulo.this, MainActivity.class);
                startActivity(intent);
            }
        });







    }
}