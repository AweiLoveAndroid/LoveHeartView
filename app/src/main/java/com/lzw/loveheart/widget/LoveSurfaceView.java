package com.lzw.loveheart.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.lzw.loveheart.R;

/**
 * Created by lzw on 2017.4.22
 */
public class LoveSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    boolean mbloop = false;

    SurfaceHolder mSurfaceHolder = null;

    private Canvas canvas;

    int miCount = 0;

    int y = 50;


    /**
     * * @param context
     */
    public LoveSurfaceView(Context context) {
        super(context);
        mSurfaceHolder = this.getHolder();
        mSurfaceHolder.addCallback(this);
        this.setFocusable(true);
        this.setKeepScreenOn(true);
        mbloop = true;
    }


    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        // TODO Auto-generated method stub
        new Thread(this).start();
    }


    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }


    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mbloop = false;
    }


    @Override
    public void run() {
        while (mbloop) {
            try {
                Thread.sleep(200);
            } catch (Exception e) {
                e.printStackTrace();
            }
            synchronized (mSurfaceHolder) {
                Draw();//执行绘制的逻辑
            }
        }
    }


    private void Draw() {
        canvas = mSurfaceHolder.lockCanvas();
        try {
            if (mSurfaceHolder == null || canvas == null) {
                return;
            }
            if ( miCount <100){
                miCount++;
            }else{
                miCount = 0;
            }

            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(Color.BLACK);
            canvas.drawRect(0,0 ,320 ,480 , paint);

            switch (miCount % 30) {

                case 0:
                    paint.setColor(getResources().getColor(R.color.c1));
                    break;
                case 1:
                    paint.setColor(getResources().getColor(R.color.c2));
                    break;
                case 2:
                    paint.setColor(getResources().getColor(R.color.c3));
                    break;
                case 3:
                    paint.setColor(getResources().getColor(R.color.c4));
                    break;
                case 4:
                    paint.setColor(getResources().getColor(R.color.c5));
                    break;
                case 5:
                    paint.setColor(getResources().getColor(R.color.c6));
                    break;
                case 6:
                    paint.setColor(getResources().getColor(R.color.c7));
                    break;
                case 7:
                    paint.setColor(getResources().getColor(R.color.c8));
                    break;
                case 8:
                    paint.setColor(getResources().getColor(R.color.c9));
                    break;
                case 9:
                    paint.setColor(getResources().getColor(R.color.c10));
                    break;
                case 10:
                    paint.setColor(getResources().getColor(R.color.c11));
                    break;
                case 11:
                    paint.setColor(getResources().getColor(R.color.c12));
                    break;
                case 12:
                    paint.setColor(getResources().getColor(R.color.c13));
                    break;
                case 13:
                    paint.setColor(getResources().getColor(R.color.c14));
                    break;
                case 14:
                    paint.setColor(getResources().getColor(R.color.c15));
                    break;
                case 15:
                    paint.setColor(getResources().getColor(R.color.c16));
                    break;
                case 16:
                    paint.setColor(getResources().getColor(R.color.c17));
                    break;
                case 17:
                    paint.setColor(getResources().getColor(R.color.c18));
                    break;
                case 18:
                    paint.setColor(getResources().getColor(R.color.c19));
                    break;
                case 19:
                    paint.setColor(getResources().getColor(R.color.c20));
                    break;
                case 20:
                    paint.setColor(getResources().getColor(R.color.c21));
                    break;
                case 21:
                    paint.setColor(getResources().getColor(R.color.c22));
                    break;
                case 22:
                    paint.setColor(getResources().getColor(R.color.c23));
                    break;
                case 23:
                    paint.setColor(getResources().getColor(R.color.c24));
                    break;
                case 24:
                    paint.setColor(getResources().getColor(R.color.c25));
                    break;
                case 25:
                    paint.setColor(getResources().getColor(R.color.c26));
                    break;
                case 26:
                    paint.setColor(getResources().getColor(R.color.c27));
                    break;
                case 27:
                    paint.setColor(getResources().getColor(R.color.c28));
                    break;
                case 28:
                    paint.setColor(getResources().getColor(R.color.c29));
                    break;
                case 29:
                    paint.setColor(getResources().getColor(R.color.c30));
                    break;
                default:
                    paint.setColor(Color.WHITE);
                    break;
            }

            int i, j;
            double x, y, r;

            for (i = 0; i <= 90;i++){
                for (j = 0; j <= 90;j++){
                    r = Math.PI /45 *i * (1 - Math.sin(Math.PI /45 * j)) * 20;
                    x = r * Math.cos(Math.PI /45 * j)*Math.sin(Math.PI /45 * i)+ 320/2;
                    y = -r * Math.sin(Math.PI /45 * j)+ 400/4;
                    canvas.drawPoint((float) x, (float) y, paint);
                }
            }
            paint.setTextSize(32);
            paint.setTypeface(Typeface.create(Typeface.SERIF, Typeface.ITALIC));

            RectF rect = new RectF(60, 400, 260, 405);

            canvas.drawRoundRect(rect, (float)1.0,(float)1.0,paint);
            canvas.drawText("Loving You",75,400, paint);

            mSurfaceHolder.unlockCanvasAndPost(canvas);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}