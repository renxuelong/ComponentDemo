package com.loong.componentdemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * 跳登录界面
     *
     * @param view
     */
    public void login(View view) {
        ARouter.getInstance().build("/account/login").navigation();
    }

    /**
     * 跳分享界面
     *
     * @param view
     */
    public void share(View view) {
        ARouter.getInstance().build("/share/share").withString("share_content", "分享数据到微博").navigation();
    }

    /**
     * 跳 FragmentActivity
     *
     * @param view
     */
    public void fragment(View view) {
        startActivity(new Intent(this, FragmentActivity.class));
    }
}
