package com.example.game;


import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
    GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		Log.e("ddddddd", "onCreate");
        gameView = new GameView(MainActivity.this);
        setContentView(gameView);
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
}
