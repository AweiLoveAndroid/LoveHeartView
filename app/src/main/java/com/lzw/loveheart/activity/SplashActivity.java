package com.lzw.loveheart.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lzw.loveheart.R;

/**
 * Created by Administrator on 2017/4/29.
 */
public class SplashActivity extends Activity implements View.OnClickListener{

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initialize();
    }

    private void initialize() {

        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn1:
                startOtherActivity(LoveViewActivity.class);
                break;
            case R.id.btn2:
                startOtherActivity(MainActivity1.class);
                break;
            case R.id.btn3:
                startOtherActivity(MainActivity2.class);
                break;
            case R.id.btn4:
                startOtherActivity(MainActivity3.class);
                break;
            default:
                break;
        }
    }

    public void startOtherActivity(Class<?> cls) {
        startActivity(new Intent(SplashActivity.this,cls));
    }
}
