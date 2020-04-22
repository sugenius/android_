package com.example.water;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final int colorBasic = getResources().getColor(R.color.colorBasic); String colorBasicString = Integer.toString(colorBasic); //#ef5350
        final int colorWater = getResources().getColor(R.color.colorWater); String colorWaterString = Integer.toString(colorWater); //#509def

        textView=findViewById(R.id.seekbarValue_Textview);
        SeekBar seekBar = findViewById(R.id.drink_seekBar);

<<<<<<< HEAD
        //String color = findViewById(R.color.colorBasic);

        final ImageView drinkgimg = (ImageView) findViewById(R.id.drinkIcon1_imageView); //물방울 모양

        final Drawable water_cup = ((ImageView)findViewById(R.id.drinkIcon_cup)).getDrawable();
        water_cup.setAlpha(0); //투명
        final Drawable water_pet = ((ImageView)findViewById(R.id.drinkIcon_pet)).getDrawable();
        water_pet.setAlpha(0); //투명


        //drinkgimg.setColorFilter(Color.parseColor("#ef5350"));
        drinkgimg.setColorFilter(colorBasic);

        seekBar.setRotation(270.0f); //seekbar 세로
=======
        final ImageView drinkgimg = (ImageView) findViewById(R.id.drinkIcon1_imageView);

        drinkgimg.setColorFilter(Color.parseColor("#509def"));

        seekBar.setRotation(270.0f); //세로
>>>>>>> 6f59bba71745f138912070520ac67a70af445452
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { //seekbar 리스너


            @Override
<<<<<<< HEAD
            public void onProgressChanged(SeekBar seekBar, int seekbarValue, boolean fromUser) {
                int drinkValue = seekbarValue*100; //단위 조절
                textView.setText(drinkValue +"ml");

                if(drinkValue>300 && drinkValue<500) {
                    drinkgimg.setAlpha(0);
                    water_cup.setAlpha(255);
                    water_pet.setAlpha(0);
                }
                else if(drinkValue>500) {
                    drinkgimg.setAlpha(0);
                    water_cup.setAlpha(0);
                    water_pet.setAlpha(255);
                }
                else if(drinkValue<300) {
                    drinkgimg.setAlpha(255);
                    water_cup.setAlpha(0);
                    water_pet.setAlpha(0);
                }

=======
            public void onProgressChanged(SeekBar seekBar, int drinkValue, boolean fromUser) {
                if(drinkValue>0) drinkgimg.setColorFilter(Color.parseColor("#509def"));
                else if(drinkValue>30) drinkgimg.setColorFilter(Color.parseColor("#ef5350")); //*
                textView.setText(drinkValue+"ml");
>>>>>>> 6f59bba71745f138912070520ac67a70af445452
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
<<<<<<< HEAD
                drinkgimg.setColorFilter(colorWater); //


=======
                drinkgimg.setColorFilter(Color.parseColor("#509def"));
>>>>>>> 6f59bba71745f138912070520ac67a70af445452
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
<<<<<<< HEAD
                //drinkgimg.setColorFilter(Color.parseColor("#ef5350"));
=======
<<<<<<< HEAD
               //drinkgimg.setColorFilter(Color.parseColor("#ef5350"));
>>>>>>> 4d92a696d3debda8fe3c9846bca85bb4b4072923
                drinkgimg.setColorFilter(colorBasic);
=======
                drinkgimg.setColorFilter(null);
                drinkgimg.setColorFilter(Color.parseColor("#509def"));
>>>>>>> 6f59bba71745f138912070520ac67a70af445452
            }
        });
    }

    public static void setSeekberThumb(final SeekBar seekBar, final Resources res) {
        seekBar.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {

                if (seekBar.getHeight() > 0) {
                    Drawable thumb = res.getDrawable(R.drawable.seekbar_thumb);
                    int h = seekBar.getMeasuredHeight();
                    int w = h;
                    Bitmap bmpOrg = ((BitmapDrawable) thumb).getBitmap();
                    Bitmap bmpScaled = Bitmap.createScaledBitmap(bmpOrg, w, h, true);
                    Drawable newThumb = new BitmapDrawable(res, bmpScaled);
                    newThumb.setBounds(0, 0, newThumb.getIntrinsicWidth(), newThumb.getIntrinsicHeight());
                    seekBar.setThumb(newThumb);
                    seekBar.getViewTreeObserver().removeOnPreDrawListener(this);
                }
                return true;
            }
        });
    }


}