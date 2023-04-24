package com.fcg.坦克大战3;

/**
 * @author 好女人蕾赛
 * @version 1.0
 * 要使用的坦克
 */
public class MyTank extends Tank {
    private int type = 0;

    public MyTank(int x, int y, int speed) {
        super(x, y, speed);
    }

    public MyTank() {
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
