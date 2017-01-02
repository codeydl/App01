package com.itydl.app01.com.itydl.app01.view;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.itydl.app01.R;

/**
 * @author ydl
 * @version $Rev$
 * @time 2017/1/1 ${time}
 * @des ${TODO}
 * @updateAuthor $Author$
 * @updateDate $Date$
 * @updateDes ${TODO}
 */

public class MyDialog extends ProgressDialog {

    private Context mContext;
    private TextView mTvLoading;
    private ImageView mIvLoading;
    private AnimationDrawable mAnimation;
    private String mLoadingTip;

    public MyDialog(Context context,String content) {
        super(context);
        this.mContext = context;
        this.mLoadingTip = content;
    }

    //ProgressDialog不是ViewGroup，自定义布局通过setContentView方法加载进来自定义布局。要重写onCreate
    //对话框创建的时候调用
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
    }

    private void initData() {
        // 通过ImageView对象拿到背景显示的AnimationDrawable
        mAnimation = (AnimationDrawable) mIvLoading.getBackground();

        //主界面点击登录，立即调用这里的动画显示功能
        mAnimation.start();

        //设置正在加载中信息
        mTvLoading.setText(mLoadingTip);
    }

    private void initView() {
        //加载自定义布局，此时MyDialog已经有了该布局的样子
        setContentView(R.layout.progress_dialog);// 显示界面
        mTvLoading = (TextView) findViewById(R.id.tv_loading);
        mIvLoading = (ImageView) findViewById(R.id.iv_loading);
    }

    @Override
    public void dismiss() {
        super.dismiss();
        //对话框关闭，同时关闭掉动画。节约资源
        mAnimation.stop();
        mAnimation = null;
    }
}
