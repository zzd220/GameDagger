package com.example.game.actions;

import com.example.game.Action;
import com.example.game.Step;

import java.util.ArrayList;
import java.util.List;

public class PikeAction implements Action {
    public List<Step> mSteps = new ArrayList();
    public int mActtype = 1;
    public int mDirection = 0;

    public PikeAction(int acttype) {
        mActtype = acttype;
        switch (acttype) {
            case 1: {
                setmSteps(getStandAction().getmSteps());
            }
            break;
            case 2: {
                setmSteps(getRunAction().getmSteps());
            }
            break;
            case 3: {
                setmSteps(getJumpAction().getmSteps());
            }
            break;
            case 4: {
                setmSteps(getJumpDownAction().getmSteps());
            }
            break;
            case 5: {
                setmSteps(getAttack_a_Action().getmSteps());
            }
            break;
            case 6: {
                setmSteps(getAttack_b_Action().getmSteps());
            }
            break;
            case 20: {
                setmSteps(getBeAttack_a_Action().getmSteps());
            }
            break;
        }

    }

    public PikeAction(PikeAction action) {
        if (action != null)
            setmSteps(action.getmSteps());
    }

//    static PikeAction mStand;

    public static PikeAction getStandAction() {
        PikeAction mStand;

        mStand = new PikeAction(null);
        mStand.addStep(new Step(new int[][]{{145, 50},
                {7, 383}, {192, -2}, {96, 189}, {116, 131}, {144, 71}, {182, 128}, {177, 185},
                {143, 191},
                {117, 269}, {181, 274},
                {84, 399}, {212, 399},}, 4, 0, 0));
        mStand.addStep(new Step(new int[][]{{145, 50},
                {7, 383}, {192, -2}, {96, 189}, {116, 131}, {144, 71}, {182, 128}, {177, 185},
                {143, 191},
                {117, 269}, {181, 274},
                {84, 399}, {212, 399},}, 4, 0, 0));
        return mStand;
    }

