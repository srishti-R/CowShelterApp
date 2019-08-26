package com.android.example.cowshelterapp;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    GradientDrawable gd;
    int countOfClicks=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* ImageView view= findViewById(R.id.test);
         gd= (GradientDrawable) view.getDrawable().getCurrent();
        gd.setColor(Color.parseColor("#000000"));*/
        TextView row1=findViewById(R.id.row1);
        row1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, RowOne.class);
                startActivity(intent);
            }
        });
        TextView row2=findViewById(R.id.row2);
        row2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, RowTwo.class);
                startActivity(intent);
            }
        });
        TextView row3=findViewById(R.id.row3);
        row3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, RowThree.class);
                startActivity(intent);
            }
        });


       /* Button v=(Button)findViewById(R.id.button);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countOfClicks++;
                switch (countOfClicks) {
                    case 1:

                        gd.setColor(Color.RED);
                        break;
                    case 2:

                        gd.setColor(Color.BLUE);
                       break;

                    default:

                        gd.setColor(Color.GREEN);


                }
            }
        });*/

    }





}
