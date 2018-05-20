package com.demo.swing;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;

public class LoveHeart1 {

    long start = System.currentTimeMillis();
    private Frame f = new Frame("������");
    //������С
    private final int SIZE=600;
    //��дpaint()
    private MyCanvas area = new MyCanvas();

    private BufferedImage image = new BufferedImage(SIZE,SIZE,BufferedImage.TYPE_INT_RGB);
    private Graphics g = image.getGraphics();

    //ѭ������
    private final double STEP = 0.00001;

    public static void main(String[] args){
        new LoveHeart1().init();
    }

    private void init(){
        area.setPreferredSize(new Dimension(SIZE,SIZE));
        // ����ɫ����
        g.setColor(Color.white);
        g.fillRect(0, 0, SIZE, SIZE);
        // ������������
        g.setColor(Color.black);
        g.drawLine(0,SIZE/2,SIZE,SIZE/2);
        g.drawLine(SIZE/2,0,SIZE/2,SIZE);

        //��������
        //������
        int x1, y1,x2, y2;
        for (double t = -Math.PI; t < Math.PI; t = t + STEP){
            g.setColor(Color.black);
            x1 = axisSystem(axisX(t));
            y1 = axisSystem(axisY(t));
            x2 = axisSystem(axisX(t+STEP));
            y2 = axisSystem(axisY(t+STEP));
            //ԭ�����Ǻ���ģ�Ϊ�����۵�����������������������������������޸�
            //g.drawLine(x1, y1, x2, y2);
            g.drawLine(y1, SIZE-x1, y2, SIZE-x2);

        }


        //�رմ���
        f.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });

        long end = System.currentTimeMillis();
        g.setColor(Color.red);
        g.setFont(new Font("Times", Font.BOLD,15));

        g.drawString("����ֵ��" + BigDecimal.valueOf(STEP) , 20, 30);
        g.drawString("��ͼ����ʱ�䣺" + (end - start) + "����", 20, 50);

        area.repaint();
        f.add(area);
        f.pack();
        f.setVisible(true);
    }

    //����t�����Ӧ��������������Xֵ�����������������޸�
    private double axisX(double t){
        return 2*Math.cos(t) - Math.cos(2*t);
    }

    //����t�����Ӧ��������������Yֵ�����������������޸�
    private double axisY(double t){
        return 2*Math.sin(t) - Math.sin(2*t);
    }

    //�������껻���ϵͳ���꣬���������������޸�
    private int axisSystem(double d){
        return (int)((0.5+d/8)*SIZE);
    }

    private class MyCanvas extends Canvas{
        public void paint(Graphics g){
            g.drawImage(image, 0, 0, null);
        }
    }
    
}