package com.example.watercalc;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.watercalc.db.AppDatabase;
import com.example.watercalc.db.Site;
import com.example.watercalc.db.SiteDao;
import com.example.watercalc.db.apis.DeleteAllDatasAsync;
import com.example.watercalc.db.apis.GetAllDatasAsync;
import com.example.watercalc.db.apis.WriteDataAsync;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OutputFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OutputFragment extends Fragment {
    int naClConsume;

    double no3, so4, hardness, column, breakStone, square;
    String sizeOfColumn, nameOfSite, inputAnalyze, equipment, outInfo;
    Button save, delete;
    private TextView no3Out, pa202Volume, tc007Volume, columnOut, naClConsumeOut, salt, tc007perL, pa202perL, breakStoneOut, workFlowOut, capacityOut, outputText;
    // final Handler handler = new Handler();

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

        //put values from bundle to  values


        no3 = bundle.getDouble("NO3");
        so4 = bundle.getDouble("SO4");
        hardness = bundle.getDouble("Hardness");
        naClConsume = bundle.getInt("naClConsume");
        column = bundle.getDouble("column");
        square = bundle.getDouble("square");
        breakStone = bundle.getInt("breakstone");
        sizeOfColumn = bundle.getString("sizeOfColumn");
        nameOfSite = bundle.getString("NameOfSite");


        // Inflate the layout for this fragment
        return view;
    }

    //create visual part of fragment
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        Calculator calculator = new Calculator(no3, so4, hardness, naClConsume, column, square);

        //link values and elements of view

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
        outputText = view.findViewById(R.id.outinfo);
        save = view.findViewById(R.id.save);
        delete = view.findViewById(R.id.delete);


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Site site = new Site();
                new DeleteAllDatasAsync(getActivity()).execute(site);;

            }

        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Site site = new Site();
                site.setNameOfArea(nameOfSite);
                site.setInputInfo(inputAnalyze);
                site.setEquipment(equipment);
                site.setOutputInfo(outInfo);
                try {
                    //write info to database
                    (new WriteDataAsync(getActivity())).execute(site);

                    Toast.makeText(getActivity(),
                            //get info from database
                            (new GetAllDatasAsync(getActivity())).execute().get().toString(),
                            Toast.LENGTH_LONG).show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });


// fill fields from bundle and the calculator
        calculator.divideNO3SO4();
        no3Out.setText(String.format("%.1f", calculator.gap()));
        pa202perL.setText(String.format("%.2f", calculator.anionCapacityL()));
        tc007perL.setText(String.format("%.2f", calculator.cationCapacityL()));
        pa202Volume.setText(String.format("%.1f", calculator.volumePA202()));
        tc007Volume.setText(String.format("%.1f", calculator.getVolumeTC007()));
        naClConsumeOut.setText(String.valueOf(naClConsume));
        columnOut.setText(String.valueOf(column));
        salt.setText(String.format("%.1f", calculator.getSalt()));
        breakStoneOut.setText(String.valueOf(breakStone));
        workFlowOut.setText(String.format("%.1f", calculator.flow()));
        capacityOut.setText(String.format("%.1f", calculator.capacity()));


        inputAnalyze = "NO3 - " + no3 + " mg/l, " + "SO4 - " + so4 + " mg/l, " + "Hardness - " + hardness + " mg-eq/l";
        equipment = " Size of column - " + sizeOfColumn + ", Consume of salt - " + String.valueOf(naClConsume) + "g/l";
        outInfo = "gap of NO3 - " + calculator.gap() + "" + "flow - " + calculator.flow() + "capacity - " + calculator.capacity();


        outputText.setText(inputAnalyze + "\n" + equipment);


        super.onViewCreated(view, savedInstanceState);
    }


}