package com.lzw.loveheart.activity;

import android.app.Activity;
import android.os.Bundle;

import com.lzw.loveheart.widget.LoveSurfaceView;

/**
 * 加载LoveSurfaceView
 */
public class LoveViewActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LoveSurfaceView surfaceView = new LoveSurfaceView(this);
        setContentView(surfaceView);

    }

}
