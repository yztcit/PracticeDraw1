package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {
    private Paint mPaint;
    private RectF rectF;

    public Practice8DrawArcView(Context context) {
        super(context);
        initPaint();
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initPaint(){
        mPaint = new Paint();
        rectF = new RectF(400, 200, 800, 450);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawArc(400, 200, 800, 450, -110, 100, true, mPaint);
            canvas.drawArc(400, 210, 800, 460, 20, 140, false, mPaint);
            mPaint.setStyle(Paint.Style.STROKE);
            canvas.drawArc(400, 200, 800, 450, -180, 60, false, mPaint);
        } else {
            mPaint.setStyle(Paint.Style.FILL);
            canvas.drawArc(rectF, -110, 100, true, mPaint);
            canvas.drawArc(rectF, 20, 140, false, mPaint);
            mPaint.setStyle(Paint.Style.STROKE);
            canvas.drawArc(rectF, -180, 60, false, mPaint);
        }
    }
}
