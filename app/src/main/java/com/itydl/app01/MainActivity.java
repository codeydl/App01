package com.itydl.app01;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.itydl.app01.com.itydl.app01.view.MyDialog;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText etactivitymaincontent;
    Button btnactivitymainlogin;
    ImageView animationIV;
    Button buttonA;
    Button buttonB;
    Button buttonC;
    private AnimationDrawable mAnimationDrawable;
    private MyDialog mDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        btnactivitymainlogin.setOnClickListener(this);
        buttonA.setOnClickListener(this);
        buttonB.setOnClickListener(this);
        buttonC.setOnClickListener(this);
        btnactivitymainlogin.setOnClickListener(this);

    }

    private void initView() {
        setContentView(R.layout.activity_main);
        etactivitymaincontent = (EditText) findViewById(R.id.et_activity_main_content);
        btnactivitymainlogin = (Button) findViewById(R.id.btn_activity_main_login);
        animationIV = (ImageView) findViewById(R.id.animationIV);
        buttonA = (Button) findViewById(R.id.buttonA);
        buttonB = (Button) findViewById(R.id.buttonB);
        buttonC = (Button) findViewById(R.id.buttonC);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_activity_main_login:
                if ("".equals(etactivitymaincontent.getText().toString().trim())) {
                    //抖动效果
                    Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.shake);
                    etactivitymaincontent.startAnimation(animation);
                } else {
                    //模拟美团登录
                    showMeituanAnimation();
                }
                break;
            case R.id.buttonA:
                //模拟wifi顺序动画
                order();
                break;
            case R.id.buttonB:
                //停止wifi动画
                stop();
                break;
            case R.id.buttonC:
                //倒叙wifi动画
                disOrder();
                break;

            default:
                break;
        }
    }

    private void showMeituanAnimation() {
        //模拟美团登录
        mDialog = new MyDialog(this, "正在加载中");
        mDialog.show();
        Handler handler =new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {

                mDialog.dismiss();
            }
        }, 3000);//3秒钟后调用dismiss方法隐藏；如果有访问网络，可以设置访问网络成功后的监听，再停止对话框
    }

    private void order() {
        animationIV.setImageResource(R.drawable.animation1);
        mAnimationDrawable = (AnimationDrawable) animationIV.getDrawable();
        mAnimationDrawable.start();
    }

    private void stop() {
        mAnimationDrawable.stop();
    }

    private void disOrder() {
        animationIV.setImageResource(R.drawable.animation2);
        mAnimationDrawable = (AnimationDrawable) animationIV.getDrawable();
        mAnimationDrawable.start();
    }
}

