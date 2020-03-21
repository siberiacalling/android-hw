package com.le.myapplication;

import android.app.Fragment;
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
    Integer currentNumber = 100;
    Integer currentIndex = 100;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment1, container, false);
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            numbers.add(i);
        }

        RecyclerView recyclerView = rootView.findViewById(R.id.recycleViewNumbers);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        adapter = new MyRecyclerViewAdapter(getActivity(), numbers);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        addBtn = rootView.findViewById(R.id.addButton);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber++;
                currentIndex++;
                Toast.makeText(getActivity().getApplicationContext(),
                        "Number: " + currentNumber + "Index: " + currentIndex, Toast.LENGTH_SHORT).show();


                adapter.mData.add(currentIndex, currentNumber);
                adapter.notifyItemInserted(currentIndex);
            }
        };
        addBtn.setOnClickListener(onClickListener);
        return rootView;
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(getActivity(), "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}