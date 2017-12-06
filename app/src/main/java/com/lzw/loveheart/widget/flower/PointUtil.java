package com.lzw.loveheart.widget.flower;

/**
 * 保存点信息，或者说是向量信息。包含向量的基本运算。
 */
public class PointUtil {
    public int x;
    public int y;

    public PointUtil(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //旋转
    public PointUtil rotate(float theta) {
        int x = this.x;
        int y = this.y;
        this.x = (int) (Math.cos(theta) * x - Math.sin(theta) * y);
        this.y = (int) (Math.sin(theta) * x + Math.cos(theta) * y);
        return this;
    }

    //乘以一个常数
    public PointUtil mult(float f) {
        this.x *= f;
        this.y *= f;
        return this;
    }

    //复制
    public PointUtil clone() {
        return new PointUtil(this.x, this.y);
    }

    //该点与圆心距离
    public float length() {
        return (float) Math.sqrt(this.x * this.x + this.y * this.y);
    }

    //向量相减
    public PointUtil subtract(PointUtil p) {
        this.x -= p.x;
        this.y -= p.y;
        return this;
    }

    //向量相加
    public PointUtil add(PointUtil p) {
        this.x += p.x;
        this.y += p.y;
        return this;
    }

    public PointUtil set(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }
}
