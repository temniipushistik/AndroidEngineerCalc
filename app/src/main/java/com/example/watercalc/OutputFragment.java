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
    int naClConsume;
    double no3, so4, hardness, column, breakStone;
    double square;
    private TextView no3Out, pa202Volume, tc007Volume, columnOut, naClConsumeOut, salt, tc007perL, pa202perL, breakStoneOut, workFlowOut, capacityOut;


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
        column = bundle.getDouble("column");
        square = bundle.getDouble("square");
        breakStone = bundle.getInt("breakstone");


        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        Calculator calculator = new Calculator(no3, so4, hardness, naClConsume, column, square);
        // calculator.divideNO3SO4();


        no3Out = view.findViewById(R.id.gap_nitrate_text);
        pa202Volume = view.findViewById(R.id.pa202_text);
        salt = view.findViewById(R.id.salt);
        breakStoneOut = view.findViewById(R.id.breakstone);


        tc007Volume = view.findViewById(R.id.TC007_text);
        naClConsumeOut = view.findViewById(R.id.breakstone);
        columnOut = view.findViewById(R.id.workflow);
        tc007perL = view.findViewById(R.id.TC007perL);
        pa202perL = view.findViewById(R.id.PA202perL);
        workFlowOut = view.findViewById(R.id.workflow);
        capacityOut = view.findViewById(R.id.capacity);

//add the gap of nitrates below
        calculator.divideNO3SO4();
        no3Out.setText(String.format("%.1f", calculator.gap()));

        calculator.anionCapacity125();
        calculator.anionCapacity250();
        calculator.anionCapacityL();
        calculator.cationCapacityL();
        pa202perL.setText(String.format("%.3f", calculator.anionCapacityL()));
        tc007perL.setText(String.format("%.3f", calculator.cationCapacityL()));
        pa202Volume.setText(String.format("%.1f", calculator.volumePA202()));

        tc007Volume.setText(String.format("%.1f", calculator.getVolumeTC007()));

        naClConsumeOut.setText(String.valueOf(naClConsume));
        columnOut.setText(String.valueOf(column));
        salt.setText(String.format("%.1f", calculator.getSalt()));
        breakStoneOut.setText(String.valueOf(breakStone));
        workFlowOut.setText(String.valueOf(calculator.flow()));
        capacityOut.setText(String.format("%.1f", calculator.capacity()));

        super.onViewCreated(view, savedInstanceState);
    }
}