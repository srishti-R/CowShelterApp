package com.android.example.cowshelterapp;

import android.content.SharedPreferences;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class RowOne extends AppCompatActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
    ColorUtils colorUtils = new ColorUtils();
    GradientDrawable gd;
    CustomCowAdapter adapter;
    Bundle bundle;

    private RecyclerView recyclerView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        if (savedInstanceState != null) {

            colorUtils.clicks1 = savedInstanceState.getInt("clicks1");
            Log.e("savedinstancestate", "getting bundle");

        }


        recyclerView = findViewById(R.id.recycler_view);
        //recyclerView.getLayoutManager().scrollToPosition(......);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new CustomCowAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(gridLayoutManager);

        // gd = (GradientDrawable) getResources().getDrawable(R.drawable.icon_bg);
        // PreferenceManager.getDefaultSharedPreferences(this).registerOnSharedPreferenceChangeListener(this);

        //adapter.readFromSharedPref(gd);
        // adapter.readFromMap(adapter.maps, );
        // adapter.set

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        PreferenceManager.getDefaultSharedPreferences(this).unregisterOnSharedPreferenceChangeListener(this);
    }

    public void readFromSpAndUpdateBundle() {
        Log.e("readsp", "reading sp");
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        colorUtils.clicks1 = preferences.getInt("0", 0);
        bundle = new Bundle();
        bundle.putInt("clicks1", colorUtils.clicks1);


    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        colorUtils.clicks1 = preferences.getInt("0", 0);
        Log.e("onResume", String.valueOf(colorUtils.clicks1));
    }


    @Override
    protected void onPause() {
        super.onPause();
        //writeToSharedPref(colorUtils.clicks1, 0, 0, 0, 0, 0, 0);
        readFromSpAndUpdateBundle();

        Log.e("onPause", String.valueOf(colorUtils.clicks1));
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.equals("0")) {
            sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            Log.e("sharechange listener2", "saving clicks");
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putInt("0", colorUtils.clicks1);
            editor.commit();
        }
    }

    public void writeToSharedPref(int clicks1, int clicks2, int clicks3, int clicks4, int clicks5, int clicks6, int clicks7) {
        colorUtils.clicks1 = clicks1;
        colorUtils.clicks2 = clicks2;
        colorUtils.clicks3 = clicks3;
        colorUtils.clicks4 = clicks4;
        colorUtils.clicks5 = clicks5;
        colorUtils.clicks6 = clicks6;
        colorUtils.clicks7 = clicks7;


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("1", clicks1);
        editor.putInt("2", clicks2);
        editor.putInt("3", clicks3);
        editor.putInt("4", clicks4);
        editor.putInt("5", clicks5);
        editor.putInt("6", clicks6);
        editor.putInt("7", clicks7);
        editor.apply();

    }
}

    /*@Override
    protected void onResume() {
        super.onResume();
        // adapter.readFromSharedPref(gd);
        if (mBundleRecyclerViewState != null) {
            Parcelable listState = mBundleRecyclerViewState.getParcelable(KEY_RECYCLER_STATE);
            recyclerView.getLayoutManager().onRestoreInstanceState(listState);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        //adapter.readFromSharedPref(gd);
    }

    @Override
    protected void onPause() {
        super.onPause();

        mBundleRecyclerViewState = new Bundle();
        Parcelable listState = recyclerView.getLayoutManager().onSaveInstanceState();
        mBundleRecyclerViewState.putParcelable(KEY_RECYCLER_STATE, listState);

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList("clicks-count", colorUtils.clicksCount1);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }

    public void readFromSharedPref(GradientDrawable drawable) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        int click1 = preferences.getInt("1", 0);
        colorUtils.setColorToDrawable()

    }*/




