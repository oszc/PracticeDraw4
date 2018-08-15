package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.*;
import android.util.AttributeSet;
import android.view.View;

/**
 * 2018/8/8  10:31 AM
 * Created by Zhang.
 */
abstract class PracticeView extends View {

    protected int mWidth = 0;
    protected int mHeight = 0;
    protected Point mCenter  = null;
    protected Paint mDefaultPaint = new Paint();
    protected Path mDefaultPath = new Path();
    protected Matrix mMatrix = new Matrix();
    protected int mBmpHalfWidth,mBmpHalfHeight;
    protected Camera mCamera = new Camera();

    public PracticeView(Context context) {
        this(context,null);
    }

    public PracticeView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public PracticeView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mDefaultPaint.setStyle(Paint.Style.FILL);
        mDefaultPaint.setColor(Color.BLACK);
        mDefaultPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        init(context,attrs,defStyleAttr);
    }
    protected abstract void init(Context context, AttributeSet attrs, int defStyleAttr);

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
        mCenter = new Point(mWidth/2,mHeight/2);
    }
}
