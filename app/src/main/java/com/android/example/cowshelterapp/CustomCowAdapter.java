package com.android.example.cowshelterapp;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class CustomCowAdapter extends RecyclerView.Adapter<CustomCowAdapter.CowViewHolder> {

    int countOfClicks = 0;
    OnClickHandler mClickHandler;
    RecyclerView recyclerView;

    @NonNull
    @Override
    public CustomCowAdapter.CowViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_item, viewGroup, false);
        CowViewHolder ch = new CowViewHolder(v);

        return ch;
    }


    public interface OnClickHandler {
        void onChildClick(View v, int color);
    }


    @Override
    public void onBindViewHolder(@NonNull final CowViewHolder cowViewHolder, int i) {



        final GradientDrawable gd = (GradientDrawable) cowViewHolder.image.getDrawable().getCurrent();
        final ImageView exclamation = cowViewHolder.exclamation;
        final ImageView smily = cowViewHolder.smily;

        gd.setColor(Color.WHITE);
        cowViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countOfClicks++;
                switch (countOfClicks) {
                    case 1:

                        gd.setColor(ColorUtils.colorsArray[cowViewHolder.getAdapterPosition()][countOfClicks]);

                        break;
                    case 2:

                        gd.setColor(ColorUtils.colorsArray[cowViewHolder.getAdapterPosition()][countOfClicks]);

                        break;
                    case 3:
                        gd.setColor(ColorUtils.colorsArray[cowViewHolder.getAdapterPosition()][countOfClicks]);


                        break;

                    default:

                        gd.setColor(ColorUtils.colorsArray[cowViewHolder.getAdapterPosition()][countOfClicks]);
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

    public class CowViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, OnClickHandler {
        public ImageView image;
        public ImageView exclamation;
        public ImageView smily;

        public CowViewHolder(@NonNull View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.image);
            this.exclamation = itemView.findViewById(R.id.exclamation);
            this.smily = itemView.findViewById(R.id.smily);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            int color = ColorUtils.colorsArray[position][countOfClicks];
            onChildClick(v, color);
        }


        public void onChildClick(View v, int color) {
            setColorToChild(v, color);
        }
    }


    public View setColorToChild(View v, int color) {

        int number = getItemCount();

        for (int i = 0; i < number; i++) {
            View m = recyclerView.getChildAt(i);
            v.ge
            v.setBackgroundColor(color);


        }
        return v;
    }
}
