package com.example.arturmusayelyan.recyclerviewdemo3touch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class RecyclerView1 extends AppCompatActivity implements ClickListener {
    RecyclerView recyclerView;
    String[] titlesArray;
    int[] flagsArray;
    ArrayList<SingleRow> resourciesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view1);

        flagsArray = new int[]{R.drawable.flag1, R.drawable.flag2, R.drawable.flag3, R.drawable.flag4, R.drawable.flag5, R.drawable.flag6, R.drawable.flag7, R.drawable.flag8, R.drawable.flag9, R.drawable.flag9a};
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView1);
        resourciesList = new ArrayList<>();
        titlesArray = getResources().getStringArray(R.array.countries);
        for (int i = 0; i < 10; i++) {
            resourciesList.add(new SingleRow(titlesArray[i], flagsArray[i]));
        }

        MyCustomAdapter1 adapter = new MyCustomAdapter1(this, resourciesList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.setClickListener(this);
    }


    @Override
    public void itemClicked(View view, int position) {
        Toast.makeText(this, "position " + position, Toast.LENGTH_SHORT).show();
    }
}
