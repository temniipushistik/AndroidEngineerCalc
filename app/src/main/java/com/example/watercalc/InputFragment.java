package com.example.watercalc;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
    private RadioButton naClConsumeRadio125;
    private RadioButton naClConsumeRadio250;
    private RadioGroup naClConsumeRadioGroup;

    private Button calculateButton;

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
        final RadioGroup naClConsumeRadioGroup=view.findViewById(R.id.radioGroupNaCl);
        naClConsumeRadio125 = view.findViewById(R.id.radioButton125);
        naClConsumeRadio250=view.findViewById(R.id.radioButton250);
        //connect button from class to button in xml
        calculateButton = view.findViewById(R.id.buttonCalc);
        //create listening by anon class
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!no3.getText().toString().equals("") &&
                        !so4.getText().toString().equals("") &&
                        !hardness.getText().toString().equals(""))
            {
                    OutputFragment fragment = new OutputFragment();
                    Bundle bundle = new Bundle();
                    //transferring info from fragment input to bundle
                    bundle.putInt("NO3", Integer.valueOf(no3.getText().toString()));
                    bundle.putInt("SO4", Integer.valueOf(so4.getText().toString()));
                    bundle.putInt("Hardness", Integer.valueOf(hardness.getText().toString()));
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
                } else{
                    Toast.makeText(getActivity(), "Not all field was filled ! ", Toast.LENGTH_LONG).show();
                }
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }
}