    public static PikeAction getRunAction() {
        PikeAction mRun;

        mRun = new PikeAction(null);
//        mRun.addStep(new Step(new int[][]{{172, 74},//��һ��
//                {45, 398}, {178, 28}, {114, 199}, {125, 143}, {165, 107}, {189, 161}, {225, 152},
//                {147, 195},
//                {133, 277}, {152, 291},
//                {117, 399}, {107, 399},}, 1));
//        mRun.addStep(new Step(new int[][]{{195, 84},//�ڶ���
//                {26, 398}, {203, 23}, {116, 206}, {137, 144}, {181, 116}, {194, 171}, {237, 166},
//                {151, 198},
//                {166, 279}, {115, 283},
//                {139, 399}, {66, 384},}, 1));
//        mRun.addStep(new Step(new int[][]{{213, 109},//����
//                {-2, 386}, {263, 34}, {122, 205}, {153, 145}, {198, 132}, {195, 187}, {233, 181},
//                {144, 209},
//                {170, 289}, {15236, 303},
//                {115, 399}, {50, 338},}, 1));


        mRun.addStep(new Step(new int[][]{{225, 131},//���Ĳ�
                {-14, 382}, {258, 54}, {126, 214}, {155, 158}, {207, 151}, {190, 196}, {231, 201},
                {146, 214},
                {145, 308}, {159, 308},
                {67, 399}, {53, 318},}, 1));
        mRun.addStep(new Step(new int[][]{{230, 131},//���岽
                {-15, 378}, {263, 50}, {128, 210}, {158, 154}, {208, 153}, {172, 182}, {219, 199},
                {146, 217},
                {103, 293}, {179, 295},
                {22, 396}, {83, 319},}, 1));
        mRun.addStep(new Step(new int[][]{{227, 119},//����
                {-12, 360}, {267, 32}, {130, 192}, {159, 144}, {209, 139}, {176, 161}, {215, 194},
                {143, 204},
                {90, 270}, {204, 264},
                {-5, 345}, {122, 312},}, 1));
        mRun.addStep(new Step(new int[][]{{230, 113},//���߲�
                {-11, 350}, {267, 22}, {131, 182}, {165, 135}, {209, 132}, {177, 147}, {216, 185},
                {145, 193},
                {83, 239}, {211, 248},
                {-20, 280}, {160, 338},}, 1));
        mRun.addStep(new Step(new int[][]{{229, 110},//�ڰ˲�
                {-9, 350}, {262, 22}, {128, 182}, {165, 130}, {206, 130}, {173, 143}, {213, 184},
                {144, 194},
                {84, 244}, {209, 255},
                {-20, 252}, {217, 375},}, 1));
        mRun.addStep(new Step(new int[][]{{229, 116},//�ھŲ�
                {-9, 356}, {259, 28}, {129, 188}, {164, 139}, {209, 135}, {173, 161}, {211, 196},
                {143, 203},
                {102, 273}, {208, 280},
                {16, 235}, {245, 397},}, 1));
        mRun.addStep(new Step(new int[][]{{226, 125},//��ʮ��
                {-13, 362}, {256, 34}, {127, 194}, {160, 149}, {206, 143}, {172, 182}, {214, 207},
                {143, 211},
                {119, 284}, {196, 292},
                {44, 267}, {243, 399},}, 1));
        mRun.addStep(new Step(new int[][]{{227, 131},//��11��
                {-15, 367}, {253, 39}, {126, 199}, {157, 158}, {206, 153}, {172, 192}, {224, 219},
                {144, 216},
                {139, 298}, {208, 277},
                {26, 243}, {207, 399},}, 1));
        mRun.addStep(new Step(new int[][]{{227, 138},//��12��
                {-15, 373}, {252, 45}, {126, 205}, {157, 164}, {206, 159}, {177, 201}, {237, 221},
                {144, 222},
                {157, 307}, {169, 311},
                {59, 295}, {81, 398},}, 1));
        mRun.addStep(new Step(new int[][]{{226, 125},//��13��
                {-13, 362}, {256, 34}, {127, 194}, {160, 149}, {206, 143}, {199, 206}, {248, 210},
                {143, 211},
                {178, 284}, {117, 293},
                {80, 314}, {35, 399},}, 1));
        mRun.addStep(new Step(new int[][]{{229, 116},//��14��
                {-15, 350}, {256, 22}, {126, 182}, {164, 139}, {209, 135}, {208, 199}, {254, 196},
                {143, 203},
                {200, 260}, {99, 270},
                {121, 336}, {5, 335},}, 1));

        mRun.addStep(new Step(new int[][]{{230, 113},//��15��
                {-11, 350}, {267, 22}, {131, 182}, {165, 135}, {209, 132}, {211, 196}, {255, 185},
                {145, 193},
                {211, 248}, {83, 239},
                {160, 338}, {-20, 280},}, 1));

        mRun.addStep(new Step(new int[][]{{229, 110},//��16��
                {-9, 350}, {262, 22}, {128, 182}, {165, 130}, {206, 130}, {212, 194}, {252, 181},
                {144, 194},
                {209, 255}, {84, 244},
                {217, 375}, {-20, 252},}, 1));

        mRun.addStep(new Step(new int[][]{{229, 116},//��17��
                {-9, 356}, {259, 28}, {129, 188}, {164, 139}, {209, 135}, {207, 198}, {247, 182},
                {143, 203},
                {208, 280}, {99, 270},
                {245, 397}, {6, 248},}, 2));
        return mRun;
    }

    public static PikeAction getJumpAction() {
        PikeAction mJump;

        mJump = new PikeAction(null);
        mJump.addStep(new Step(new int[][]{{191, 124},//��һ��
                {276, 357}, {24, 129}, {153, 243}, {133, 197}, {171, 159}, {159, 202}, {195, 231},
                {135, 245},
                {160, 320}, {205, 292},
                {76, 399}, {180, 399},}, 1, 0, 140));
        mJump.addStep(new Step(new int[][]{{170, 74},//�ڶ���
                {270, 367}, {-9, 38}, {118, 183}, {124, 135}, {162, 101}, {155, 147}, {196, 164},
                {136, 197},
                {163, 286}, {169, 249},
                {114, 392}, {176, 364},}, 3, 0, 0));
        mJump.addStep(new Step(new int[][]{{182, 137},//����
                {51, 451}, {146, 30}, {99, 236}, {127, 189}, {169, 167}, {178, 231}, {215, 206},
                {134, 244},
                {193, 281}, {195, 264},
                {113, 350}, {119, 316},}, 10, 0, 0));
        mJump.addStep(new Step(new int[][]{{182, 137},//����
                {51, 451}, {146, 30}, {99, 236}, {127, 189}, {169, 167}, {178, 231}, {215, 206},
                {134, 244},
                {193, 281}, {195, 264},
                {113, 350}, {119, 316},}, 1, 0, 0));
        return mJump;
    }

