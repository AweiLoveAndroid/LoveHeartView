package com.demo.swing;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;

public class LoveHeart1 {

    long start = System.currentTimeMillis();
    private Frame f = new Frame("心形线");
    //画布大小
    private final int SIZE=600;
    //重写paint()
    private MyCanvas area = new MyCanvas();

    private BufferedImage image = new BufferedImage(SIZE,SIZE,BufferedImage.TYPE_INT_RGB);
    private Graphics g = image.getGraphics();

    //循环步长
    private final double STEP = 0.00001;

    public static void main(String[] args){
        new LoveHeart1().init();
    }

    private void init(){
        area.setPreferredSize(new Dimension(SIZE,SIZE));
        // 画白色背景
        g.setColor(Color.white);
        g.fillRect(0, 0, SIZE, SIZE);
        // 画两条坐标轴
        g.setColor(Color.black);
        g.drawLine(0,SIZE/2,SIZE,SIZE/2);
        g.drawLine(SIZE/2,0,SIZE/2,SIZE);

        //计算坐标
        //新坐标
        int x1, y1,x2, y2;
        for (double t = -Math.PI; t < Math.PI; t = t + STEP){
            g.setColor(Color.black);
            x1 = axisSystem(axisX(t));
            y1 = axisSystem(axisY(t));
            x2 = axisSystem(axisX(t+STEP));
            y2 = axisSystem(axisY(t+STEP));
            //原曲线是横向的，为求美观调整了输出把它画成纵向，若画其他函数须修改
            //g.drawLine(x1, y1, x2, y2);
            g.drawLine(y1, SIZE-x1, y2, SIZE-x2);

        }


        //关闭窗口
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        long end = System.currentTimeMillis();
        g.setColor(Color.red);
        g.setFont(new Font("Times", Font.BOLD,15));

        g.drawString("步长值：" + BigDecimal.valueOf(STEP) , 20, 30);
        g.drawString("画图所用时间：" + (end - start) + "毫秒", 20, 50);

        area.repaint();
        f.add(area);
        f.pack();
        f.setVisible(true);
    }

    //根据t算出对应的心形线新坐标X值，若画其他函数须修改
    private double axisX(double t){
        return 2*Math.cos(t) - Math.cos(2*t);
    }

    //根据t算出对应的心形线新坐标Y值，若画其他函数须修改
    private double axisY(double t){
        return 2*Math.sin(t) - Math.sin(2*t);
    }

    //把新坐标换算成系统坐标，若画其他函数须修改
    private int axisSystem(double d){
        return (int)((0.5+d/8)*SIZE);
    }

    private class MyCanvas extends Canvas{
        public void paint(Graphics g){
            g.drawImage(image, 0, 0, null);
        }
    }
    
}