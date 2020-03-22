package com.le.myapplication;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Fragment1 frag1;
    FragmentTransaction fTrans;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            Toast.makeText(this, "new shit", Toast.LENGTH_SHORT).show();
            frag1 = new Fragment1();
            fTrans = getFragmentManager().beginTransaction();
            fTrans.add(R.id.frgmCont, frag1);
            fTrans.addToBackStack(null);
            fTrans.commit();
        } else {
            Toast.makeText(this, "old shit", Toast.LENGTH_SHORT).show();
            frag1 = (Fragment1) getFragmentManager().getFragment(savedInstanceState, "Fragment1");
        }
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        getFragmentManager().putFragment(outState, "Fragment1", frag1);
    }
}