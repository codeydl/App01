package com.itydl.app01;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * @author ydl
 * @version $Rev$
 * @time 2017/1/1 ${time}
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */

public abstract class BaseSetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    public abstract void initView();

    public void next(View v){
        //启动下一个活动
        nextActivity();
        //使用动画
        nextAnimation();
    }

    protected abstract void nextActivity();

    public void pre(View v){
        preActivity();
        preAnimation();
    }

    protected abstract void preActivity();

    public  void startActivity(Class activity){
        Intent intent = new Intent(this,activity);
        startActivity(intent);
        finish();
    }

    public void nextAnimation(){
        //加入动画方式启动下一个活动
        overridePendingTransition(R.anim.next_in,R.anim.next_out);
    }

    public void preAnimation(){
        //加入动画方式启动上一个活动
        overridePendingTransition(R.anim.pre_in,R.anim.pre_out);
    }
}
