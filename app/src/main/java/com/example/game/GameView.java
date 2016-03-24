package com.example.game;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class GameView extends SurfaceView implements Runnable, SurfaceHolder.Callback {
    //刷屏主线程  
    private Thread gameThread;
    //游戏屏幕宽和高  
    public static int screen_width, screen_height;
    public static int standard_width = 2880, standard_height = 1620;
    private Paint paint;
    private Canvas canvas;
    private SurfaceHolder sfh;
    private boolean run_flag = false;
    //敌人图片  
    private Bitmap bmp_enemy;
    //移动速度  
    private int enemy_speed = 5;
    //角色移动控制帧  
    private int frame = 0;
    //按键上下左右移动的判断  
    private boolean is_up, is_down, is_left, is_right;
    //上下左右移动动画帧编号  
    private int[] enemy_up = {3, 4, 5};
    private int[] enemy_down = {0, 1, 2};
    private int[] enemy_left = {6, 7, 8};
    private int[] enemy_right = {9, 10, 11};
    //当前帧动画  
    private int[] enemy_start = enemy_down;
    //初始角色单帧图片右上角位置和单帧图片宽和高  
    //右上角位置作为图片的人物的控制点不太合适  
    //private int X=50,Y=50,W,H;  

    //人物的控制点坐标和宽高  
    private int X, Y, W, H;

    private GameMap mGameMap;

    public GameView(Context context) {
        super(context);
        IntGameView(context);
    }

    public GameView(final Context context, AttributeSet attrs) {
        super(context, attrs);
        IntGameView(context);
    }

    public GameView(Context context, AttributeSet attrs, int defStyle) {
        super((Context) null, (AttributeSet) null, 0);
//        IntGameView(context);
    }

    public void IntGameView(final Context context) {

        sfh = getHolder();
        sfh.addCallback(this);

        paint = new Paint();
        paint.setAntiAlias(true);
        //获得焦点
        postDelayed(new Runnable() {
            @Override
            public void run() {
//                setFocusable(true);
//                setClickable(true);
//                setFocusableInTouchMode(true);
//                //保持屏幕常亮
//                setKeepScreenOn(true);
                Toast.makeText(context, "aaaa", Toast.LENGTH_SHORT).show();
            }
        }, 2000);


        bmp_enemy = BitmapFactory.decodeResource(getResources(), R.drawable.enemy);
        W = bmp_enemy.getWidth() / 13;
        H = bmp_enemy.getHeight();
        //这里我以单帧图片的中心点为控制点。具体控制点的位置，主要看你的图片了  
        X = X + W / 2;
        Y = Y + Y / 2;

        if (mPlayer == null) {
            mPlayer = new Player();
            mGameMap = new GameMap(context, mPlayer);
            npcs.add(new Player(true, 4500, 300));
            npcs.add(new Player(true, 10500, 300));
            npcs.add(new Player(true, 17500, 300));
            npcs.add(new Player(true, 14500, 300));
            npcs.add(new Player(true, 19500, 300));
            mGameMap.addPlayer(npcs);
        }
        mtextP.setAntiAlias(true);
        mtextP.setColor(Color.BLUE);
        mtextP.setTextSize(30);
        mtextP.setStyle(Paint.Style.FILL);
        mtextP.setStyle(Paint.Style.STROKE);

    }

    private Paint mtextP = new Paint();

    private Player mPlayer;
    private List<Player> npcs = new ArrayList();

    public void draw(Canvas canvas, Paint paint) {
        if (canvas != null) {
            canvas.drawColor(Color.parseColor("#51bd8b"));
            mtextP.setColor(Color.BLACK);
            mGameMap.drawMap(canvas);
            for (Player p : npcs) {
                p.drawPlayer(canvas);
            }
            mPlayer.drawPlayer(canvas);
            canvas.drawCircle(Stickdraw.BigCenterX, Stickdraw.BigCenterY, Stickdraw.BigCenterR, mtextP);
            Stickdraw.getStickInstance().drawstick(canvas);
            Attackdraw.getattackInstance().drawAttack(canvas);
            canvas.drawText(Stickdraw.direction + "+" + Stickdraw.smallCenterX + "+" + Stickdraw.smallCenterY + "+" + mUseTime + "+" + mPlayer.mJumpspeed + "", 100, 200, mtextP);
        }
    }

    public void logic() {
        mPlayer.StickDo(Stickdraw.direction);
        for (Player p : npcs) {
            p.StickDo(5);
            p.AI();
        }
        attackcheck();
    }


    public void attackcheck() {
        mPlayer.setmHit(false);
        for (Player player : npcs) {
            player.setmHit(false);
            if (player.hostility) {
                if (Math.abs(player.getmX() - mPlayer.getmX()) < 600) {
                    if (player.isattack && !player.ismHit()) {
                        if (player.checkAttack(mPlayer)) {
                            mPlayer.setmHit(true);
                        }
                    }
                    if (mPlayer.isattack && !mPlayer.ismHit()) {
                        if (mPlayer.checkAttack(player)) {
                            player.setmHit(true);
                        }
                    }
                }
            }
        }
    }

//      
//    @Override  
//    public boolean onKeyDown(int keyCode, KeyEvent event) {  
//        if(keyCode==KeyEvent.KEYCODE_DPAD_UP){  
//            is_up=true;  
//            enemy_start=enemy_up;  
//        }else if(keyCode==KeyEvent.KEYCODE_DPAD_DOWN){  
//            is_down=true;     
//            enemy_start=enemy_down;  
//        }else if(keyCode==KeyEvent.KEYCODE_DPAD_LEFT){  
//            is_left=true;  
//            enemy_start=enemy_left;  
//        }else if(keyCode==KeyEvent.KEYCODE_DPAD_RIGHT){  
//            is_right=true;  
//            enemy_start=enemy_right;  
//        }  
//        return super.onKeyDown(keyCode, event);  
//    }  
//      
//    @Override  
//    public boolean onKeyUp(int keyCode, KeyEvent event) {  
//        is_up=false;  
//        is_down=false;  
//        is_left=false;  
//        is_right=false;  
//        return super.onKeyUp(keyCode, event);  
//    }  
//      


    private int mDirection;

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        int pointerCount = event.getPointerCount();
        if (pointerCount > 3) {
            pointerCount = 3;
        }
        // 锁定Canvas,开始进行相应的界面处理  
//        Canvas c = getHolder().lockCanvas();  
//        if (c != null) {  
//            c.drawColor(Color.BLACK);  

        boolean b = false;
        boolean ac = false;
        if (pointerCount == 1 && event.getAction() == MotionEvent.ACTION_UP) {
            Stickdraw.getStickInstance().init();

        } else {
            for (int i = 0; i < pointerCount; i++) {
                // 获取一个触点的坐标，然后开始绘制
                int id = event.getPointerId(i);
                int x = (int) event.getX(i);
                int y = (int) event.getY(i);
                if (Stickdraw.getStickInstance().check(x, y)) {
                    b = true;
                }
                if (Attackdraw.getattackInstance().check(x, y)) {
                    ac = true;
                }
            }
            if (!b) {
                Stickdraw.getStickInstance().init();
            }
            if (!Attackdraw.getattackInstance().isAttacktouch() && ac) {
                mPlayer.preapattack = true;
            }
            Attackdraw.getattackInstance().setAttacktouch(ac);

        }

        is_up = true;
        enemy_start = enemy_up;
        return true;
    }

    private long mUseTime;

    @Override
    public void run() {
        while (run_flag) {

            long startTime = System.currentTimeMillis();
            logic();

            canvas = sfh.lockCanvas();
            draw(canvas, paint);
            long endTime = System.currentTimeMillis();
            long useTime = endTime - startTime;
            mUseTime = useTime;
            //固定屏幕刷新的时间为50ms
            try {
                if (mUseTime < 40) {
                    try {
                        Thread.sleep(40 - mUseTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                Log.e("Error", "刷屏线程出错了" + e);
            } finally {
                if (canvas != null) {
                    sfh.unlockCanvasAndPost(canvas);
                }
            }

        }
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        setFocusable(true);
        setClickable(true);
        setFocusableInTouchMode(true);
        if (screen_height == 0) {
            screen_width = getWidth();
            screen_height = getHeight();
        }
        gameThread = new Thread(this);

        run_flag = true;
        //启动线程
        gameThread.start();
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        run_flag = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
//        Toast.makeText(getContext(), "111" + format + "ww" + width + "111" + height + "", Toast.LENGTH_SHORT).show();
    }

}  