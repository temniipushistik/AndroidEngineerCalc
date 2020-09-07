package com.example.watercalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private Button saveToData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //put the fragment to MainActivity
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment, InputFragment.newInstance());
        transaction.commit();



      /*
        calculate =  findViewById(R.id.buttonCalc);
        No3 =  findViewById(R.id.No3Input);
        So4 =  findViewById(R.id.So4Input);
         calculate.setOnClickListener(new View.OnClickListener() {


        @Override
            public void onClick(View view) {

                int NO3 =  (No3.getText() == null)?0:Integer.parseInt(No3.getText().toString());
                int SO4 = (So4.getText() == null)?0:Integer.parseInt(So4.getText().toString());
                calculate.setText((Integer.toString(NO3 + SO4)));
            }
        });
*/

    }

}