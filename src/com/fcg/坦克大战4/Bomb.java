package com.fcg.坦克大战4;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class Bomb {
    int x ;//炸弹的x坐标
    int y;//炸弹的y坐标
    int life = 39;//炸弹的生命周期
    boolean isLive = true;//炸弹是否存活

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //减少生命值
    public void lifeDown()
    {
        if(life > 0)
        {
            life--;
        }
        else
        {
            isLive = false;
        }
    }
}
