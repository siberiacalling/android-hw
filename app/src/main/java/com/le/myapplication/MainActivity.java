package com.le.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements MyRecyclerViewAdapter.ItemClickListener {

    MyRecyclerViewAdapter adapter;
    Button addBtn;
    Integer currentNumber = 100;
    Integer currentIndex = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            numbers.add(i);
        }

        RecyclerView recyclerView = findViewById(R.id.recycleViewNumbers);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        adapter = new MyRecyclerViewAdapter(this, numbers);
        adapter.setClickListener(this);
        recyclerView.setAdapter(adapter);
        addBtn = findViewById(R.id.addButton);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber++;
                currentIndex++;
                Toast.makeText(getApplicationContext(),
                        "Number: " + currentNumber + "Index: " + currentIndex, Toast.LENGTH_SHORT).show();


                adapter.mData.add(currentIndex, currentNumber);
                adapter.notifyItemInserted(currentIndex);
            }
        };
        addBtn.setOnClickListener(onClickListener);
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "You clicked " + adapter.getItem(position) + " on row number " + position, Toast.LENGTH_SHORT).show();
    }
}