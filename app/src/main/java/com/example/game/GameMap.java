package com.example.game;

import android.R.integer;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.TypedValue;

import java.util.ArrayList;
import java.util.List;

/**
 * 类说明
 * @author zheng.zong.di
 * @date 2015年4月9日
 * @version 1.0
 *
 */
public class GameMap {
	private List<Player> players=new ArrayList();
	public static int init_w=260,init_h=250;
	public static int bg_w=0,bg_h=0;
	private int [][]mMap={ 
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};
	
	public GameMap(Context context, Player player) {
		this.players.add(player);
		player.setmGameMap(this);
		mMap_n=decodeResource(context.getResources(), R.drawable.map_n);
		mMap_bg=decodeResource(context.getResources(), R.drawable.map_background);
		bg_w=mMap_bg.getWidth()*2;bg_h=GameView.standard_height-init_h*3/2;
	}

	public int mPx;
	public int mPy;
	private Bitmap mMap_n;		
	private Bitmap mMap_bg;		

	public void drawMap(Canvas mcanvas) {
		mPx=players.get(0).getmX();
		mPy=players.get(0).getmY();
		if (mPx<init_w*5) {
			mPx=init_w*5;
		}
		if (mPx> GameMap.init_w * (mMap[0].length + 5) - GameView.standard_width) {
			mPx=GameMap.init_w * (mMap[0].length + 5) - GameView.standard_width;
//			player.setmX(mPx);
		}

		int i=mPx/init_w;
		int dif=mPx%init_w;
		CanvasUtils.drawBitmap(mcanvas,mMap_bg, null, new Rect(-(mPx/2%bg_w), GameView.standard_height-init_h-bg_h+50, -(mPx/2%bg_w)+bg_w, GameView.standard_height-init_h+50), new Paint());
		CanvasUtils.drawBitmap(mcanvas,mMap_bg, null, new Rect(-(mPx/2%bg_w)+bg_w, GameView.standard_height-init_h-bg_h+50, -(mPx/2%bg_w)+bg_w+bg_w, GameView.standard_height-init_h+50), new Paint());
		CanvasUtils.drawBitmap(mcanvas,mMap_bg, null, new Rect(-(mPx/2%bg_w)-bg_w, GameView.standard_height-init_h-bg_h+50, -(mPx/2%bg_w), GameView.standard_height-init_h+50), new Paint());

//		CanvasUtils.drawBitmap(mcanvas,mMap_bg,-(mPx/2%2048),GameView.standard_height-init_h-1024,new Paint());
//		CanvasUtils.drawBitmap(mcanvas,mMap_bg,-(mPx/2%2048)+2048,GameView.standard_height-init_h-1024,new Paint());
//		CanvasUtils.drawBitmap(mcanvas,mMap_bg,-(mPx/2%2048)-2048,GameView.standard_height-init_h-1024,new Paint());
		for (int j = i-5; j < i+8; j++) {
			for (int j2 = 0; j2 < mMap.length; j2++) {
				if (j<mMap[0].length&&j>=0)
				if (mMap[j2][j]==1) {
					CanvasUtils.drawBitmap(mcanvas,mMap_n, null,new Rect((j-i+5)*init_w-dif, GameView.standard_height-init_h*(mMap.length-j2), (j-i+6)*init_w-dif, GameView.standard_height-init_h*(mMap.length-j2-1)),new Paint());
				}
			}

		}



	}

//	public Player getPlayer() {
//		return player;
//	}
//
	public void addPlayer(List<Player> player) {
		for (Player p:player){
			this.players.add(p);
			p.setmGameMap(this);
		}
	}



	public void checkPlayer(Player player) {
		player.setmOnground(false);
		int gridnum= player.getmX()/init_w;
		for (int j = gridnum; j < gridnum+3; j++) {
			for (int j2 = 0; j2 < mMap.length; j2++) {
				if (j<mMap[0].length&&j>=0)
				GridZone.check(mMap[j2][j],j,j2,player);
			}

		}
	}
	
	
	private Bitmap decodeResource(Resources resources, int id) {
		BitmapFactory.Options opts = new BitmapFactory.Options();
		opts.inPreferredConfig = Bitmap.Config.RGB_565;
		opts.inPurgeable = true;
		opts.inInputShareable = true;
		opts.inDensity = resources.getDisplayMetrics().densityDpi;
		opts.inTargetDensity = resources.getDisplayMetrics().densityDpi;
		return BitmapFactory.decodeResource(resources, id, opts);
	}


	public int[][] getmMap() {
		return mMap;
	}

	public int getXinMap(int mx){
		if (mPx<init_w*5) {
			return mx;
		}
		else if (mPx< GameMap.init_w * (mMap[0].length + 5) - GameView.standard_width) {
			return mx+init_w*5-mPx;
		}
		else {
			return mx-(GameMap.init_w * (mMap[0].length) - GameView.standard_width);
		}
	}
}
