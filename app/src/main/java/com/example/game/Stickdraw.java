package com.example.game;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;

public class Stickdraw {

	private static Stickdraw stickdraw;
	public static int BigCenterX = GameView.screen_width/5;// 大圈坐标参数
	public static int BigCenterY =  GameView.screen_height*3/4;
	public static int BigCenterR = 120;
	public static int smallCenterX = BigCenterX;// 摇杆参数
	public static int smallCenterY = BigCenterY;
	public static int smallCenterR = 70;

	public static int moveX = BigCenterX;// 摇杆朝向坐标
	public static int moveY = BigCenterY;

	public static int doCenterR = 250;// 可操作范围
	public static int checkdirectionR = 40;// 可确认方向范围
	public static int direction = 5;//方向
	
	public static int stickspeed = 70;//摇杆移动速度

	private Paint mStickpaint;
	public Stickdraw() {
		mStickpaint=new Paint();
		mStickpaint.setAntiAlias(true);
		mStickpaint.setColor(Color.parseColor("#ffffff"));
	}

	public static Stickdraw getStickInstance() {
		if (stickdraw == null) {
			stickdraw = new Stickdraw();
		}
		return stickdraw;
	}

	public void drawBigCenter() {

	}

	private Double dX,dY;
	
	// 检测摇杆方向
	public Boolean check(int x, int y) {
		if (x <= BigCenterX + doCenterR && y >= BigCenterY - doCenterR) {
			Double lengh = Math.sqrt((x - BigCenterX) * (x - BigCenterX) + (y - BigCenterY) * (y - BigCenterY));
			if (lengh <= doCenterR) {
				
				if (lengh>=checkdirectionR) {
					dX=(double) x-BigCenterX;dY=(double) y-BigCenterY;
					int jiaodu= (int) (Math.atan(dX/dY)/Math.PI*180);
					if (jiaodu<=23&&jiaodu>=-23&&y>BigCenterY) {
						direction=2;
					}
					else if (jiaodu<=23&&jiaodu>=-23&&y<BigCenterY) {
						direction=8;
					}
					else if (Math.abs(jiaodu)>=67&&x>BigCenterX) {
						direction=6;
					}
					else if (Math.abs(jiaodu)>=67&&x<BigCenterX) {
						direction=4;
					}
					else if (jiaodu>23&&y>BigCenterY) {
						direction=3;
					}
					else if (jiaodu>23&&y<BigCenterY) {
						direction=7;
					}
					else if (jiaodu<-23&&y<BigCenterY) {
						direction=9;
					}
					else if (jiaodu<-23&&y>BigCenterY) {
						direction=1;
					}
					
					
				}
				else {
					direction=5;
				}

				if (lengh >= BigCenterR) {
					moveX = (int) ((x-BigCenterX) * BigCenterR /lengh +BigCenterX);
				    moveY = (int) ((y-BigCenterY) * BigCenterR /lengh+BigCenterY);
				}
				else {
					moveX=x;
					moveY=y;
				}
				
				return true;
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}
	}

	// 初始摇杆坐标
	public void init() {
		moveX = BigCenterX;
		moveY = BigCenterY;
		direction = 5;
	}
	
	private int movelengh;
	
	public void drawstick(Canvas canvas) {
		movelengh=(int) Math.sqrt((smallCenterX - moveX) * (smallCenterX - moveX) + (smallCenterY - moveY) * (smallCenterY - moveY));
		if (movelengh<=stickspeed) {
			smallCenterX=moveX;
			smallCenterY=moveY;
		}
		else  {
			smallCenterX= xyMove(smallCenterX, moveX,movelengh);
			smallCenterY=xyMove(smallCenterY, moveY,movelengh);
		}
		mStickpaint.setAntiAlias(true);
		canvas.drawCircle(smallCenterX, smallCenterY, smallCenterR, mStickpaint);
	}
	
	public int xyMove(int small, int move, int lengh) {
		
		return ((lengh-stickspeed)*small+move*stickspeed)/lengh;
		
	}

}
