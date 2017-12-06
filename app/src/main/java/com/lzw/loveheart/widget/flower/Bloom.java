package com.lzw.loveheart.widget.flower;

import android.graphics.Canvas;

import java.util.ArrayList;

/**
 * Created by lzw on 2017/4/29.
 * 花朵
 */
public class Bloom {

    private int color;//整个花朵的颜色
    private PointUtil point;//花芯圆心
    private int radius; //花芯半径
    private ArrayList petals;//用于保存花瓣

    public PointUtil getPoint() {
        return point;
    }

    public Bloom(PointUtil point, int radius, int color, int petalCount) {
        this.point = point;
        this.radius = radius;
        this.color = color;
        petals = new ArrayList<>(petalCount);


        float angle = 360f / petalCount;
        int startAngle = MyUtil.randomInt(0, 90);
        for (int i = 0; i < petalCount; i++) {
            //随机产生第一个控制点的拉伸倍数
            float stretchA = MyUtil.random(Garden.Options.minPetalStretch, Garden.Options.maxPetalStretch);
            //随机产生第二个控制地的拉伸倍数
            float stretchB = MyUtil.random(Garden.Options.minPetalStretch, Garden.Options.maxPetalStretch);
            //计算每个花瓣的起始角度
            int beginAngle = startAngle + (int) (i * angle);
            //随机产生每个花瓣的增长因子（即绽放速度）
            float growFactor = MyUtil.random(Garden.Options.minGrowFactor, Garden.Options.maxGrowFactor);
            //创建一个花瓣，并添加到花瓣列表中
            petals.add(new Petal(stretchA, stretchB, beginAngle, angle, color, growFactor));
        }
    }


    //绘制花朵
    public void draw(Canvas canvas) {
        Petal p;
        for (int i = 0; i < petals.size(); i++) {
            p = (Petal) petals.get(i);
            //渲染每朵花朵
            p.render(point, this.radius, canvas);
        }
    }


    public int getColor() {
        return color;
    }

}
