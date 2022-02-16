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

public class Cuadrado extends AppCompatActivity {

    private Formulas4 Formulas4;
    private EditText edtAC;
    private TextView tvAnguloAC, tvAreaC, tvPerimetroC, tvDiagonalC;
    private Button btnCalcularC, btnVacioC;
    private ImageButton imageButtonC, imgBtnINFOC;
    private Spinner spinner1C;

    private final static String[] names = {"Radians", "Grados"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuadrado);

        getSupportActionBar().hide();

        imageButtonC=(ImageButton) findViewById(R.id.imageButtonC);
        imgBtnINFOC=(ImageButton) findViewById(R.id.imgBtnINFOC);
        btnCalcularC=(Button) findViewById(R.id.btnCalcularC);
        btnVacioC=(Button) findViewById(R.id.btnVacioC);

        edtAC=(EditText) findViewById(R.id.edtAC);

        tvAnguloAC=(TextView) findViewById(R.id.tvAnguloAC);
        tvAreaC=(TextView) findViewById(R.id.tvAreaC);
        tvPerimetroC=(TextView) findViewById(R.id.tvPerimetroC);
        tvDiagonalC=(TextView) findViewById(R.id.tvDiagonalC);

        ArrayAdapter adapter= new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, names);
        spinner1C=(Spinner) findViewById(R.id.spinner1C);

        spinner1C.setAdapter(adapter);



        imgBtnINFOC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Formulas4=new Formulas4();
                getSupportFragmentManager().beginTransaction().add(android.R.id.content, Formulas4).commit();
            }
        });


        btnCalcularC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                double a = Double.parseDouble(edtAC.getText().toString());

                double diagonal, perimetro, area;


                    area=a*a;
                    tvAreaC.setText(area+"");
                    perimetro=4*a;
                    tvPerimetroC.setText(perimetro+"");
                    diagonal=(Math.sqrt(2))*a;
                    tvDiagonalC.setText(diagonal+"");

                    spinner1C.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {
                            double anguloA = Math.toRadians(90);
                            tvAnguloAC.setText(anguloA+"");
                        }

                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            String resp = adapter.getItem(position).toString();
                            if(resp.equalsIgnoreCase("Grados")){
                                tvAnguloAC.setText("90.0");
                            } else{
                                double anguloA = Math.toRadians(90);
                                tvAnguloAC.setText(anguloA+"");}
                        }


                    });
                double anguloA = Math.toRadians(90);
                tvAnguloAC.setText(anguloA+"");
            }
        });

        btnVacioC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvPerimetroC.setText(" ");
                tvAreaC.setText(" ");
                tvDiagonalC.setText(" ");
                tvAnguloAC.setText(" ");
                edtAC.setText(" ");
            }
        });




        imageButtonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cuadrado.this, MainActivity.class);
                startActivity(intent);
            }
        });



    }
}