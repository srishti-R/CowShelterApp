package com.android.example.cowshelterapp;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class RowOne extends AppCompatActivity {
    ColorUtils colorUtils = new ColorUtils();
    GradientDrawable gd;
    CustomCowAdapter adapter;
    // private final String KEY_RECYCLER_STATE = "recycler_state";
    private RecyclerView recyclerView;
    //private static Bundle mBundleRecyclerViewState;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);
        if (savedInstanceState != null) {
            savedInstanceState.getIntegerArrayList("clicks-count");

        }

        recyclerView = findViewById(R.id.recycler_view);
        //recyclerView.getLayoutManager().scrollToPosition(......);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        adapter = new CustomCowAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(gridLayoutManager);

        gd = (GradientDrawable) getResources().getDrawable(R.drawable.icon_bg);
        //adapter.readFromSharedPref(gd);
        // adapter.readFromMap(adapter.maps, );
        // adapter.set

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

   *//* public void readFromSharedPref(GradientDrawable drawable) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        int click1 = preferences.getInt("1", 0);
        colorUtils.setColorToDrawable()

    }*/
}
