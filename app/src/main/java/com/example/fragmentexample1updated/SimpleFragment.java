package com.example.fragmentexample1updated;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

public class SimpleFragment extends Fragment {
    public static final int YES = 0;
    public static final int NO = 1;

    public SimpleFragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final RadioGroup radioGroup =  view.findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener((radioGroup1, i) -> {
            View radioButton = radioGroup1.findViewById(i);
            int index = radioGroup1.indexOfChild(radioButton);
            TextView textView = view.findViewById(R.id.fragment_header);
            switch (index){
                case YES :
                    textView.setText(R.string.yes_message);break;
                case NO :
                    textView.setText(R.string.no_message);break;
                default:
                    break;
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_simple, container, false);
    }
}