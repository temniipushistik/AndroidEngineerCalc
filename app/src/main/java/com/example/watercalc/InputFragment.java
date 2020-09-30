package com.example.watercalc;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import android.widget.Spinner;


import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InputFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InputFragment extends Fragment {

    //reading from editView
    EditText no3;
    EditText so4;
    EditText hardness;
    EditText NameOfAProject;
    private RadioButton naClConsumeRadio125;
    private RadioButton naClConsumeRadio250;
    private RadioGroup naClConsumeRadioGroup;
    //  private String sizeOfColumn;

    private Button calculateButton;

    private Bundle bundle = new Bundle();
    OutputFragment fragment = new OutputFragment();


    //create an object for transferring info from bundle


    public InputFragment() {
        // Required empty public constructor


    }

    public static InputFragment newInstance() {
        InputFragment fragment = new InputFragment();


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
        return inflater.inflate(R.layout.fragment_input, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        no3 = view.findViewById(R.id.No3Input);
        so4 = view.findViewById(R.id.So4Input);
        hardness = view.findViewById(R.id.Hardness_input);
        NameOfAProject = view.findViewById(R.id.NameOfAProject);
        final Spinner columnSpinner = view.findViewById(R.id.spinner);

// configuration an adapter. The Adapter connects spinner and array
        ArrayAdapter<CharSequence> adapter =
                ArrayAdapter.createFromResource(getContext(), R.array.columns, android.R.layout.simple_spinner_item);//view of the current element
        // selection style of markup(разметка) for the list of items
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// attach the adapter to the spinner
        columnSpinner.setAdapter(adapter);
//create a listener. It listens which position in the spinner was selected
        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {


            //<?> means the compiler doesn't know type of info
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String item = (String) adapterView.getItemAtPosition(i);
                bundle.putString("sizeOfColumn", item);

                //put the correct item to bundle
                switch (item) {
                    case "8x44":
                        bundle.putDouble("column", 20);
                        bundle.putDouble("square", 0.033);
                        bundle.putInt("breakstone", 6);
                        break;
                    case "10x44":
                        bundle.putDouble("column", 25);
                        bundle.putDouble("square", 0.052);
                        bundle.putInt("breakstone", 10);
                        break;
                    case "10x54":
                        bundle.putDouble("column", 38);
                        bundle.putDouble("square", 0.052);
                        bundle.putInt("breakstone", 10);
                        break;
                    case "12x52":
                        bundle.putDouble("column", 50);
                        bundle.putDouble("square", 0.074);
                        bundle.putInt("breakstone", 15);
                        break;
                    case "13x54":
                        bundle.putDouble("column", 50);
                        bundle.putDouble("square", 0.088);
                        bundle.putInt("breakstone", 15);
                        break;
                    case "14x65":
                        bundle.putDouble("column", 85);
                        bundle.putDouble("square", 0.105);
                        bundle.putInt("breakstone", 20);
                        break;
                    case "16x65":
                        bundle.putDouble("column", 113);
                        bundle.putDouble("square", 0.133);
                        bundle.putInt("breakstone", 30);
                        break;
                    case "18x65":
                        bundle.putDouble("column", 150);
                        bundle.putDouble("square", 0.189);
                        bundle.putInt("breakstone", 40);
                        break;


                }
                fragment.setArguments(bundle);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };
        //attach selectListener to columnSpinner

        columnSpinner.setOnItemSelectedListener(itemSelectedListener);

        final RadioGroup naClConsumeRadioGroup = view.findViewById(R.id.radioGroupNaCl);
        naClConsumeRadio125 = view.findViewById(R.id.radioButton125);
        naClConsumeRadio250 = view.findViewById(R.id.radioButton250);
        //connect button from class to button in xml
        calculateButton = view.findViewById(R.id.buttonCalc);
        //create listening by anonymous class

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!no3.getText().toString().equals("") &&
                        !so4.getText().toString().equals("") &&
                        !hardness.getText().toString().equals("") &&
                        !NameOfAProject.getText().toString().equals("")) {


                    //transferring info from fragment input to bundle
                    bundle.putDouble("NO3", Double.valueOf(no3.getText().toString()));
                    bundle.putDouble("SO4", Double.valueOf(so4.getText().toString()));
                    bundle.putDouble("Hardness", Double.valueOf(hardness.getText().toString()));
                    bundle.putString("NameOfSite", NameOfAProject.getText().toString());
                    //create logic with radiobutton
                    int checkedRadioButtonId = naClConsumeRadioGroup.getCheckedRadioButtonId();
                    if (checkedRadioButtonId == R.id.radioButton125) {
                        bundle.putInt("naClConsume", 125);
                    } else {
                        bundle.putInt("naClConsume", 250);
                    }


                    fragment.setArguments(bundle);
                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                    //wtf
                    transaction.add(R.id.fragment, fragment);

                    transaction.addToBackStack(null);
                    transaction.commit();
                } else {
                    Toast.makeText(getActivity(), "Not all field was filled ! ", Toast.LENGTH_LONG).show();
                }
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

}