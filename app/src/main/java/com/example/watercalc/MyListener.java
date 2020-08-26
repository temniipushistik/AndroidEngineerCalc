package com.example.watercalc;

import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import android.view.View;

import androidx.fragment.app.FragmentTransaction;

public class MyListener extends FragmentActivity implements View.OnClickListener {

    @Override
    public void onClick(View view) {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.add(R.id.fragment, OutputFragment.newInstance());
        transaction.commit();
    }
}

