package com.lzw.loveheart.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 带有绘制路线动画的爱心
 */
public class HeartView extends View {

    private Paint paint;
    private ValueAnimator valueAnimator;
    private float mLength;
    private PathMeasure pathMeasure;
    private Path mPath;

    public HeartView(Context context) {
        this(context, null);
    }

    public HeartView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HeartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

        paint =new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);

        //-------------这里是绘制心形，大家可以自己画任何曲线---------------------------
        mPath = new Path();
        mPath.moveTo(396-50,313);
        mPath.cubicTo(207-50,114, 339-50,46, 396-50,111);
        mPath.cubicTo(453-50, 46,585-50, 114,396-50,313);

        //----------------------------------------------
        pathMeasure =new PathMeasure(mPath,false);//false表示是否强制闭合路径

        valueAnimator = ValueAnimator.ofFloat(0,pathMeasure.getLength());
        valueAnimator.setDuration(5000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mLength= (float) animation.getAnimatedValue();
                invalidate();
            }
        });

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        Path path = new Path();
        //path.reset();
        //这里需要lineTo才会绘画图像，据说是openGl的一个BUG
        path.lineTo(0,0);
        //这个方法的意思是取路径片段，0是指从头截取，mLength是指截取的长度
        pathMeasure.getSegment(0,mLength,path,true);
        canvas.drawPath(path,paint);
        // canvas.drawPath(mPath,paint);
        canvas.restore();
    }

    public void start() {
        valueAnimator.start();
    }
}
