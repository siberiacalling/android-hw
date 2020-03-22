package com.le.myapplication;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Fragment1 extends Fragment implements MyRecyclerViewAdapter.ItemClickListener {
    MyRecyclerViewAdapter adapter;
    Button addBtn;
    Integer currentNumber;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment1, null);
        if (savedInstanceState == null) {
            currentNumber = 100;
        } else {
            currentNumber = savedInstanceState.getInt("currentNumber");
        }

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= currentNumber; i++) {
            numbers.add(i);
        }

        RecyclerView recyclerView = rootView.findViewById(R.id.recycleViewNumbers);
        int columnNumber = 3;
        if (getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            columnNumber = 4;
        }
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), columnNumber));

        adapter = new MyRecyclerViewAdapter(getActivity(), numbers);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);

        addBtn = rootView.findViewById(R.id.addButton);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber++;
                Toast.makeText(getActivity().getApplicationContext(),
                        "Number: " + currentNumber, Toast.LENGTH_SHORT).show();
                adapter.mData.add(currentNumber, currentNumber);
                adapter.notifyItemInserted(currentNumber);
            }
        };
        addBtn.setOnClickListener(onClickListener);
        return rootView;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("currentNumber", currentNumber);
    }


    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getActivity(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();

        Fragment2 frag2 = new Fragment2();

        Bundle bundle = new Bundle();
        bundle.putString("test", Integer.toString(adapter.getItem(position)));
        frag2.setArguments(bundle);

        FragmentTransaction fTrans = getFragmentManager().beginTransaction();
        fTrans.replace(R.id.frgmCont, frag2);
        fTrans.addToBackStack(null);
        fTrans.commit();
    }
}