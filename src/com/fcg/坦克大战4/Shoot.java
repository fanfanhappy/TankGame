package com.fcg.坦克大战4;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class Shoot extends Thread{
    private int x;//子弹的横坐标
    private int y;//子弹的纵坐标
    private int direct;//子弹的射击方向
    private int shootspeed = 15;//子弹的射击速度
    private boolean isLive = true;//子弹的存货状态

    /*
    子弹的位置的改变作为一个线程
     */

    public Shoot(int x , int y , int direct)
    {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public boolean isLive() {
        return isLive;
    }

    public void setLive(boolean live) {
        isLive = live;
    }

    @Override
    public void run() {
        //循环，不断改变子弹的位置（射击）
        while(true)
        {
            //线程休眠，即子弹发射案件个
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (direct)
            {
                case 0://子弹朝上
                {
                    y -= shootspeed;
                    break;
                }
                case 1://子弹朝右
                {
                    x += shootspeed;
                    break;
                }
                case 2://向下
                {
                    y += shootspeed;
                    break;
                }
                case 3://向左
                {
                    x -= shootspeed;
                    break;
                }
            }
            //测试子弹的发射位置
            System.out.println("x=" + x + "    y=" + y);
            //判断子弹的销毁,判断坐标是否到边界
            if(!(x >= 0 && x <= 1000 && y >= 0 && y <= 750 && isLive))
            {
                isLive = false;
                break;
            }
        }
    }
}
