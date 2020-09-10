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
    int no3, so4, hardness, naClConsume, column;
    private TextView no3Out, so4Out, hardnessOut,columnOut, naClConsumeOut;


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
        no3 = bundle.getInt("NO3");
        so4 = bundle.getInt("SO4");
        hardness = bundle.getInt("Hardness");
        naClConsume = bundle.getInt("naClConsume");
        column = bundle.getInt("column");



        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        //just fake info without logic
        //have to create logic
        no3Out = view.findViewById(R.id.gap_nitrate_text);
        so4Out = view.findViewById(R.id.pa202_text);

        hardnessOut=view.findViewById(R.id.TC007_text);
        naClConsumeOut = view.findViewById(R.id.breakstone);
        columnOut = view.findViewById(R.id.workflow);


        no3Out.setText(String.valueOf(no3));
        so4Out.setText(String.valueOf(so4));
        hardnessOut.setText(String.valueOf(hardness));
        naClConsumeOut.setText(String.valueOf(naClConsume));
        columnOut.setText(String.valueOf(column));


        super.onViewCreated(view, savedInstanceState);
    }
}