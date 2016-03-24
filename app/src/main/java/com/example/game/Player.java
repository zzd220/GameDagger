package com.example.game;

import java.util.ArrayList;
import java.util.List;

import android.R.integer;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Point;
import android.util.Log;

public class Player {

    private int mHead[],// 头
            mNeck[],// 脖子
            mLelbow[],// 左手肘
            mRelbow[],// 右手肘
            mLwrist[],// 左手腕
            mRwrist[],// 右手腕
            mBody[],// 躯干
            mLknee[],// 左膝盖
            mRknee[],// 右膝盖
            mLleg[],// 左脚
            mRleg[],// 右脚
            mWeaponc[],// 武器近
            mWeaponf[];// 武器远

    private int mX = 6400;
    private int mY = 200;
    private int mHeadSize = 25;
    private int mPalmSize = 10;
    private ActionPool mActionPool;
    public Paint mPlayerPaint;
    private int mDirection = 5;
    private boolean mHit = false;
    private boolean mOnground = false;
    public static final int mMoveSpeed = 30;
    private int mAirSpeed = 18;
    private boolean mRightDirection = true;
    //	private int mAirframe;
//	private static int mJumpHeightMax = 400;
//	private static int mJumpFrameMax = 20;
    public int mJumpspeed = 0;
    private static int mGravity = 20;
    private GameMap mGameMap;
    boolean hostility = false;


    public Player() {
        mActionPool = new ActionPool();
//		mActionPool.getmActionList().add(Action.getStandAction());
        mPlayerPaint = new Paint();
        mPlayerPaint.setAntiAlias(true);
        mPlayerPaint.setStrokeWidth(5);
        mPlayerPaint.setColor(Color.BLACK);
        weaponPaint.setAntiAlias(true);
        weaponPaint.setStrokeWidth(2);
        weaponPaint.setColor(Color.BLACK);
        // mPlayerPaint.setPathEffect(new CornerPathEffect(15));
    }

    public Player(boolean hosti, int x, int y) {
        mActionPool = new ActionPool();
        mPlayerPaint = new Paint();
        mPlayerPaint.setAntiAlias(true);
        mPlayerPaint.setStrokeWidth(5);
        hostility = hosti;
        mX = x;
        mY = y;
        mPlayerPaint.setColor(Color.parseColor("#c83737"));
    }

    public void move() {

    }

    private int[][] mNowCoords;

    public boolean preapattack = false;
    public boolean isattack = false;

