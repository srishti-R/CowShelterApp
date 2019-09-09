package com.android.example.cowshelterapp;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class RowOne extends AppCompatActivity {
    GradientDrawable gd;
    CustomCowAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new CustomCowAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(gridLayoutManager);

        gd = (GradientDrawable) getResources().getDrawable(R.drawable.icon_bg);
        adapter.readFromSharedPref(gd);

    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.readFromSharedPref(gd);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.readFromSharedPref(gd);
    }
}
