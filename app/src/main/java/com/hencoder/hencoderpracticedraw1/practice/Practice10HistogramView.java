package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {
    private Paint paint = new Paint();
    private float start = 100;//origin left
    private float bottom = 600;//origin bottom
    private float width = 100;//rect width
    private float spacing = 20;//spacing between rect
    private float textPix = 28;//textSize
    private float[] pots = {start, 50, start, bottom, start, bottom, 1000, bottom};

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图
        paint.setStrokeWidth(3);
        paint.setColor(Color.WHITE);
        canvas.drawLines(pots, paint);

        rectItem(canvas, "Froyo", 10, 1);
        rectItem(canvas, "GB", 30, 2);
        rectItem(canvas, "ICS", 30, 3);
        rectItem(canvas, "JB", 190, 4);
        rectItem(canvas, "KitKat", 230, 5);
        rectItem(canvas, "L", 250, 6);
        rectItem(canvas, "M", 180, 7);

        paint.setTextSize(46);
        canvas.drawText("直方图", 500, bottom + 120, paint);
    }

    private void rectItem(Canvas canvas, String tips, float high, int num) {
        //间距spacing，宽width;
        float left = start + (num - 1) * width + num * spacing;
        float right = left + width;
        float top = bottom - high;
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(left, top, right, bottom, paint);
        //文字居中;
        paint.setColor(Color.WHITE);
        paint.setTextSize(textPix);
        paint.setTextAlign(Paint.Align.CENTER);
        //float x ,y 对应每个柱子的水平中点位置
        canvas.drawText(tips, left + width / 2, bottom + textPix, paint);
    }
}
