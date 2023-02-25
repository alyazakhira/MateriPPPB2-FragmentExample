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
    public static SimpleFragment newInstance(){return new SimpleFragment();}



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
// static menggunakan fragment di xml, dynamic menggunakan FrameLayout, Dynamic menggunakan wadah kemudian akan diisi.
// Kalau makai fragmen dinamis itu kalau hilang artinya benar benar hilang. Kalau static di hide itu artinya hanya hilang tampilan tapi tetap masih memakan memori.

        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final RadioGroup radioGroup =  view.findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                View radioButton = radioGroup.findViewById(i);
                int index = radioGroup.indexOfChild(radioButton);
                TextView textView = view.findViewById(R.id.fragment_header);
                switch (index){
                    case YES :
                        textView.setText(R.string.yes_message);break;
                    case NO :
                        textView.setText(R.string.no_message);break;
                    default:
                        break;
                }
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