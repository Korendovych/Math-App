package com.example.appmath;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class Formulas2 extends Fragment {


    private ImageButton imageButton2R;

    public Formulas2() {
        // Required empty public constructor
    }


    public static Formulas2 newInstance(String param1, String param2) {
        Formulas2 fragment = new Formulas2();
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
       // return inflater.inflate(R.layout.fragment_formulas2, container, false);
        final View view = inflater.inflate(R.layout.fragment_formulas2, container, false);

        imageButton2R=(ImageButton) view.findViewById(R.id.imageButton2R);
        imageButton2R.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Rectangulo.class);
                startActivity(intent);
            }
        });
        return view;
    }
}