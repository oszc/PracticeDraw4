package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.*;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.hencoder.hencoderpracticedraw4.R;

public class Practice09MatrixRotateView extends PracticeView{
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);


    public Practice09MatrixRotateView(Context context) {
        super(context);
    }

    public Practice09MatrixRotateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice09MatrixRotateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void init(Context context, AttributeSet attrs, int defStyleAttr) {
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
        mBmpHalfHeight = bitmap.getHeight()/2;
        mBmpHalfWidth = bitmap.getWidth()/2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        mMatrix.reset();
//        mMatrix.setTranslate(point1.x+mBmpHalfWidth,point1.y+mBmpHalfHeight);
        mMatrix.setRotate(180,point1.x+mBmpHalfWidth,point1.y+mBmpHalfHeight);
        canvas.concat(mMatrix);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();


        canvas.save();
        mMatrix.reset();
//        mMatrix.setTranslate(point2.x+mBmpHalfWidth,point2.y+mBmpHalfHeight);
        mMatrix.setRotate(45,point2.x+mBmpHalfWidth,point2.y+mBmpHalfHeight);
        canvas.concat(mMatrix);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
    }
}
