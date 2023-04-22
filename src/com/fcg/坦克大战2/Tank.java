package com.fcg.坦克大战2;

/**
 * @author 好女人蕾赛
 * @version 1.0
 * 所有坦克的父类
 */
public class Tank {
    private int x;//坦克的横坐标
    private int y;//坦克的纵坐标、
    private int direct;//坦克的朝向
    private int speed;//坦克的移动速度

    public Tank(int x, int y, int speed) {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    public Tank() {

    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
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

    //坦克向上移动
    public void removeW()
    {
        y -= speed;
    }

    //坦克向下移动
    public void removeS()
    {
        y += speed;
    }

    //坦克向左移动
    public void removeA()
    {
        x -= speed;
    }

    //坦克向右移动
    public void removeD()
    {
        x += speed;
    }


}
