package com.example.fragmenttest;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ContentFragment extends Fragment {

    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
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
