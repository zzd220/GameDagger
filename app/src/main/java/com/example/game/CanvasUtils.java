package com.example.game;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/**
 * 类说明
 * @author zheng.zong.di
 * @date 2015年4月23日
 * @version 1.0
 *
 */
public class CanvasUtils {
	public static void drawLine(Canvas mcanvas,float startX, float startY, float stopX, float stopY, Paint paint) {
		mcanvas.drawLine(startX*GameView.screen_width/GameView.standard_width, startY*GameView.screen_height/GameView.standard_height, stopX*GameView.screen_width/GameView.standard_width, stopY*GameView.screen_height/GameView.standard_height, paint);
	}
	public static void drawCircle(Canvas mcanvas,float cx, float cy, float radius, Paint paint) {
		mcanvas.drawCircle(cx * GameView.screen_width / GameView.standard_width, cy * GameView.screen_height / GameView.standard_height, radius * GameView.screen_width / GameView.standard_width, paint);
		}

	public static void drawBitmap (Canvas mcanvas,Bitmap bitmap, Rect src, Rect dst, Paint paint) {
		mcanvas.drawBitmap(bitmap, src, new Rect(dst.left * GameView.screen_width / GameView.standard_width, dst.top * GameView.screen_height / GameView.standard_height, dst.right * GameView.screen_width / GameView.standard_width, dst.bottom * GameView.screen_height / GameView.standard_height), paint);
	}
	public static float [] toScreen(float cx, float cy) {
		return new float[]{cx * GameView.screen_width / GameView.standard_width,cy * GameView.screen_height / GameView.standard_height};
	}
}
