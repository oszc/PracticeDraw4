package com.hencoder.hencoderpracticedraw4.practice;

import android.content.Context;
import android.graphics.*;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import com.hencoder.hencoderpracticedraw4.R;

public class Practice02ClipPathView extends PracticeView{
    Paint paint = new Paint();
    Bitmap bitmap;
    Point point1 = new Point(200, 200);
    Point point2 = new Point(600, 200);

    public Practice02ClipPathView(Context context) {
        super(context);
    }

    public Practice02ClipPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02ClipPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void init(Context context, AttributeSet attrs, int defStyleAttr) {

        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.maps);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        canvas.save();
        mDefaultPath.addCircle(point1.x+bitmap.getWidth()/2,point1.y+bitmap.getHeight()/2,bitmap.getWidth()/3, Path.Direction.CW);
        canvas.clipPath(mDefaultPath);
        canvas.drawBitmap(bitmap, point1.x, point1.y, paint);
        canvas.restore();

        mDefaultPath.reset();
        canvas.save();
        mDefaultPath.addCircle(point2.x+bitmap.getWidth()/2,point2.y+bitmap.getHeight()/2,bitmap.getWidth()/3, Path.Direction.CCW);
        canvas.clipPath(mDefaultPath, Region.Op.DIFFERENCE);
        canvas.drawBitmap(bitmap, point2.x, point2.y, paint);
        canvas.restore();

//        canvas.drawPath(mDefaultPath,mDefaultPaint);
    }
}
