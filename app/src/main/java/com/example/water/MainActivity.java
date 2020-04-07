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

        textView=findViewById(R.id.drinkValue_Textview);
        SeekBar seekBar = findViewById(R.id.drink_seekBar);

        seekBar.setRotation(270.0f); //세로
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { //seekbar 리스너
            ImageView drinkgimg = (ImageView) findViewById(R.id.drinkIcon1_imageView);

            @Override
            public void onProgressChanged(SeekBar seekBar, int drinkValue, boolean fromUser) {
                if(drinkValue>0) drinkgimg.setColorFilter(Color.parseColor("#509def"));
                //else if(drinkValue>30) drinkgimg.setColorFilter(Color.parseColor("#ef5350")); //*
                textView.setText(drinkValue+"ml");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //drinkgimg.setColorFilter(Color.parseColor("#509def"));
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //drinkgimg.setColorFilter(null);
                //drinkgimg.setColorFilter(Color.parseColor("#509def"));
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
