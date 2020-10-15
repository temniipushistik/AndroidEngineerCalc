package com.example.watercalc;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.watercalc.db.Site;
import com.example.watercalc.db.apis.GetAllDatasAsync;
import com.example.watercalc.db.apis.WriteDataAsync;

public class DbFragment extends Fragment {

    TextView DatabaseText;


    public DbFragment() {
        // Required empty public constructor


    }

    public static DbFragment newInstance() {
        DbFragment fragment = new DbFragment();

        return fragment;

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //  View rootView = inflater.inflate(R.layout.fragment_input, container, false);
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        //toolbar.setTitle("INPUT INFORMATION");
        TextView textView = getActivity().findViewById(R.id.toolbar_title);
        textView.setText("DATABASE INFORMATION");
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Site site = new Site();
       DatabaseText = view.findViewById(R.id.databaseInfo);


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

        super.onViewCreated(view, savedInstanceState);
    }
}