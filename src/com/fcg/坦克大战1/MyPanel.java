package com.fcg.坦克大战1;

import javax.swing.*;
import java.awt.*;

/**
 * @author 好女人蕾赛
 * @version 1.0
 * 坦克大招的绘图区域
 */
public class MyPanel extends JPanel {
    //定义我们的坦克
    MyTank myTank =null;

    public MyPanel()
    {
        myTank = new MyTank(100,100);//初始化坦克
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);

        //画出坦克-封装成方法
        drawTank(myTank.getX(),myTank.getY(),g,0,0);
    }

    //编写方法画出坦克
    /**
     *
     * @param x 坦克位置的横坐标
     * @param y 坦克位置的纵坐标
     * @param g 画笔
     * @param direct 坦克的方向
     * @param type 坦克的状态
     */
    public void drawTank(int x , int y , Graphics g , int direct , int type)
    {
        switch(type)
        {
            case 0://我们的坦克
            {
                //设置我们的坦克的颜色
                g.setColor(Color.cyan);
                break;
            }
            case 1://敌人坦克
            {
                //设置敌人坦克的颜色
                g.setColor(Color.ORANGE);
                break;
            }
        }

        //根据坦克的方向绘制坦克
        switch ((direct))
        {
            case 0://初始方向，炮管朝上
            {
                g.fill3DRect(x,y,10,60,false);//坦克左边履带
                g.fill3DRect(x + 30 , y , 10 , 60 ,false);//坦克右边履带
                g.fill3DRect(x + 10 , y + 10 , 20 , 40 , false);//坦克身体
                g.fillOval(x + 10 , y + 20 , 20 , 20);//坦克的盖子
                g.drawLine(x + 20 , y + 30 , x + 20 , y);
                break;
            }
        }
    }
}
