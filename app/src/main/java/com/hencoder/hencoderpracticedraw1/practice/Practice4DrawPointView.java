package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice4DrawPointView extends View {
    private Paint mPaint;

    public Practice4DrawPointView(Context context) {
        super(context);
        initPaint();
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public Practice4DrawPointView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initPaint(){
        mPaint = new Paint();
        mPaint.setStrokeWidth(100);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPoint() 方法画点
//        一个圆点，一个方点
//        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点

        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawPoint(400, 500, mPaint);

//        mPaint.setStrokeCap(Paint.Cap.SQUARE);
        mPaint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawPoint(700, 500, mPaint);
    }
}
