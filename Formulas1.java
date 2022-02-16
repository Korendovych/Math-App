package com.example.appmath;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class Formulas1 extends Fragment {


    private ImageButton imageButton2;

    public Formulas1() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static Formulas1 newInstance(String param1, String param2) {
        Formulas1 fragment = new Formulas1();
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
        //return inflater.inflate(R.layout.fragment_formulas1, container, false);
        final View view = inflater.inflate(R.layout.fragment_formulas1, container, false);

        imageButton2=(ImageButton) view.findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Equilatero.class);
                startActivity(intent);
            }
        });
        return view;
    }
}