package com.example.appmath;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class Formulas5 extends Fragment {

    private ImageButton imageButton2RR;

    public Formulas5() {
        // Required empty public constructor
    }


    public static Formulas5 newInstance(String param1, String param2) {
        Formulas5 fragment = new Formulas5();
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
       // return inflater.inflate(R.layout.fragment_formulas5, container, false);
        final View view = inflater.inflate(R.layout.fragment_formulas5, container, false);

        imageButton2RR=(ImageButton) view.findViewById(R.id.imageButton2RR);
        imageButton2RR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), RectanguloR.class);
                startActivity(intent);
            }
        });
        return view;
    }
}