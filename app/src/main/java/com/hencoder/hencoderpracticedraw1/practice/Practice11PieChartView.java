package com.hencoder.hencoderpracticedraw1.practice;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice11PieChartView extends View {
    private Paint paint = new Paint();

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        paint.setStyle(Paint.Style.FILL);

        setDesc(canvas, "Lollipop", 40, true, false);
        paint.setColor(Color.RED);
        canvas.drawArc(200, 30, 700, 530, -185, 125, true, paint);

        setDesc(canvas, "Marshmallow", 120, false, true);
        paint.setColor(Color.YELLOW);
        canvas.drawArc(220, 50, 720, 550, -60, 55, true, paint);

        setDesc(canvas, "Froyo", 280, false, true);
        setDesc(canvas, "Gingerbread", 300, false, true);
        paint.setColor(Color.GRAY);
        canvas.drawArc(220, 50, 720, 550, -3, 5, true, paint);

        setDesc(canvas, "Ice Cream Sandwich", 330, false, true);
        paint.setColor(Color.DKGRAY);
        canvas.drawArc(220, 50, 720, 550, 4, 4, true, paint);

        setDesc(canvas, "Jelly Bean", 550, false, true);
        paint.setColor(Color.GREEN);
        canvas.drawArc(220, 50, 720, 550, 10, 60, true, paint);

        setDesc(canvas, "KitKat", 600, false, false);
        paint.setColor(Color.BLUE);
        canvas.drawArc(220, 50, 720, 550, 72, 103, true, paint);
    }

    private void setDesc(Canvas canvas, String desc, float y, boolean special,boolean isRight) {
        float rX = 450;
        float rY = 280;
        float textSize = 28;
        float radius = 250;
        paint.setColor(Color.WHITE);
        paint.setTextSize(textSize);
        float measureText = paint.measureText(desc);
        float x = rX - radius - 40;//L2R 直线的起点x
        float gX = x + radius / 2;//L2R 拐点
        float tX = x - measureText - 15;//L2R text的起点
        if (!special) {
            rX = 470;
            rY = 300;
            if (isRight) {
                x = rX + radius + 40;//R2L直线的起点x
                gX = rX + radius + 20;
                tX = x + 15;//R2L text的起点
            }
        }
        canvas.drawText(desc, tX, y, paint);
        float[] pots = {x, y, gX, y, gX, y, rX, rY};
        canvas.drawLines(pots, paint);
    }
}
