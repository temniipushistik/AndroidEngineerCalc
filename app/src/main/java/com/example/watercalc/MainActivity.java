package com.example.watercalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity {
    Button calculate;
    EditText No3;
    EditText So4;
    


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        calculate = (Button) findViewById(R.id.buttonCalc);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                No3 = (EditText) findViewById(R.id.No3Input);
                So4 = (EditText) findViewById(R.id.So4Input);
                int NO3 =  (No3.getText() == null)?0:Integer.parseInt(No3.getText().toString());
                int SO4 = (So4.getText() == null)?0:Integer.parseInt(So4.getText().toString());
                calculate.setText(NO3+SO4);
            }
        });


    }


}