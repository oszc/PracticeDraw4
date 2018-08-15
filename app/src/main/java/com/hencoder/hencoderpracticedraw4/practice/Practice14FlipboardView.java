package com.hencoder.hencoderpracticedraw4.practice;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.*;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.animation.LinearInterpolator;
import com.hencoder.hencoderpracticedraw4.R;

public class Practice14FlipboardView extends PracticeView{
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG) ;
    Bitmap bitmap;
    Camera camera = new Camera();
    int degree;
    ObjectAnimator animator = ObjectAnimator.ofInt(this, "degree", 0, 180);

    Rect rectUpper = new Rect();
    Rect rectUpperHalf = new Rect();
    Rect rectLower = new Rect();
    Rect rectLowerHalf = new Rect();



    public Practice14FlipboardView(Context context) {
        super(context);
    }

    public Practice14FlipboardView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice14FlipboardView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void init(Context context, AttributeSet attrs, int defStyleAttr) {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }
    {

        animator.setDuration(2500);
        animator.setInterpolator(new LinearInterpolator());
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        animator.start();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        animator.end();
    }

    @SuppressWarnings("unused")
    public void setDegree(int degree) {
        this.degree = degree;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int x = centerX - bitmapWidth / 2;
        int y = centerY - bitmapHeight / 2;

        rectUpperHalf.left=0;
        rectUpperHalf.top=0;
        rectUpperHalf.right=bitmapWidth;
        rectUpperHalf.bottom=bitmapHeight/2;

        rectUpper.left = x;
        rectUpper.top = y;
        rectUpper.right = x + bitmapWidth;
        rectUpper.bottom = y + bitmapHeight/2;

        rectLower.left = x;
        rectLower.top = rectUpper.bottom;
        rectLower.right = rectUpper.right;
        rectLower.bottom = rectLower.top + bitmapHeight/2;

        rectLowerHalf.left = 0;
        rectLowerHalf.top = bitmapHeight/2;
        rectLowerHalf.right = bitmapWidth;
        rectLowerHalf.bottom = bitmapHeight;

        canvas.drawBitmap(bitmap,rectUpperHalf,rectUpper,mDefaultPaint);

        canvas.save();

        camera.save();
        camera.rotateX(degree);
        canvas.translate(centerX, centerY);
        camera.applyToCanvas(canvas);
        canvas.translate(-centerX, -centerY);
        camera.restore();

        canvas.drawBitmap(bitmap, rectLowerHalf, rectLower, paint);
        canvas.restore();
    }
}