    public void drawPlayer(Canvas mcanvas) {
        if (preapattack) {
            preapattack = false;
            if (mDirection == 2) {
                mActionPool.addAttackB_Action(1);
            } else
                mActionPool.addAttackAction(1);
        }
//        mActionPool.addAction();
        mNowCoords = mActionPool.getNextCoord(Player.this);
        mHead = mNowCoords[0];
        mRwrist = mNowCoords[3];
        mRelbow = mNowCoords[4];
        mNeck = mNowCoords[5];
        mLelbow = mNowCoords[6];
        mLwrist = mNowCoords[7];
        mBody = mNowCoords[8];
        mRknee = mNowCoords[9];
        mLknee = mNowCoords[10];
        mRleg = mNowCoords[11];
        mLleg = mNowCoords[12];
        mWeaponc = mNowCoords[2];
        mWeaponf = mNowCoords[1];
        if (mX < 0) {
            mX = 0;
        }
        int mmx = mX;
        if (!hostility) {
            if (mX <= GameMap.init_w * 5) {
            } else if (mX > GameMap.init_w * 5 && mX < GameMap.init_w * (mGameMap.getmMap()[0].length + 5) - GameView.standard_width) {
                mX = GameMap.init_w * 5;
            } else {
                if (mX > GameMap.init_w * (mGameMap.getmMap()[0].length) - 250) {
                    mX = mmx = GameMap.init_w * (mGameMap.getmMap()[0].length) - 250;
                }
                mX = mX + GameView.standard_width - GameMap.init_w * (mGameMap.getmMap()[0].length);
            }
        } else {
            mX = mGameMap.getXinMap(mX);
        }
        if (mRightDirection) {
            CanvasUtils.drawLine(mcanvas, mHead[0] + mX, mHead[1] + mY, mNeck[0] + mX, mNeck[1] + mY, mPlayerPaint);// 画脖子
            CanvasUtils.drawCircle(mcanvas, mHead[0] + mX, mHead[1] + mY, mHeadSize, mPlayerPaint);// 画头
            CanvasUtils.drawLine(mcanvas, mNeck[0] + mX, mNeck[1] + mY, mRelbow[0] + mX, mRelbow[1] + mY, mPlayerPaint);// 画右大臂
            CanvasUtils.drawLine(mcanvas, mRelbow[0] + mX, mRelbow[1] + mY, mRwrist[0] + mX, mRwrist[1] + mY, mPlayerPaint);// 画右小臂
            CanvasUtils.drawLine(mcanvas, mNeck[0] + mX, mNeck[1] + mY, mLelbow[0] + mX, mLelbow[1] + mY, mPlayerPaint);// 画左大臂
            CanvasUtils.drawLine(mcanvas, mLelbow[0] + mX, mLelbow[1] + mY, mLwrist[0] + mX, mLwrist[1] + mY, mPlayerPaint);// 画左小臂
            CanvasUtils.drawLine(mcanvas, mNeck[0] + mX, mNeck[1] + mY, mBody[0] + mX, mBody[1] + mY, mPlayerPaint);// 画身体
            CanvasUtils.drawLine(mcanvas, mBody[0] + mX, mBody[1] + mY, mRknee[0] + mX, mRknee[1] + mY, mPlayerPaint);// 画右大腿
            CanvasUtils.drawLine(mcanvas, mRknee[0] + mX, mRknee[1] + mY, mRleg[0] + mX, mRleg[1] + mY, mPlayerPaint);// 画右小腿
            CanvasUtils.drawLine(mcanvas, mBody[0] + mX, mBody[1] + mY, mLknee[0] + mX, mLknee[1] + mY, mPlayerPaint);// 画左大腿
            CanvasUtils.drawLine(mcanvas, mLknee[0] + mX, mLknee[1] + mY, mLleg[0] + mX, mLleg[1] + mY, mPlayerPaint);// 画左小腿
            CanvasUtils.drawCircle(mcanvas, mRwrist[0] + mX, mRwrist[1] + mY, mPalmSize, mPlayerPaint);// 画右手
            CanvasUtils.drawCircle(mcanvas, mLwrist[0] + mX, mLwrist[1] + mY, mPalmSize, mPlayerPaint);// 画左手
//            CanvasUtils.drawLine(mcanvas, mWeaponc[0] + mX, mWeaponc[1] + mY, mWeaponf[0] + mX, mWeaponf[1] + mY, mPlayerPaint);// 画武器
//            drawweapon( mX,  mY,  mX,  mY, mcanvas, mPlayerPaint);
            drawweapon(mWeaponc[0] , mWeaponc[1] , mWeaponf[0], mWeaponf[1] , mcanvas, mPlayerPaint);
        } else {
            CanvasUtils.drawLine(mcanvas, 300 - mHead[0] + mX, mHead[1] + mY, 300 - mNeck[0] + mX, mNeck[1] + mY, mPlayerPaint);// 画脖子
            CanvasUtils.drawCircle(mcanvas, 300 - mHead[0] + mX, mHead[1] + mY, mHeadSize, mPlayerPaint);// 画头
            CanvasUtils.drawLine(mcanvas, 300 - mNeck[0] + mX, mNeck[1] + mY, 300 - mRelbow[0] + mX, mRelbow[1] + mY, mPlayerPaint);// 画右大臂
            CanvasUtils.drawLine(mcanvas, 300 - mRelbow[0] + mX, mRelbow[1] + mY, 300 - mRwrist[0] + mX, mRwrist[1] + mY, mPlayerPaint);// 画右小臂
            CanvasUtils.drawLine(mcanvas, 300 - mNeck[0] + mX, mNeck[1] + mY, 300 - mLelbow[0] + mX, mLelbow[1] + mY, mPlayerPaint);// 画左大臂
            CanvasUtils.drawLine(mcanvas, 300 - mLelbow[0] + mX, mLelbow[1] + mY, 300 - mLwrist[0] + mX, mLwrist[1] + mY, mPlayerPaint);// 画左小臂
            CanvasUtils.drawLine(mcanvas, 300 - mNeck[0] + mX, mNeck[1] + mY, 300 - mBody[0] + mX, mBody[1] + mY, mPlayerPaint);// 画身体
            CanvasUtils.drawLine(mcanvas, 300 - mBody[0] + mX, mBody[1] + mY, 300 - mRknee[0] + mX, mRknee[1] + mY, mPlayerPaint);// 画右大腿
            CanvasUtils.drawLine(mcanvas, 300 - mRknee[0] + mX, mRknee[1] + mY, 300 - mRleg[0] + mX, mRleg[1] + mY, mPlayerPaint);// 画右小腿
            CanvasUtils.drawLine(mcanvas, 300 - mBody[0] + mX, mBody[1] + mY, 300 - mLknee[0] + mX, mLknee[1] + mY, mPlayerPaint);// 画左大腿
            CanvasUtils.drawLine(mcanvas, 300 - mLknee[0] + mX, mLknee[1] + mY, 300 - mLleg[0] + mX, mLleg[1] + mY, mPlayerPaint);// 画左小腿
            CanvasUtils.drawCircle(mcanvas, 300 - mRwrist[0] + mX, mRwrist[1] + mY, mPalmSize, mPlayerPaint);// 画右手
            CanvasUtils.drawCircle(mcanvas, 300 - mLwrist[0] + mX, mLwrist[1] + mY, mPalmSize, mPlayerPaint);// 画左手
//            CanvasUtils.drawLine(mcanvas, 300 - mWeaponc[0] + mX, mWeaponc[1] + mY, 300 - mWeaponf[0] + mX, mWeaponf[1] + mY, mPlayerPaint);// 画武器
            drawweapon(300 - mWeaponc[0] , mWeaponc[1] , 300 - mWeaponf[0], mWeaponf[1] , mcanvas, mPlayerPaint);
//            drawweapon(300  + mX, mY, 300  + mX,  mY, mcanvas, mPlayerPaint);
        }
        mX = mmx;
    }

