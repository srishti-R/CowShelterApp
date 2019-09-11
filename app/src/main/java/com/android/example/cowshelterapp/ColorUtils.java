package com.android.example.cowshelterapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.preference.PreferenceManager;

import java.util.ArrayList;
import java.util.Arrays;

public class ColorUtils {
    Context context;
    int clicks1 = 0;
    int clicks2 = 0;
    int clicks3 = 0;
    int clicks4 = 0;
    int clicks5 = 0;
    int clicks6 = 0;
    int clicks7 = 0;
    int[] clicksCount = new int[]{
            clicks1, clicks2, clicks3, clicks4, clicks5, clicks6, clicks7

    };
    ArrayList<Integer> clicksCount1 = new ArrayList() {{
        addAll(Arrays.asList(clicksCount));
    }};

    public ColorUtils(Context context) {
        this.context = context;
    }


    static int[][] colorsArray = {
            {R.color.red1, R.color.red2, R.color.red3, R.color.red4},
            {R.color.blue1, R.color.blue2, R.color.blue3, R.color.blue4},
            {R.color.green1, R.color.green2, R.color.green3, R.color.green4},
            {R.color.yellow1, R.color.yellow2, R.color.yellow3, R.color.yellow4},
            {R.color.orange1, R.color.orange2, R.color.orange3, R.color.orange4},
            {R.color.brown1, R.color.brown2, R.color.brown3, R.color.brown4},
            {R.color.grey1, R.color.grey2, R.color.grey3, R.color.grey4}

    };


}
