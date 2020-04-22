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

        //String color = findViewById(R.color.colorBasic);

        final ImageView drinkgimg = (ImageView) findViewById(R.id.drinkIcon1_imageView); //물방울 모양

        final Drawable water_cup = ((ImageView)findViewById(R.id.drinkIcon_cup)).getDrawable();
        water_cup.setAlpha(0); //투명
        final Drawable water_pet = ((ImageView)findViewById(R.id.drinkIcon_pet)).getDrawable();
        water_pet.setAlpha(0); //투명


        //drinkgimg.setColorFilter(Color.parseColor("#ef5350"));
        drinkgimg.setColorFilter(colorBasic);

        seekBar.setRotation(270.0f); //seekbar 세로
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { //seekbar 리스너


            @Override
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

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                drinkgimg.setColorFilter(colorWater); //


            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
               //drinkgimg.setColorFilter(Color.parseColor("#ef5350"));
                drinkgimg.setColorFilter(colorBasic);
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