    Paint weaponPaint=new Paint();

    public void drawweapon(float x1, float y1, float x2, float y2, Canvas mcanvas, Paint paint) {
//        x1=0;
//        x2=0;
//        y1=0;
//        y2=-400;
        float L = 10;
        float xs1, ys1, xs2, ys2, xs3, ys3;
        xs1 = (x1 * 3 + x2 * 7) / 10;
        ys1 = (y1 * 3 + y2 * 7) / 10;
        xs2 = (x1 * 2 + x2 * 8) / 10;
        ys2 = (y1 * 2 + y2 * 8) / 10;
        xs3 = (x1 * 1 + x2 * 9) / 10;
        ys3 = (y1 * 1 + y2 * 9) / 10;
        float[][] points1 = getupx( xs2, ys2,xs1, ys1, L);
        float[][] points2 = getupx( xs2, ys2,xs3, ys3, L);
        CanvasUtils.drawLine(mcanvas, x1+mX, y1+mY, xs2+mX, ys2+mY, paint);

//        Log.e("aaa", points1[0][0] + "  " + points1[0][1] + "  " + points1[1][0] +
//                "  " + points1[1][1] + "  " + points2[0][0] + "  " + points2[0][1] + "  "+ points2[1][0] + "  " + points2[1][1] + "" );
        CanvasUtils.drawLine(mcanvas, points1[0][0]+mX, points1[0][1]+mY, points2[0][0]+mX, points2[0][1]+mY, weaponPaint);
        CanvasUtils.drawLine(mcanvas, points1[1][0]+mX, points1[1][1]+mY, points2[1][0]+mX, points2[1][1]+mY, weaponPaint);
        CanvasUtils.drawLine(mcanvas, points2[1][0]+mX, points2[1][1]+mY, x2+mX, y2+mY, weaponPaint);
        CanvasUtils.drawLine(mcanvas, points2[0][0]+mX, points2[0][1]+mY, x2+mX, y2+mY, weaponPaint);


    }

