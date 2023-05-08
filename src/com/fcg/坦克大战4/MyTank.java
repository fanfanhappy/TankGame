package com.fcg.坦克大战4;

import java.util.Vector;

/**
 * @author 好女人蕾赛
 * @version 1.0
 * 要使用的坦克
 */
public class MyTank extends Tank {
    private int type = 0;
    Shoot shoot = null;
    Vector<Shoot> shoots = new Vector<>();
    boolean isLive = true;

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

    //坦克射击
    public void shotEnemyTank()
    {
        if(shoots.size() == 5)
        {
            return;
        }

        //根据坦克的位置确定子弹位置
        switch(getDirect())
        {

            case 0://朝上
            {
                shoot = new Shoot(getX() + 20 , getY() , 0);
                break;

            }
            case 1:
            {
                shoot = new Shoot(getX() + 60 , getY() + 20 , 1);
                break;
            }
            case 2:
            {
                shoot = new Shoot(getX() + 20 , getY() + 60, 2);
                break;
            }
            case 3:
            {
                shoot = new Shoot(getX() , getY() + 20 , 3);
                break;
            }
        }

        //将子弹加入集合
        shoots.add(shoot);
        //启动线程
        Thread thread = new Thread(shoot);
        thread.start();
    }
}
