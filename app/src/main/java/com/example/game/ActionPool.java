package com.example.game;

import com.example.game.actions.PikeAction;

import java.util.ArrayList;
import java.util.List;

/**
 * 类说明
 * @author zheng.zong.di
 * @date 2015年4月8日
 * @version 1.0
 *
 */
public class ActionPool {

	private int[][] mFromCoords;
	private int[][] mToCoords;
	private List<Action> mActionList = new ArrayList<Action>();

	public ActionPool() {
		// TODO Auto-generated constructor stub
		addAction();
	}

	public List<Action> getmActionList() {
		return mActionList;
	}

	public void setmActionList(List<Action> mActionList) {
		this.mActionList = mActionList;
	}

	public void addAction() {
		if (mActionList.size()==2){
			if (mActionList.get(1).getActontype()==2&&mActionList.get(1).getActontype()==4)
				mActionList.remove(1);
		}
		if (mActionList.size()>0&&mActionList.get(0).getActontype()==2){
			for (int i=mActionList.get(0).getmSteps().size();i>1;i--){
				mActionList.get(0).getmSteps().remove(i-1);
				mActionList.get(0).getmSteps().get(0).setmDuration(3);
			}

			mActionList.get(0).getmSteps().get(0).mX=0;
		}
		if (mActionList.size()>0&&mActionList.get(0).getActontype()==4){
			for (int i=mActionList.get(0).getmSteps().size();i>1;i--){
				mActionList.get(0).getmSteps().remove(i-1);
				mActionList.get(0).getmSteps().get(0).setmDuration(2);
			}

			mActionList.get(0).getmSteps().get(0).mX=0;
		}
		if (mActionList.size()<2) {
			Action standaction=new PikeAction(1);
			mActionList.add(standaction);
		}
	}
	public void addRunAction() {
		if (mActionList.size()==2){
			if (mActionList.get(1).getActontype()==1)
			mActionList.remove(1);
		}
		if (mActionList.get(0).getActontype()==1){
			for (int i=mActionList.get(0).getmSteps().size();i>1;i--){
				mActionList.get(0).getmSteps().remove(i-1);
				mActionList.get(0).getmSteps().get(0).setmDuration(3);
			}
			mActionList.get(0).getmSteps().get(0).mX=Player.mMoveSpeed;
		}
		if (mActionList.get(0).getActontype()==4){
			for (int i=mActionList.get(0).getmSteps().size();i>1;i--){
				mActionList.get(0).getmSteps().remove(i-1);
				mActionList.get(0).getmSteps().get(0).setmDuration(2);
			}
			mActionList.get(0).getmSteps().get(0).mX=Player.mMoveSpeed;
		}
		if (mActionList.size()<2) {
			Action runction=new PikeAction(2);
			mActionList.add(runction);
		}
	}

	public void addJumpAction(int d) {
		if (mActionList.size()==2){
			if (mActionList.get(1).getActontype()<3)
				mActionList.remove(1);
		}
		if (mActionList.get(0).getActontype()<5){
			for (int i=mActionList.get(0).getmSteps().size();i>1;i--){
				mActionList.get(0).getmSteps().remove(i - 1);
				mActionList.get(0).getmSteps().get(0).setmDuration(3);
			}

		}
		if (mActionList.size()<2) {
			Action runction=new PikeAction(3);
			runction.setDirection(d);
			mActionList.add(runction);
		}
	}

	public void addAttackAction(int d) {

		if (mActionList.get(0).getActontype()<3){
			for (int i=mActionList.get(0).getmSteps().size();i>1;i--){
				mActionList.get(0).getmSteps().remove(i - 1);
				mActionList.get(0).getmSteps().get(0).setmDuration(2);
			}
			if (mActionList.size()==2){
				if (mActionList.get(1).getActontype()<3)
					mActionList.remove(1);
			}
			if (mActionList.size()<2) {
				Action runction=new PikeAction(5);
				runction.setDirection(d);
				mActionList.add(runction);
			}
		}

	}

	public void addAttackB_Action(int d) {

		if (mActionList.get(0).getActontype()<3){
			for (int i=mActionList.get(0).getmSteps().size();i>1;i--){
				mActionList.get(0).getmSteps().remove(i - 1);
				mActionList.get(0).getmSteps().get(0).setmDuration(2);
			}
			if (mActionList.size()==2){
				if (mActionList.get(1).getActontype()<3)
					mActionList.remove(1);
			}
			if (mActionList.size()<2) {
				Action runction=new PikeAction(6);
				runction.setDirection(d);
				mActionList.add(runction);
			}
		}

	}

