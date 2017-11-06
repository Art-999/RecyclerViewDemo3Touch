package com.example.arturmusayelyan.recyclerviewdemo3touch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerView2 extends AppCompatActivity {
    private RecyclerView recyclerView;
    private String[] titlesArray;
    private int[] flagsArray;
    private ArrayList<SingleRow> resourciesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view2);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView2);
        resourciesList = new ArrayList<>();
        titlesArray = getResources().getStringArray(R.array.countries);
        flagsArray = new int[]{R.drawable.flag1, R.drawable.flag2, R.drawable.flag3, R.drawable.flag4, R.drawable.flag5, R.drawable.flag6, R.drawable.flag7, R.drawable.flag8, R.drawable.flag9, R.drawable.flag9a};
        for (int i = 0; i < 10; i++) {
            resourciesList.add(new SingleRow(titlesArray[i], flagsArray[i]));
        }

    }
}
