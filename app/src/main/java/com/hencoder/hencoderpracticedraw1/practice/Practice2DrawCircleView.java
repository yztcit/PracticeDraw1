package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice2DrawCircleView extends View {
    private Paint paint;

    // 自定义View有四个构造函数
    // 如果View是在Java代码里面new的，则调用第一个构造函数
    public Practice2DrawCircleView(Context context) {
        super(context);
        initPaint();
    }

    // 如果View是在.xml里声明的，则调用第二个构造函数
    // 自定义属性是从AttributeSet参数传进来的
    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    // 不会自动调用
    // 一般是在第二个构造函数里主动调用
    // 如View有style属性时
    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initPaint() {
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        //1.实心圆
        paint.setColor(Color.BLACK);//black color default
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(320, 180, 160, paint);

        //2.空心圆
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(0);
        canvas.drawCircle(830, 180, 160, paint);

        //3.蓝色实心圆
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(320, 540, 160, paint);

        //4.线宽为20的空心圆
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);//Paint.Style.FILL_AND_STROKE 默认fill
        paint.setStrokeWidth(20);
        canvas.drawCircle(830, 540, 160, paint);
    }
}
