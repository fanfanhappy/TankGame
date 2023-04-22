package com.fcg.坦克大战2;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class EnemyTank extends Tank{
    private int type = 1;

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
