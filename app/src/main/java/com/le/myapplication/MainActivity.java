package com.le.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {
    Fragment1 frag1;
    Fragment2 frag2;
    FragmentTransaction fTrans;
    Integer currentFragment = 1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        frag1 = new Fragment1();
        frag2 = new Fragment2();

        fTrans = getFragmentManager().beginTransaction();
        fTrans.add(R.id.frgmCont, frag1);
        fTrans.addToBackStack(null);
        fTrans.commit();
    }

    public void replaceFragment() {
        fTrans = getFragmentManager().beginTransaction();
        if (currentFragment == 1) {
            fTrans.replace(R.id.frgmCont, frag2);
            // frag2.setTextViewText("puk");
            currentFragment = 2;
        } else {
            fTrans.replace(R.id.frgmCont, frag1);
            currentFragment = 1;
        }

        fTrans.addToBackStack(null);
        fTrans.commit();
    }

}