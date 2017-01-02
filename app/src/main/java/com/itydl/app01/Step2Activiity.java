package com.itydl.app01;

public class Step2Activiity extends BaseSetActivity {

    @Override
    public void initView() {
        setContentView(R.layout.activity_step2_activiity);
    }

    @Override
    protected void nextActivity() {
        startActivity(Step3Activity.class);
    }

    @Override
    protected void preActivity() {
        startActivity(Step1Activity.class);
    }
}