    public float[][] getupx(float a, float b, float m, float n, float L) {
        float[][] points = new float[2][2];
        points[0][0] = (float) (m - L * (b - n) / Math.sqrt((a - m) * (a - m) + (b - n) * (b - n)));
        points[1][0] = (float) (m + L * (b - n) / Math.sqrt((a - m) * (a - m) + (b - n) * (b - n)));
        points[1][1] = (float) (n - L * (a - m) / Math.sqrt((a - m) * (a - m) + (b - n) * (b - n)));
        points[0][1] = (float) (n + L * (a - m) / Math.sqrt((a - m) * (a - m) + (b - n) * (b - n)));
        return points;
    }

    public void StickDo(int direction) {
        if (!ismHit()) {
            mDirection = direction;
            switch (mDirection) {
                case 1:
                    mRightDirection = false;
                    break;
                case 2:

                    break;
                case 3:
                    mRightDirection = true;
                    break;
                case 4:
                    mRightDirection = false;
                    break;
                case 5:

                    break;
                case 6:
                    mRightDirection = true;
                    break;
                case 7:
                    mRightDirection = false;
                    if (mOnground) {
                        mActionPool.addJumpAction(7);
                    }
                    break;
                case 8:
                    if (mOnground) {
                        mActionPool.addJumpAction(8);
                    }
                    break;
                case 9:
                    mRightDirection = true;
                    if (mOnground) {
                        mActionPool.addJumpAction(9);
                    }
                    break;
                default:
                    break;
            }

            // 下一帧位置朝向

            if (!mOnground) {
                mY -= mJumpspeed;
                mJumpspeed -= mGravity;

            }

            if (mJumpspeed < 0 && mJumpspeed > -21 && !mOnground) {
                mActionPool.addJumpDownAction();
            } else if (mDirection != 5 && mDirection != 2) {
                if (mOnground && mDirection < 7) {
                    mActionPool.addRunAction();
//                if (preapattack) {
//                    preapattack = false;
//                    mActionPool.addAttackAction(1);
//                }
                }
            } else {
                if (mOnground) {
                    mActionPool.addAction();
//                if (preapattack) {
//                    preapattack = false;
//                    mActionPool.addAttackAction(1);
//                }
                }
            }
        } else {
            mActionPool.addBeAttackAction(8);
        }


        checkwithMap();

    }

    //	public int getYbyFrame(int frame) {
//		return -mJumpHeightMax*4 * frame*frame/(mJumpFrameMax*mJumpFrameMax) + mJumpHeightMax*4 * frame/mJumpFrameMax;
//	}
    public void checkwithMap() {
        mGameMap.checkPlayer(Player.this);
    }

