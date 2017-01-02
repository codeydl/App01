package com.itydl.app01;

import android.view.View;

public class Step3Activity extends BaseSetActivity {
    @Override
    public void initView() {
        setContentView(R.layout.activity_step3);
    }

    @Override
    protected void nextActivity() {

    }

    @Override
    protected void preActivity() {
        startActivity(Step2Activiity.class);
    }

    public void complete(View v){
        startActivity(MainActivity.class);
        overridePendingTransition(R.anim.bottom_in,R.anim.top_out);
    }
}
