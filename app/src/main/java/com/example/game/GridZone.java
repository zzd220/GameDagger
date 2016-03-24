package com.example.game;
/**
 * 类说明
 * @author zheng.zong.di
 * @date 2016年1月13日
 * @version 1.0
 *
 */
public class GridZone {

	public static void check(int type,int i,int j,Player player) {
		switch (type){
			case 1:
				int height=player.getmY()-(GameView.standard_height-GameMap.init_h*(5-j)-400+50);
				if (player.getmX()>(i-1)*GameMap.init_w+30&&player.getmX()<(i+1)*GameMap.init_w-70){
					if (height>=0&&height<250&&player.mJumpspeed<=0){
						player.mJumpspeed=0;
						player.setmOnground(true);
						player.setmY(GameView.standard_height - GameMap.init_h * (5 - j) - 400 + 50);
					}
					else if (height>=100&&height<400+GameMap.init_h){
						if (player.getmX()<i*GameMap.init_w-20)
						player.setmX((i-1)*GameMap.init_w+30);
						else
							player.setmX((i+1)*GameMap.init_w-70);
					}

				}
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				break;
			case 7:
				break;
		}
	}
	
}
