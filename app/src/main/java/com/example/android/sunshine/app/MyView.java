package com.example.android.sunshine.app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Rounge on 8/1/2017.
 */

public class MyView extends View {

    Paint mCirclePaint;
    Paint mTextPaint;

    public MyView(Context context) {
        super(context);
        init();
    }
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mCirclePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setStyle(Paint.Style.STROKE);
        mCirclePaint.setColor(getResources().getColor(R.color.sunshine_dark_blue));
        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setColor(getResources().getColor(R.color.sunshine_dark_blue));
        mTextPaint.setTextSize(24);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int hSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int wSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int hSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        int wSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int myHeight = hSpecSize;
        int myWidth = wSpecSize;

        if(hSpecMode == MeasureSpec.EXACTLY) {
            myHeight = hSpecSize;
        } else if(hSpecMode == MeasureSpec.AT_MOST) {
            //Wrap content
        }

        if(wSpecMode == MeasureSpec.EXACTLY) {
            myWidth = wSpecSize;
        } else if(wSpecMode == MeasureSpec.AT_MOST) {
            //Wrap content
        }
        setMeasuredDimension(myWidth, myHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("OpenWeatherMap(TM)", 20, 20, mTextPaint);
        canvas.drawCircle(100, 100, 25, mCirclePaint);
    }
}
