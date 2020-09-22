package com.example.watercalc;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OutputFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OutputFragment extends Fragment {
    int  naClConsume, column;
    double no3, so4, hardness;
    private TextView no3Out, pa202L, tc007L, columnOut, naClConsumeOut, salt;


    public static OutputFragment newInstance() {
        OutputFragment fragment = new OutputFragment();
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
        //idk what's going on
        View view = inflater.inflate(R.layout.fragment_output, null);
        Bundle bundle = getArguments();
        no3 = bundle.getDouble("NO3");
        so4 = bundle.getDouble("SO4");
        hardness = bundle.getDouble("Hardness");
        naClConsume = bundle.getInt("naClConsume");
        column = bundle.getInt("column");


        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Calculator calculator = new Calculator(no3, so4, hardness, naClConsume, column);
        calculator.divideNO3SO4();


        no3Out = view.findViewById(R.id.gap_nitrate_text);
        pa202L = view.findViewById(R.id.pa202_text);
        salt = view.findViewById(R.id.salt);

        tc007L = view.findViewById(R.id.TC007_text);
        naClConsumeOut = view.findViewById(R.id.breakstone);
        columnOut = view.findViewById(R.id.workflow);

//add the gap of nitrates below
        no3Out.setText(String.valueOf(calculator.gap()));
        pa202L.setText(String.valueOf(calculator.volumePA202()));
        tc007L.setText(String.valueOf(calculator.getVolumeTC007()));
        naClConsumeOut.setText(String.valueOf(naClConsume));
        columnOut.setText(String.valueOf(column));
        salt.setText(String.valueOf(calculator.getSalt()));


        super.onViewCreated(view, savedInstanceState);
    }
}