package com.le.myapplication;
import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment2 extends Fragment {
    TextView tv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment2, null);
        tv = (TextView) rootView.findViewById(R.id.textViewFrag2);
        tv.setTextColor(Color.argb(255, 255, 255, 255));

        Bundle bundle = getArguments();
        if (bundle != null) {
            String numberString = bundle.getString("test");
            if (numberString != null) {
                tv.setText(numberString);
            }
            int number = Integer.parseInt(numberString);
            if (number % 2 == 0) {
                tv.setBackgroundColor(Color.argb(150, 141, 1, 1));
            } else {
                tv.setBackgroundColor(Color.argb(150, 15, 1, 141));
            }
        }
        return rootView;
    }
}