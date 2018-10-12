package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice9DrawPathView extends View {
    private Paint paint = new Paint();
    private Path path = new Path();
    //addArc 直接使用了forceMoveTo = true;
    //arcTo 需要设置forceMoveTo 参数;
    {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            path.addArc(300, 200, 500, 400, -210, 210);
            path.arcTo(500, 200, 700, 400, -180, 210, false);
        } else {
            RectF rectF1 = new RectF(300, 200, 500, 400);
            RectF rectF2 = new RectF(500, 200, 700, 400);
            path.addArc(rectF1, -210, 210);
            path.arcTo(rectF2, -180, 210, false);
        }
        path.lineTo(500, 580);
    }

    public Practice9DrawPathView(Context context) {
        super(context);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形
        canvas.drawPath(path, paint);
    }
}
