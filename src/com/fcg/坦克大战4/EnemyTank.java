package com.fcg.坦克大战4;

import java.util.Vector;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class EnemyTank extends Tank implements Runnable{
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

    @Override
    public void run() {
        while(true)
        {
            //根据敌人的坦克方向来继续移动
            switch (getDirect())
            {
                case 0://向上

                    //不要立马移动
                    for(int i = 0 ; i < 30 ; i ++)
                    {
                        //休眠50毫秒
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        removeW();
                    }
                    break;

                case 1://向右
                    for(int i = 0 ; i < 30 ; i ++)
                    {
                        //休眠50毫秒
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        removeD();
                    }
                    break;

                case 2://向下
                    for(int i = 0 ; i < 30 ; i ++)
                    {
                        //休眠50毫秒
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        removeS();
                    }
                    break;

                case 3://向左
                    for(int i = 0 ; i < 30 ; i ++)
                    {
                        //休眠50毫秒
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        removeA();
                    }
                    break;

            }

            //随机改变方向
            setDirect((int)(Math.random() * 4));
            //坦克被击中时退出线程
            if(!isLive)
            {
                break;
            }
        }
    }
}
