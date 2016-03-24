package com.example.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Attackdraw {

	private static Attackdraw attackdraw;
	public static float BigCenterX = 2350;// 大圈坐标参数
	public static float BigCenterY = 1350;
	public static float BigCenterR = BigCenterX/25;



	private Paint mattackpaint;
	public Attackdraw() {
		mattackpaint=new Paint();
		mattackpaint.setAntiAlias(true);
		mattackpaint.setColor(Color.parseColor("#ffffff"));
		float[] floats=CanvasUtils.toScreen(BigCenterX,BigCenterY);
		BigCenterX=floats[0];
		BigCenterY=floats[1];
		BigCenterR = BigCenterX/25;
	}

	public static Attackdraw getattackInstance() {
		if (attackdraw == null) {
			attackdraw = new Attackdraw();
		}
		return attackdraw;
	}

	 private boolean attacktouch=false;

	public boolean check(int x, int y) {
		if (x <= BigCenterX + BigCenterR && y >= BigCenterY - BigCenterR) {
			Double lengh = Math.sqrt((x - BigCenterX) * (x - BigCenterX) + (y - BigCenterY) * (y - BigCenterY));
			if (lengh <= BigCenterR) {
				mattackpaint.setColor(Color.parseColor("#00e3e3"));
				return true;}
				else {
				mattackpaint.setColor(Color.parseColor("#ffffff"));
				}
			return false;
			}
		else {
			mattackpaint.setColor(Color.parseColor("#ffffff"));
			return false;

		}
	}

	int touchup=5;

	public void drawAttack(Canvas canvas) {
		if (touchup<0){
			mattackpaint.setColor(Color.parseColor("#ffffff"));
			attacktouch=false;
		}
		else touchup--;
		canvas.drawCircle(BigCenterX, BigCenterY, BigCenterR, mattackpaint);
	}

	public boolean isAttacktouch() {
		return attacktouch;
	}

	public void setAttacktouch(boolean attacktouch) {
		if (!attacktouch)
			mattackpaint.setColor(Color.parseColor("#ffffff"));
		else{
			mattackpaint.setColor(Color.parseColor("#00e3e3"));
			touchup=2;
		}
		this.attacktouch = attacktouch;
	}
}
