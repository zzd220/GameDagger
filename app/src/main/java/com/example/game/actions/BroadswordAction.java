package com.example.game.actions;

import com.example.game.Action;
import com.example.game.Step;

import java.util.ArrayList;
import java.util.List;

public class BroadswordAction implements Action {

    private List<Step> mSteps = new ArrayList<Step>();

    public BroadswordAction() {
        setmSteps(new ArrayList<Step>());
    }

    public BroadswordAction(BroadswordAction action) {

        setmSteps(action.getmSteps());
    }

    static BroadswordAction mStand;

    public Action getStandAction() {
        if (mStand == null) {
            mStand = new BroadswordAction();
            mStand.addStep(new Step(new int[][]{{144, 38},
                    {101, 212}, {105, 134}, {144, 71}, {171, 138}, {125, 202},
                    {144, 193},
                    {95, 300}, {190, 298},
                    {62, 399}, {220, 399},}, 4));
            mStand.addStep(new Step(new int[][]{{144, 43},
                    {101, 216}, {105, 138}, {144, 75}, {171, 142}, {125, 206},
                    {144, 196},
                    {95, 302}, {190, 300},
                    {62, 399}, {220, 399},}, 4));
        }
        return mStand;
    }

    private void addStep(Step step) {
        getmSteps().add(step);
    }

    public List<Step> getmSteps() {
        return mSteps;
    }

    public void setmSteps(List<Step> mSteps) {
        this.mSteps = mSteps;
    }

    @Override
    public int getActontype() {
        return 0;
    }

    @Override
    public void setDirection(int d) {

    }

    @Override
    public int getDirection() {
        return 0;
    }
}
