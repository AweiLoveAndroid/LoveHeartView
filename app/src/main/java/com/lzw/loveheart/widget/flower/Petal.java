package com.lzw.loveheart.widget.flower;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;


/**
 * 花瓣类
 */
public class Petal {

    private float stretchA;//第一个控制点延长线倍数
    private float stretchB;//第二个控制点延长线倍数
    private float startAngle;//起始旋转角，用于确定第一个端点
    private float angle;//两条线之间夹角，由起始旋转角和夹角可以确定第二个端点
    private int radius = 2;//花芯的半径
    private float growFactor;//增长因子，花瓣是有开放的动画效果，这个参数决定花瓣展开速度
    private int color;//花瓣颜色
    private boolean isFinished = false;//花瓣是否绽放完成
    private Path path = new Path();//用于保存三次贝塞尔曲线
    private Paint paint = new Paint();//画笔


    //构造函数，由花朵类调用
    public Petal(float stretchA, float stretchB, float startAngle, float angle, int color, float growFactor) {
        this.stretchA = stretchA;
        this.stretchB = stretchB;
        this.startAngle = startAngle;
        this.angle = angle;
        this.color = color;
        this.growFactor = growFactor;
        paint.setColor(color);
    }


    //用于渲染花瓣，通过不断更改半径使得花瓣越来越大
    public void render(PointUtil p, int radius, Canvas canvas) {
        if (this.radius <= radius) {
            this.radius += growFactor; // / 10;
        } else {
            isFinished = true;
        }
        this.draw(p, canvas);
    }


    //绘制花瓣，参数p是花芯的圆心的坐标
    private void draw(PointUtil p, Canvas canvas) {
        if (!isFinished) {

            path = new Path();
            //将向量（0，radius）旋转起始角度，第一个控制点根据这个旋转后的向量计算
            PointUtil t = new PointUtil(0, this.radius).rotate(MyUtil.degrad(this.startAngle));
            //第一个端点，为了保证圆心不会随着radius增大而变大这里固定为3
            PointUtil v1 = new PointUtil(0, 3).rotate(MyUtil.degrad(this.startAngle));
            //第二个端点
            PointUtil v2 = t.clone().rotate(MyUtil.degrad(this.angle));
            //延长线，分别确定两个控制点
            PointUtil v3 = t.clone().mult(this.stretchA);
            PointUtil v4 = v2.clone().mult(this.stretchB);
            //由于圆心在p点，因此，每个点要加圆心坐标点
            v1.add(p);
            v2.add(p);
            v3.add(p);
            v4.add(p);
            path.moveTo(v1.x, v1.y);
            //参数分别是：第一个控制点，第二个控制点，终点
            path.cubicTo(v3.x, v3.y, v4.x, v4.y, v2.x, v2.y);
        }
        canvas.drawPath(path, paint);
    }

}
