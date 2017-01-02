package com.itydl.app01;

public class Step1Activity extends BaseSetActivity {

    @Override
    public void initView() {
        setContentView(R.layout.activity_step1);
    }

    @Override
    protected void nextActivity() {
        startActivity(Step2Activiity.class);
    }

    @Override
    protected void preActivity() {
    }
}
