package com.demo.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class LoveHeart2 extends JFrame {

    //���崰�ڴ�С
    private static final int WIDTH = 480;
    private static final int HEIGHT = 600;

    //��ȡ��Ļ��С
    private static int WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width;
    private static int WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height;

    public static void main(String[] args) {
        new LoveHeart2();
    }

    public LoveHeart2() {
        //���ô��ڱ���
        super("����");
        //���ñ���ɫ
        this.setBackground(Color.BLACK);
        //���ô���λ��
        this.setLocation((WINDOW_WIDTH - WIDTH) / 2, (WINDOW_HEIGHT - HEIGHT) / 2);
        //���ô��ڴ�С
        this.setSize(WIDTH, HEIGHT);
        //���ô��ڲ���
        this.setLayout(getLayout());
        //���ô��ڿɼ�
        this.setVisible(true);
        //���ô���Ĭ�Ϲرշ�ʽ
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    public void paint(Graphics g) {
        double x, y, r;          //�������꼰�뾶
        Image image = this.createImage(WIDTH, HEIGHT);
        Graphics pic = image.getGraphics();
        //����ͼ��
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                r = Math.PI / 45 + Math.PI / 45 * i * (1 - Math.sin(Math.PI / 45 * j)) * 18;
                x = r * Math.cos(Math.PI / 45 * j) * Math.sin(Math.PI / 45 * i) + WIDTH / 2;
                y = -r * Math.sin(Math.PI / 45 * j) + HEIGHT / 2;
                pic.setColor(Color.MAGENTA);
                pic.fillOval((int) x, (int) y, 2, 2);
            }
            //����ͼƬ
            g.drawImage(image, 0, 0, this);
        }
    }

}