package com.android.example.cowshelterapp;

import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.HashMap;
import java.util.Map;

public class CustomCowAdapter extends RecyclerView.Adapter<CustomCowAdapter.CowViewHolder> {
    ColorUtils colorUtils = new ColorUtils();
    int countOfClicks = 0;

    Map<Integer, Integer> clicksMap = new HashMap<>();


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
        //cowViewHolder.image.setTag(ColorUtils.colorsArray[cowViewHolder.getAdapterPosition()]);
        // final int[] array = (int[]) cowViewHolder.image.getTag();
        final ImageView exclamation = cowViewHolder.exclamation;
        final ImageView smily = cowViewHolder.smily;

        // gd.setColor(Color.WHITE);
        cowViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //countOfClicks++;
                HashMap<Integer, Integer> maps = colorUtils.thisWasClicked(cowViewHolder);
                int clicks = colorUtils.incrementNumberOfClicks(maps, cowViewHolder);
                notifyDataSetChanged();
                switch (clicks) {
                    case 1:

                        gd.setColor(colorUtils.setColorToDrawable(i, clicks));

                        break;
                    case 2:

                        gd.setColor(colorUtils.setColorToDrawable(i, clicks));

                        break;
                    case 3:
                        gd.setColor(colorUtils.setColorToDrawable(i, clicks));


                        break;

                    default:

                        gd.setColor(colorUtils.setColorToDrawable(i, clicks));
                        exclamation.setVisibility(View.GONE);
                        smily.setVisibility(View.VISIBLE);


                }
            }
        });

    }


    @Override
    public int getItemCount() {
        return 2;
    }

    public class CowViewHolder extends RecyclerView.ViewHolder {
        public ImageView image;
        public ImageView exclamation;
        public ImageView smily;

        public CowViewHolder(@NonNull View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.image);


            this.exclamation = itemView.findViewById(R.id.exclamation);
            this.smily = itemView.findViewById(R.id.smily);

        }
    }


}