    public static PikeAction getJumpDownAction() {
        PikeAction mDown;
        mDown = new PikeAction(null);
        mDown.addStep(new Step(new int[][]{{182, 137},//��һ��
                {51, 451}, {146, 30}, {99, 236}, {127, 189}, {169, 167}, {178, 231}, {215, 206},
                {134, 244},
                {193, 281}, {195, 264},
                {113, 350}, {119, 316},}, 2, 0, 0));
        mDown.addStep(new Step(new int[][]{{170, 74},//�ڶ���
                {60, 398}, {165, -23}, {118, 183}, {124, 135}, {162, 101}, {155, 147}, {196, 164},
                {136, 197},
                {163, 286}, {169, 249},
                {114, 392}, {176, 364},}, 20, 0, 0));
        mDown.addStep(new Step(new int[][]{{170, 74},//�ڶ���
                {60, 398}, {165, -23}, {118, 183}, {124, 135}, {162, 101}, {155, 147}, {196, 164},
                {136, 197},
                {163, 286}, {169, 249},
                {114, 392}, {176, 364},}, 3, 0, 0));
        return mDown;
    }

    public static PikeAction getAttack_a_Action() {
        PikeAction mAttack_a;
        mAttack_a = new PikeAction(null);
        mAttack_a.addStep(new Step(new int[][]{{145, 50},
                {351, 353}, {3, 94}, {125, 184}, {107, 131}, {144, 71}, {182, 128}, {177, 185},
                {143, 191},
                {117, 269}, {181, 274},
                {84, 399}, {212, 399},}, 2, 0, 0));
        mAttack_a.addStep(new Step(new int[][]{{221, 73},
                {386, 229}, {0, 124}, {148, 165}, {161, 99}, {205, 112}, {169, 137}, {213, 158},
                {159, 186},
                {130, 280}, {181, 274},
                {84, 399}, {212, 399},}, 2, 10, 0));
        mAttack_a.addStep(new Step(new int[][]{{145, 50},
                {490, 172}, {70, 172}, {229, 172}, {176, 132}, {144, 71}, {131, 134}, {140, 167},
                {143, 191},
                {130, 280}, {181, 274},
                {84, 399}, {212, 399},}, 1, 0, 0));

        mAttack_a.addStep(new Step(new int[][]{{145, 50},
                {490, 172}, {70, 172}, {229, 172}, {176, 132}, {144, 71}, {131, 137}, {140, 167},
                {143, 191},
                {130, 280}, {181, 274},
                {84, 399}, {212, 399},}, 1, 0, 0));
        mAttack_a.addStep(new Step(new int[][]{{145, 50},
                {490, 172}, {70, 172}, {229, 172}, {176, 132}, {144, 71}, {131, 137}, {140, 167},
                {143, 191},
                {130, 280}, {181, 274},
                {84, 399}, {212, 399},}, 5, 0, 0));
        return mAttack_a;
    }

