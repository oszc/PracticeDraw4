package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.*;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.hencoder.hencoderpracticedraw4.R;

public class Practice10MatrixSkewView extends PracticeView{
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);

    public Practice10MatrixSkewView(Context context) {
        super(context);
    }

    public Practice10MatrixSkewView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10MatrixSkewView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
        mMatrix.setSkew(0,0.5f,point1.x+mBmpHalfWidth,point1.y+mBmpHalfHeight);
        canvas.concat(mMatrix);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        canvas.save();
        mMatrix.reset();
        mMatrix.setSkew(-0.5f,0.0f,point2.x+mBmpHalfWidth,point2.y+mBmpHalfHeight);
        canvas.concat(mMatrix);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();
    }
}
