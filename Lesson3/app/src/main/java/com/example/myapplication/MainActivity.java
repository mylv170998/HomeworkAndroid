package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton flbtnAdd= findViewById(R.id.flbtn_add);
        final ScrollView scrollView=findViewById(R.id.sv_image);
        final LinearLayout llScroll =findViewById(R.id.scroll_linearlayout);
        flbtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                llScroll.addView(createImage(MainActivity.this));
                scrollView.post(new Runnable() {
                    @Override
                    public void run() {
                        scrollView.fullScroll(View.FOCUS_DOWN);
                    }
                });
            }
        });
    }
    public int randomImage(){
        Random random = new Random();
        int img=random.nextInt(5) +1;
        switch (img) {
            case 1:
                return R.drawable.anh_1;
            case 2:
                return R.drawable.anh_2 ;
            case 3:
                return R.drawable.anh_3;
            case 4:
                return R.drawable.anh4 ;
            case 5:
                return R.drawable.anh_5 ;

        }
        return 0;
    }
    public CustomView createImage(Context context){
        CustomView imageView = new CustomView(context);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        imageView.setLayoutParams(layoutParams);
        layoutParams.setMargins(5,5,5,0);
        imageView.setBackgroundResource(randomImage());
        return imageView;
    }

}

