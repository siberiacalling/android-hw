package com.le.myapplication;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.le.myapplication.Fragment1.onSomeEventListener;


public class MainActivity extends AppCompatActivity implements onSomeEventListener {
    Fragment1 frag1;
    FragmentTransaction fTrans;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            frag1 = new Fragment1();
            fTrans = getFragmentManager().beginTransaction();
            fTrans.add(R.id.frgmCont, frag1);
            fTrans.commit();
        } else {
            frag1 = (Fragment1) getFragmentManager().getFragment(savedInstanceState, "Fragment1");
        }
    }

    @Override
    public void changeToFragment2(String selectedNumber) {
        Fragment2 frag2 = new Fragment2();

        Bundle bundle = new Bundle();
        bundle.putString("selectedNumber", selectedNumber);
        frag2.setArguments(bundle);

        FragmentTransaction fTrans = getFragmentManager().beginTransaction();
        fTrans.replace(R.id.frgmCont, frag2);
        fTrans.addToBackStack(null);
        fTrans.commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getFragmentManager().putFragment(outState, "Fragment1", frag1);
    }
}