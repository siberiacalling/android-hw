package com.le.myapplication;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Fragment1 extends Fragment implements MyRecyclerViewAdapter.ItemClickListener {
    MyRecyclerViewAdapter adapter;
    Button addBtn;
    Integer currentNumber;

    public interface onSomeEventListener {
        public void changeToFragment2(String s);
    }
    onSomeEventListener EventListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            EventListener = (onSomeEventListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onSomeEventListener");
        }
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            currentNumber = 100;
        } else {
            currentNumber = savedInstanceState.getInt("currentNumber");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment1, null);


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
        EventListener.changeToFragment2(Integer.toString(adapter.getItem(position)));
    }
}