    public static PikeAction getAttack_b_Action() {
        PikeAction mAttack_b;
        mAttack_b = new PikeAction(null);
        mAttack_b.addStep(new Step(new int[][]{{164, 124},
                {417, 145}, {7, 106}, {127, 119}, {93, 168}, {159, 151}, {198, 210}, {253, 220},
                {150, 255},
                {119, 351}, {228, 300},
                {83, 399}, {228, 399},}, 1, 0, 0));

        mAttack_b.addStep(new Step(new int[][]{{141, 128},
                {382, 386}, {13, 18}, {103, 109}, {60, 153}, {131, 155}, {170, 229}, {224, 228},
                {134, 262},
                {62, 317}, {220, 300},
                {83, 399}, {265, 388},}, 2, 0, 0));
        mAttack_b.addStep(new Step(new int[][]{{141, 156},
                {141, -124}, {224, 255}, {212, 201}, {167, 203}, {117, 182}, {166, 210}, {199, 145},
                {94, 276},
                {51, 338}, {180, 301},
                {70, 399}, {223, 392},}, 2, 0, 0));

        mAttack_b.addStep(new Step(new int[][]{{138, 214},
                {424, 200},  {2, 327}, {69, 306}, {47, 259}, {120, 235}, {173, 268}, {227, 261},
                {77, 310},
                {31, 353}, {163, 314},
                {61, 399}, {229, 399},}, 1, 0, 0));

        mAttack_b.addStep(new Step(new int[][]{{127, 233},
                {423, 357},  {3, 315}, {59, 319}, {37, 269}, {108, 252}, {159, 291}, {227, 336},
                {68, 328},
                {30, 362}, {157, 321},
                {66, 399}, {228, 399},}, 2, 0, 0));
        mAttack_b.addStep(new Step(new int[][]{{138, 214},
                {424, 200},  {2, 327}, {69, 306}, {47, 259}, {120, 235}, {173, 268}, {227, 261},
                {77, 310},
                {31, 353}, {163, 314},
                {61, 399}, {229, 399},}, 1, 0, 0));
        mAttack_b.addStep(new Step(new int[][]{{138, 214},
                {424, 200},  {2, 327}, {69, 306}, {47, 259}, {120, 235}, {173, 268}, {227, 261},
                {77, 310},
                {31, 353}, {163, 314},
                {61, 399}, {229, 399},}, 2, 0, 0));
        return mAttack_b;
    }

    public static PikeAction getBeAttack_a_Action() {
        PikeAction BeAttack_a;
        BeAttack_a = new PikeAction(null);
        BeAttack_a.addStep(new Step(new int[][]{{130, 67},
                {311, 399}, {4, 181}, {99, 247}, {93, 168}, {125, 100}, {144, 165}, {171, 220},
                {131, 206},
                {167, 294}, {144, 305},
                {177, 399}, {106, 395},}, 7, -4, 0));
        BeAttack_a.addStep(new Step(new int[][]{{130, 67},
                {311, 399}, {4, 181}, {99, 247}, {93, 168}, {125, 100}, {144, 165}, {171, 220},
                {131, 206},
                {167, 294}, {144, 305},
                {177, 399}, {106, 395},}, 3, -4, 0));
//        BeAttack_a.addStep(new Step(new int[][]{{221, 73},
//                {386, 229},{0, 124} ,{148, 165}, {161, 99}, {205, 112}, {169, 137}, {213, 158},
//                {159, 186},
//                {130, 280}, {181, 274},
//                {84, 399}, {212, 399},}, 2,10,0));
        return BeAttack_a;
    }


    public static PikeAction getBeAttack_d_Action() {
        PikeAction BeAttack_d;
        BeAttack_d = new PikeAction(null);
        BeAttack_d.addStep(new Step(new int[][]{{130, 67},
                {311, 399}, {4, 181}, {99, 247}, {93, 168}, {125, 100}, {144, 165}, {171, 220},
                {131, 206},
                {167, 294}, {144, 305},
                {177, 399}, {106, 395},}, 7, -4, 0));
        BeAttack_d.addStep(new Step(new int[][]{{130, 67},
                {311, 399}, {4, 181}, {99, 247}, {93, 168}, {125, 100}, {144, 165}, {171, 220},
                {131, 206},
                {167, 294}, {144, 305},
                {177, 399}, {106, 395},}, 3, -4, 0));
        return BeAttack_d;
    }

    private void addStep(Step step) {
        getmSteps().add(step);
    }

    @Override
    public List<Step> getmSteps() {
        return mSteps;
    }

    public void setmSteps(List<Step> mSteps) {
        this.mSteps = mSteps;
    }

    @Override
    public int getActontype() {
        return mActtype;
    }

    @Override
    public void setDirection(int d) {
        mDirection = d;
        if (mDirection == 9) {
            for (Step s : mSteps) {
                s.mZ = 30;
            }
        }
        if (mDirection == 7) {
            for (Step s : mSteps) {
                s.mZ = -30;
            }
        }
        if (mDirection == 8) {
            for (Step s : mSteps) {
                s.mZ = 0;
                s.mX = 0;
            }
        }
    }

    @Override
    public int getDirection() {
        return mDirection;
    }

}