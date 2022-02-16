package com.example.appmath;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class Formulas6 extends Fragment {

    private ImageButton imageButton2CC;

    public Formulas6() {
        // Required empty public constructor
    }

    public static Formulas6 newInstance(String param1, String param2) {
        Formulas6 fragment = new Formulas6();
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
       // return inflater.inflate(R.layout.fragment_formulas6, container, false);
        final View view = inflater.inflate(R.layout.fragment_formulas6, container, false);

        imageButton2CC=(ImageButton) view.findViewById(R.id.imageButton2CC);
        imageButton2CC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Circulo.class);
                startActivity(intent);
            }
        });
        return view;
    }
}