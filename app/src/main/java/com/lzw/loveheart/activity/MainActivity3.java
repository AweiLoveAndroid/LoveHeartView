package com.lzw.loveheart.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lzw.loveheart.R;
import com.lzw.loveheart.widget.HeartView;

/**
 * Created by Administrator on 2017/4/29.
 * 加载HeartView
 */
public class MainActivity3 extends Activity {

    HeartView mHeartView;
    Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        mHeartView = (HeartView)findViewById(R.id.heartView);
        Button mButton = (Button)findViewById(R.id.btn_show2);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mHeartView.start();
            }
        });

    }


}