    public boolean checkAttack(Player p) {
        int r1, r2;
        if (ismRightDirection())
            r1 = 1;
        else r1 = -1;
        if (p.ismRightDirection())
            r2 = 1;
        else r2 = -1;
        if (isIntersect((this.mWeaponc[0] - 150) * r1 + 150 + mX, this.mWeaponc[1] + mY, (this.mWeaponf[0] - 150) * r1 + 150 + mX, this.mWeaponf[1] + mY, (p.mHead[0] - 150) * r2 + 150 + p.mX, p.mHead[1] + p.mY, (p.mBody[0] - 150) * r2 + 150 + p.mX, p.mBody[1] + p.mY)) {
            return true;
        }
        if (isIntersect((this.mWeaponc[0] - 150) * r1 + 150 + mX, this.mWeaponc[1] + mY, (this.mWeaponf[0] - 150) * r1 + 150 + mX, this.mWeaponf[1] + mY, (p.mNeck[0] - 150) * r2 + 150 + p.mX, p.mNeck[1] + p.mY, (p.mLelbow[0] - 150) * r2 + 150 + p.mX, p.mLelbow[1] + p.mY)) {
            return true;
        }
        if (isIntersect((this.mWeaponc[0] - 150) * r1 + 150 + mX, this.mWeaponc[1] + mY, (this.mWeaponf[0] - 150) * r1 + 150 + mX, this.mWeaponf[1] + mY, (p.mNeck[0] - 150) * r2 + 150 + p.mX, p.mNeck[1] + p.mY, (p.mRelbow[0] - 150) * r2 + 150 + p.mX, p.mRelbow[1] + p.mY)) {
            return true;
        }
        if (isIntersect((this.mWeaponc[0] - 150) * r1 + 150 + mX, this.mWeaponc[1] + mY, (this.mWeaponf[0] - 150) * r1 + 150 + mX, this.mWeaponf[1] + mY, (p.mLelbow[0] - 150) * r2 + 150 + p.mX, p.mLelbow[1] + p.mY, (p.mLwrist[0] - 150) * r2 + 150 + p.mX, p.mLwrist[1] + p.mY)) {
            return true;
        }
        if (isIntersect((this.mWeaponc[0] - 150) * r1 + 150 + mX, this.mWeaponc[1] + mY, (this.mWeaponf[0] - 150) * r1 + 150 + mX, this.mWeaponf[1] + mY, (p.mRelbow[0] - 150) * r2 + 150 + p.mX, p.mRelbow[1] + p.mY, (p.mRwrist[0] - 150) * r2 + 150 + p.mX, p.mRwrist[1] + p.mY)) {
            return true;
        }
        if (isIntersect((this.mWeaponc[0] - 150) * r1 + 150 + mX, this.mWeaponc[1] + mY, (this.mWeaponf[0] - 150) * r1 + 150 + mX, this.mWeaponf[1] + mY, (p.mBody[0] - 150) * r2 + 150 + p.mX, p.mBody[1] + p.mY, (p.mLknee[0] - 150) * r2 + 150 + p.mX, p.mLknee[1] + p.mY)) {
            return true;
        }
        if (isIntersect((this.mWeaponc[0] - 150) * r1 + 150 + mX, this.mWeaponc[1] + mY, (this.mWeaponf[0] - 150) * r1 + 150 + mX, this.mWeaponf[1] + mY, (p.mBody[0] - 150) * r2 + 150 + p.mX, p.mBody[1] + p.mY, (p.mRknee[0] - 150) * r2 + 150 + p.mX, p.mRknee[1] + p.mY)) {
            return true;
        }
        if (isIntersect((this.mWeaponc[0] - 150) * r1 + 150 + mX, this.mWeaponc[1] + mY, (this.mWeaponf[0] - 150) * r1 + 150 + mX, this.mWeaponf[1] + mY, (p.mLknee[0] - 150) * r2 + 150 + p.mX, p.mLknee[1] + p.mY, (p.mLleg[0] - 150) * r2 + 150 + p.mX, p.mLleg[1] + p.mY)) {
            return true;
        }
        if (isIntersect((this.mWeaponc[0] - 150) * r1 + 150 + mX, this.mWeaponc[1] + mY, (this.mWeaponf[0] - 150) * r1 + 150 + mX, this.mWeaponf[1] + mY, (p.mRknee[0] - 150) * r2 + 150 + p.mX, p.mRknee[1] + p.mY, (p.mRleg[0] - 150) * r2 + 150 + p.mX, p.mRleg[1] + p.mY)) {
            return true;
        }
        return false;
    }

    public boolean isIntersect(float px1, float py1, float px2, float py2, float px3, float py3, float px4, float py4)//p1-p2 is or not intersect with p3-p4
    {
        boolean flag = false;
        float d = (px2 - px1) * (py4 - py3) - (py2 - py1) * (px4 - px3);
        if (d != 0) {
            float r = ((py1 - py3) * (px4 - px3) - (px1 - px3) * (py4 - py3)) / d;
            float s = ((py1 - py3) * (px2 - px1) - (px1 - px3) * (py2 - py1)) / d;
            if ((r >= 0) && (r <= 1) && (s >= 0) && (s <= 1)) {
                flag = true;
            }
        }
        return flag;
    }

    int aisecond = 0;

    public void AI() {
        if (mX > mGameMap.mPx) {
            setmRightDirection(false);
        } else {
            setmRightDirection(true);
        }
        if (aisecond % 20 == 0) {
            if (Math.random() > 0.7) {
                preapattack = true;
            }
        }
        aisecond++;
    }


