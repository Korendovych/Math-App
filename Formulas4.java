package com.example.appmath;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class Formulas4 extends Fragment {

    private ImageButton imageButton2C;

    public Formulas4() {
        // Required empty public constructor
    }


    public static Formulas4 newInstance(String param1, String param2) {
        Formulas4 fragment = new Formulas4();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      //  return inflater.inflate(R.layout.fragment_formulas4, container, false);
        final View view = inflater.inflate(R.layout.fragment_formulas4, container, false);

        imageButton2C=(ImageButton) view.findViewById(R.id.imageButton2C);
        imageButton2C.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Cuadrado.class);
                startActivity(intent);
            }
        });
        return view;
    }
}