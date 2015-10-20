package com.example.fragmenttest;

import android.app.Fragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;



public class loginaty extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_loginaty, container, false);
//        textView = (TextView) view.findViewById(R.id.textView8);
//        //调用来自MainActivity的text
//        String text = getArguments().getString("text");
//        textView.setText(text);
//        if(text=="极客学院02"){
//            view = inflater.inflate(R.layout.activity_main, container, false);
//            textView.setText("asdfjkl");
//        }

        return view;
    }
}
