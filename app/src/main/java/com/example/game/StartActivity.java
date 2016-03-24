package com.example.game;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Created by ZZD on 2016/2/24.
 */
public class StartActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StartActivity.this,MainActivity.class));
            }
        });
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.e("ddddddd", "resume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("ddddddd", "onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("ddddddd", "onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("ddddddd", "onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("ddddddd", "onStart");
    }
    /**
     * onConfigurationChanged
     * the package:android.content.res.Configuration.
     * @param newConfig, The new device configuration.
     * 当设备配置信息有改动（比如屏幕方向的改变，实体键盘的推开或合上等）时，
     * 并且如果此时有activity正在运行，系统会调用这个函数。
     * 注意：onConfigurationChanged只会监测应用程序在AnroidMainifest.xml中通过
     * android:configChanges="xxxx"指定的配置类型的改动；
     * 而对于其他配置的更改，则系统会onDestroy()当前Activity，然后重启一个新的Activity实例。
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Log.e("ddddddd", "onConfigurationChanged");
//        super.onConfigurationChanged(newConfig); // 检测屏幕的方向：纵向或横向
        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            //当前为横屏， 在此处添加额外的处理代码
        } else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
//当前为竖屏， 在此处添加额外的处理代码
        }
        //检测实体键盘的状态：推出或者合上
        if (newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_NO){
//实体键盘处于推出状态，在此处添加额外的处理代码
        } else if (newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_YES){
            //实体键盘处于合上状态，在此处添加额外的处理代码
        }
    }

}
