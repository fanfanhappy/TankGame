package com.fcg.坦克大战4;

import java.util.Vector;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class EnemyTank extends Tank {
    private int type = 1;
    //给敌方坦克创建一个子弹集合，方便后续可发射多颗子弹
    Vector<Shoot> shoots = new Vector<>();
    boolean isLive = true;

    public EnemyTank(int x, int y, int speed) {
        super(x, y, speed);
    }

    public EnemyTank() {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
