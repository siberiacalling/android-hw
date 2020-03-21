package com.le.myapplication;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Fragment2 extends Fragment {
    Button backBtn;
    TextView tv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment2, null);

        tv = (TextView)rootView.findViewById(R.id.textViewFrag2);
        backBtn = rootView.findViewById(R.id.backButton);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity().getApplicationContext(),
                        "Back!", Toast.LENGTH_SHORT).show();
                ((MainActivity) getActivity()).replaceFragment();
            }
        };
        backBtn.setOnClickListener(onClickListener);
        return rootView;
    }


    public void setTextViewText(String value) {
        tv.setText(value);
    }
}