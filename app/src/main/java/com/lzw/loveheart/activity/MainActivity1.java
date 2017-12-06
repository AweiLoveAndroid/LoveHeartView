package com.lzw.loveheart.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lzw.loveheart.R;
import com.lzw.loveheart.widget.flower.LoveFlowerView;

/**
 * Created by lzw on 2017/4/29.
 * 加载LoveFlowerView
 */
public class MainActivity1 extends Activity {

    private LoveFlowerView mFlowerView;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFlowerView = (LoveFlowerView)findViewById(R.id.lfv);
        mButton = (Button)findViewById(R.id.btn_show);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFlowerView.reDraw();
            }
        });

    }

}