    public int[] getmHead() {
        return mHead;
    }

    public void setmHead(int[] mHead) {
        this.mHead = mHead;
    }

    public int[] getmNeck() {
        return mNeck;
    }

    public void setmNeck(int[] mNeck) {
        this.mNeck = mNeck;
    }

    public int[] getmLelbow() {
        return mLelbow;
    }

    public void setmLelbow(int[] mLelbow) {
        this.mLelbow = mLelbow;
    }

    public int[] getmRelbow() {
        return mRelbow;
    }

    public void setmRelbow(int[] mRelbow) {
        this.mRelbow = mRelbow;
    }

    public int[] getmLwrist() {
        return mLwrist;
    }

    public void setmLwrist(int[] mLwrist) {
        this.mLwrist = mLwrist;
    }

    public int[] getmRwrist() {
        return mRwrist;
    }

    public void setmRwrist(int[] mRwrist) {
        this.mRwrist = mRwrist;
    }

    public int[] getmBody() {
        return mBody;
    }

    public void setmBody(int[] mBody) {
        this.mBody = mBody;
    }

    public int[] getmLknee() {
        return mLknee;
    }

    public void setmLknee(int[] mLknee) {
        this.mLknee = mLknee;
    }

    public int[] getmRknee() {
        return mRknee;
    }

    public void setmRknee(int[] mRknee) {
        this.mRknee = mRknee;
    }

    public int[] getmLleg() {
        return mLleg;
    }

    public void setmLleg(int[] mLleg) {
        this.mLleg = mLleg;
    }

    public int[] getmRleg() {
        return mRleg;
    }

    public void setmRleg(int[] mRleg) {
        this.mRleg = mRleg;
    }

    public int getmX() {
        return mX;
    }

    public void setmX(int mX) {
        this.mX = mX;
    }

    public int getmY() {
        return mY;
    }

    public void setmY(int mY) {
        this.mY = mY;
    }

    public int getmHeadSize() {
        return mHeadSize;
    }

    public void setmHeadSize(int mHeadSize) {
        this.mHeadSize = mHeadSize;
    }

    public int getmPalmSize() {
        return mPalmSize;
    }

    public void setmPalmSize(int mPalmSize) {
        this.mPalmSize = mPalmSize;
    }

    public ActionPool getmActionPool() {
        return mActionPool;
    }

    public void setmActionPool(ActionPool mActionPool) {
        this.mActionPool = mActionPool;
    }

    public Paint getmPlayerPaint() {
        return mPlayerPaint;
    }

    public void setmPlayerPaint(Paint mPlayerPaint) {
        this.mPlayerPaint = mPlayerPaint;
    }

    public int getmDirection() {
        return mDirection;
    }

    public void setmDirection(int mDirection) {
        this.mDirection = mDirection;
    }

    public boolean ismHit() {
        return mHit;
    }

    public void setmHit(boolean mHit) {
        this.mHit = mHit;
    }

    public boolean ismOnground() {
        return mOnground;
    }

    public void setmOnground(boolean mOnground) {
        this.mOnground = mOnground;
    }

    public int getmMoveSpeed() {
        return mMoveSpeed;
    }

//    public void setmMoveSpeed(int mMoveSpeed) {
//        this.mMoveSpeed = mMoveSpeed;
//    }

    public int getmAirSpeed() {
        return mAirSpeed;
    }

    public void setmAirSpeed(int mAirSpeed) {
        this.mAirSpeed = mAirSpeed;
    }

    public boolean ismRightDirection() {
        return mRightDirection;
    }

    public void setmRightDirection(boolean mRightDirection) {
        this.mRightDirection = mRightDirection;
    }


    public int[][] getmNowCoords() {
        return mNowCoords;
    }

    public void setmNowCoords(int[][] mNowCoords) {
        this.mNowCoords = mNowCoords;
    }


    public static int getmGravity() {
        return mGravity;
    }

    public static void setmGravity(int mGravity) {
        Player.mGravity = mGravity;
    }

    public GameMap getmGameMap() {
        return mGameMap;
    }

    public void setmGameMap(GameMap mGameMap) {
        this.mGameMap = mGameMap;
    }


}
