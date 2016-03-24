package com.example.game;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ZZD on 2016/1/18.
 */
public interface  Action {
    public  List<Step> getmSteps();

    public void setmSteps(List<Step> mSteps);
    public int getActontype();
    public void setDirection(int d);
    public int getDirection();
}
