package com.bawei.chengjihang.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bawei.chengjihang.R;
import com.bawei.chengjihang.base.BaseActivitye;

public class MainActivity extends BaseActivitye {


    private EditText et;
    private Button bt_ok;

    @Override
    protected int getLayoutID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        et = findViewById(R.id.et);
        bt_ok = findViewById(R.id.bt_ok);
    }

    @Override
    protected void initData() {
        final String json="http://mobile.bwstudent.com/small/commodity/v1/findCommodityByKeyword";
        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("xxx",json+"");

            }
        });
    }
}
