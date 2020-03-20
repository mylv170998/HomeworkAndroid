package com.example.myapplication;

import android.content.Context;
import android.view.View;

public class CustomView extends View {
    public CustomView(Context context){
        super(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthSize=MeasureSpec.getSize(widthMeasureSpec);
        int width=widthSize;
        int height=width/2;
        setMeasuredDimension(width,height);
    }
}
