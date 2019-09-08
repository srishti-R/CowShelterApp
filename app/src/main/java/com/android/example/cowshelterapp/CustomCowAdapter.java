package com.android.example.cowshelterapp;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class CustomCowAdapter extends RecyclerView.Adapter<CustomCowAdapter.CowViewHolder> {
    ColorUtils colorUtils = new ColorUtils();
    int countOfClicks = 0;
    Context context;


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
                int color = colorUtils.thisWasClicked(cowViewHolder);
                if (color > 0) {
                    gd.setColor(ContextCompat.getColor(context, color));
                }
                if (color < 0) {
                    gd.setColor(Color.WHITE);
                    exclamation.setVisibility(View.GONE);
                    smily.setVisibility(View.VISIBLE);

                }


            }
        });

    }


    @Override
    public int getItemCount() {
        return 7;
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






