package com.le.myapplication;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    Fragment1 frag1;
    Fragment2 frag2;
    FragmentTransaction fTrans;

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

    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.btnAdd:
//                fTrans.add(R.id.frgmCont, frag1);
//                break;
//            case R.id.btnRemove:
//                fTrans.remove(frag1);
//                break;
//            case R.id.btnReplace:
//                fTrans.replace(R.id.frgmCont, frag2);
//            default:
//                break;
//        }
    }
}