	public void addBeAttackAction(int d) {

		if (mActionList.get(0).getActontype()<20){
			for (int i=mActionList.get(0).getmSteps().size();i>1;i--){
				mActionList.get(0).getmSteps().remove(i - 1);
				mActionList.get(0).getmSteps().get(0).setmDuration(1);
			}
			if (mActionList.size()==2){
				if (mActionList.get(1).getActontype()<20)
					mActionList.remove(1);
			}
			if (mActionList.size()<2) {
				Action runction=new PikeAction(20);
				runction.setDirection(d);
				mActionList.add(runction);
			}
		}

	}

	public void addJumpDownAction() {
		if (mActionList.size()==2){
			if (mActionList.get(1).getActontype()<4)
				mActionList.remove(1);
		}
		if (mActionList.get(0).getActontype()<3){
			for (int i=mActionList.get(0).getmSteps().size();i>1;i--){
				mActionList.get(0).getmSteps().remove(i - 1);
				mActionList.get(0).getmSteps().get(0).setmDuration(1);
			}

		}
		else if (mActionList.get(0).getActontype()<4){
			for (int i=mActionList.get(0).getmSteps().size();i>1;i--){
				mActionList.get(0).getmSteps().remove(i - 1);
				mActionList.get(0).getmSteps().get(0).setmDuration(3);
			}

		}
		if (mActionList.size()<2&&mActionList.get(0).getActontype()!=4) {
			Action runction=new PikeAction(4);
			runction.setDirection(mActionList.get(0).getDirection());
//			mActionList.remove(0);
			mActionList.add(runction);
		}
	}
	public void checkAction(int type){
//		if (mActionList.get())
	}

	public int [][] getNextCoord(Player player) {

//		if (player.ismRightDirection())
//		player.setmX(player.getmX()+mActionList.get(0).getmSteps().get(0).mX);
//		else
//			player.setmX(player.getmX()-mActionList.get(0).getmSteps().get(0).mX);

		if (mActionList.get(0).getmSteps().get(0).getmDuration()==1) {
			mActionList.get(0).getmSteps().remove(0);
			if (mActionList.get(0).getmSteps().size()==0) {
				mActionList.remove(0);
			}
			if (mActionList.size()==0)
			 addAction();
			if (mActionList.get(0).getmSteps().size()==0)
			{mActionList.remove(0);
				addAction();}
			if (mActionList.get(0).getmSteps().get(0).mZ!=0){
				player.setmX(player.getmX() + mActionList.get(0).getmSteps().get(0).mZ);
			}
			else if (mActionList.get(0).getmSteps().get(0).mX!=0){
				player.setmX(player.ismRightDirection() ? player.getmX() + mActionList.get(0).getmSteps().get(0).mX : player.getmX() - mActionList.get(0).getmSteps().get(0).mX);
			}
			if (mActionList.get(0).getmSteps().get(0).vY!=0){
				player.mJumpspeed=mActionList.get(0).getmSteps().get(0).vY;
				player.setmOnground(false);
			}

			if (mActionList.get(0).getActontype()>=5&&mActionList.get(0).getActontype()<=19){
				player.isattack=true;
			}
			else {
				player.isattack=false;
			}
			return getmActionList().get(0).getmSteps().get(0).getmCoord();
		}
		else {
			int duration=mActionList.get(0).getmSteps().get(0).nextmDuration();
			mFromCoords=mActionList.get(0).getmSteps().get(0).getmCoord();
			if (mActionList.get(0).getmSteps().size()<=1) {
				if (mActionList.size()>1)
				mToCoords=mActionList.get(1).getmSteps().get(0).getmCoord();
				else
					mToCoords=mActionList.get(0).getmSteps().get(0).getmCoord();
			}
			else {
				mToCoords=mActionList.get(0).getmSteps().get(1).getmCoord();
			}
			for (int i = 0; i < mFromCoords.length; i++) {
				for (int j = 0; j < 2; j++) {
					mFromCoords[i][j]=(mFromCoords[i][j]*duration+mToCoords[i][j])/(duration+1);
				}
			}
			if (mActionList.get(0).getmSteps().get(0).mZ!= 0) {
				player.setmX(player.getmX() + mActionList.get(0).getmSteps().get(0).mZ);
			}
			else if (mActionList.get(0).getmSteps().get(0).mX != 0) {
				player.setmX(player.ismRightDirection() ? player.getmX() + mActionList.get(0).getmSteps().get(0).mX : player.getmX() - mActionList.get(0).getmSteps().get(0).mX);
			}

			if (mActionList.get(0).getmSteps().get(0).vY!=0){
				player.mJumpspeed=mActionList.get(0).getmSteps().get(0).vY;
				player.setmOnground(false);
			}
			if (mActionList.get(0).getActontype()>=5&&mActionList.get(0).getActontype()<=19){
				player.isattack=true;
			}
			else {
				player.isattack=false;
			}
			return mFromCoords;
		}

	}
}
