package com.example.watercalc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        textView = findViewById(R.id.toolbar_title);
        setSupportActionBar(toolbar);
        getSupportFragmentManager().addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.fragment);
                String fragmentName = fragment.getClass().getSimpleName();
                switch (fragmentName) {
                    case "InputFragment":
                        textView.setText("INPUT INFORMATION");
                        break;
                    case "OutputFragment":
                        textView.setText("OUTPUT INFORMATION");
                        break;
                }
            }
        });
        //put the fragment to MainActivity
        textView.setText("INPUT INFORMATION");
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.fragment, InputFragment.newInstance());
        transaction.commit();
    }
}