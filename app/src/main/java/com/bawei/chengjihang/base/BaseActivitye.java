package com.bawei.chengjihang.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivitye extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //获取布局文件
        setContentView(getLayoutID());
        //初始化控件
        initView();
        //获取数据
        initData();
    }
    //获取布局文件
    protected abstract int getLayoutID();
    //初始化控件
    protected abstract void initView();
    //获取数据
    protected abstract void initData();
}
