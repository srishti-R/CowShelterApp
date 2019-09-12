package com.android.example.cowshelterapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.HashMap;

public class CustomCowAdapter extends RecyclerView.Adapter<CustomCowAdapter.CowViewHolder> {

    HashMap<Integer, Integer> maps;
    Context context;
    ColorUtils colorUtils = new ColorUtils();

    public CustomCowAdapter(Context myContext) {
        super();
        this.context = myContext;
    }

    @NonNull
    @Override
    public CustomCowAdapter.CowViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_item, viewGroup, false);
        CowViewHolder ch = new CowViewHolder(v);


        return ch;
    }



    @Override
    public void onBindViewHolder(@NonNull final CowViewHolder cowViewHolder, final int i) {


        final GradientDrawable gd = (GradientDrawable) cowViewHolder.image.getDrawable().getCurrent();

        final ImageView exclamation = cowViewHolder.exclamation;
        final ImageView smily = cowViewHolder.smily;


        cowViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int color;
                //Toast.makeText(context, cowViewHolder.getAdapterPosition(), Toast.LENGTH_SHORT).show();
                Log.e("position", String.valueOf(cowViewHolder.getAdapterPosition()));
                SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(v.getContext());
                if (preferences.contains(String.valueOf(cowViewHolder.getAdapterPosition()))) {

                    color = preferences.getInt(String.valueOf(cowViewHolder.getAdapterPosition()), Color.WHITE);
                    gd.setColor(ContextCompat.getColor(v.getContext(), color));
                    preferences.edit().clear().apply();
                    Log.e("reached if", "clearing shared prefs now");
                } else {

                    color = colorUtils.thisWasClicked(cowViewHolder);
                    if (color > 0) {
                        gd.setColor(ContextCompat.getColor(v.getContext(), color));
                    }
                    if (color < 0) {
                        gd.setColor(Color.WHITE);
                        exclamation.setVisibility(View.GONE);
                        smily.setVisibility(View.VISIBLE);
                        Log.e("color<0", "end of click cycle");
                    }

                }
                Log.e("write to shared pref", "reached");
                writeToSharedPref(color, cowViewHolder.getAdapterPosition(), v);
                Log.e("end of write to sp", "saving prefs");
                // color = colorUtils.thisWasClicked(cowViewHolder);


               /*  maps=new HashMap<>();
                Integer position=cowViewHolder.getAdapterPosition();
                maps.put(position, color);
                readFromMap(maps, cowViewHolder);*/



            }
        });

    }


    @Override
    public int getItemCount() {
        return 7;
    }

    public class CowViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private ImageView exclamation;
        private ImageView smily;

        public CowViewHolder(@NonNull View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.image);


            this.exclamation = itemView.findViewById(R.id.exclamation);
            this.smily = itemView.findViewById(R.id.smily);

        }


    }

    public void writeToSharedPref(int color, int position, View v) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(v.getContext());
        SharedPreferences.Editor editor = preferences.edit();
        //int position = holder.getAdapterPosition();
        editor.putInt(String.valueOf(position), color);
        editor.apply();

    }

  /* public int readFromSharedPref(CowViewHolder holder) {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
         int color = preferences.getInt(String.valueOf(holder.getAdapterPosition()), Color.WHITE);
       return color;

    }*/
  /*  public void readFromMap(HashMap<Integer, Integer> hashMap, int position ){

        int color= hashMap.get(position);
    }
*/

}






