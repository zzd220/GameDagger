package com.example.game;

public class Step {
	private int [][]mCoord={  {0,0},
			{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},{0,0},
			                  {0,0},
		   	               {0,0},{0,0},
		                   {0,0},{0,0}
	                       };
	private int mDuration;
	public int mX,vY,mZ;
	public static Step Stand;
	
	public Step(int [][]coord,int duration,int m,int v) {
		setmCoord(coord);
		setmDuration(duration);
		mX=m;
		vY=v;
	}
	public Step(int [][]coord,int duration) {
		setmCoord(coord);
		setmDuration(duration);
		mX=Player.mMoveSpeed;
		vY=0;
	}

	public int [][] getmCoord() {
		return mCoord;
	}

	public void setmCoord(int [][] mCoord) {
		this.mCoord = mCoord;
	}

	public int getmDuration() {
		return mDuration;
	}

	public void setmDuration(int mDuration) {
		this.mDuration = mDuration;
	}
	
	public int nextmDuration() {
		this.mDuration--;
		return mDuration;
	}
}
