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

public class RectanguloR extends AppCompatActivity {

    private Formulas5 Formulas5;
    private EditText edtARR, edtBRR;
    private TextView tvAnguloARR, tvAreaRR, tvPerimetroRR, tvDiagonalRR;
    private Button btnCalcularRR, btnVacioRR;
    private ImageButton imageButtonRR, imgBtnINFORR;
    private Spinner spinner1RR;

    private final static String[] names = {"Radians", "Grados"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rectangulo_r);

        getSupportActionBar().hide();

        imageButtonRR=(ImageButton) findViewById(R.id.imageButtonRR);
        imgBtnINFORR=(ImageButton) findViewById(R.id.imgBtnINFORR);
        btnCalcularRR=(Button) findViewById(R.id.btnCalcularRR);
        btnVacioRR=(Button) findViewById(R.id.btnVacioRR);

        edtARR=(EditText) findViewById(R.id.edtARR);
        edtBRR=(EditText) findViewById(R.id.edtBRR);

        tvAnguloARR=(TextView) findViewById(R.id.tvAnguloARR);
        tvAreaRR=(TextView) findViewById(R.id.tvAreaRR);
        tvPerimetroRR=(TextView) findViewById(R.id.tvPerimetroRR);
        tvDiagonalRR=(TextView) findViewById(R.id.tvDiagonalRR);

        ArrayAdapter adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, names);
        spinner1RR=(Spinner) findViewById(R.id.spinner1RR);
        spinner1RR.setAdapter(adapter);



        imgBtnINFORR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Formulas5=new Formulas5();
                getSupportFragmentManager().beginTransaction().add(android.R.id.content, Formulas5).commit();
            }
        });


        btnCalcularRR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double a = Double.parseDouble(edtARR.getText().toString());
                double b = Double.parseDouble(edtBRR.getText().toString());

                double diagonal, perimetro, area;


                area=a*b;
                tvAreaRR.setText(area+"");
                perimetro=2*(a+b);
                tvPerimetroRR.setText(perimetro+"");
                double d = (a*a)+(b*b);
                diagonal=(Math.sqrt(d));
                tvDiagonalRR.setText(diagonal+"");

                spinner1RR.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {
                        double anguloA = Math.toRadians(90);
                        tvAnguloARR.setText(anguloA+"");
                    }

                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                        String resp = adapter.getItem(position).toString();
                        if(resp.equalsIgnoreCase("Grados")){
                            tvAnguloARR.setText("90.0");
                        } else{
                            double anguloA = Math.toRadians(90);
                            tvAnguloARR.setText(anguloA+"");}
                    }


                });
                double anguloA = Math.toRadians(90);
                tvAnguloARR.setText(anguloA+"");
            }
        });

        btnVacioRR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvPerimetroRR.setText(" ");
                tvAreaRR.setText(" ");
                tvDiagonalRR.setText(" ");
                tvAnguloARR.setText(" ");
                edtARR.setText(" ");
                edtBRR.setText(" ");
            }
        });




        imageButtonRR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RectanguloR.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}