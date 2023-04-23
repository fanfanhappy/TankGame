package com.fcg.坦克大战2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author 好女人蕾赛
 * @version 1.0
 * 坦克大招的绘图区域
 */
//实现KeyListener接口实现监听
public class MyPanel extends JPanel implements KeyListener {
    //定义我们的坦克
    MyTank myTank =null;
    Vector<EnemyTank> enemyTanks = new Vector<>();//存放敌人坦克的集合，用线程安全
    int enemyCount = 3;

    public MyPanel()
    {
        myTank = new MyTank(100,100 , 10);//初始化我方坦克
        for(int i = 0 ; i < enemyCount ; i++)
        {
            EnemyTank enemyTank = new EnemyTank(100 + (i * 50), 300, 10);
            enemyTank.setDirect(2);
            enemyTanks.add(enemyTank);

        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);

        //画出坦克-封装成方法
        drawTank(myTank.getX(),myTank.getY(),g,myTank.getDirect() , myTank.getType());
        //画出敌方坦克
        for(EnemyTank o : enemyTanks)
        {
            drawTank(o.getX() , o.getY() , g , o.getDirect() , o.getType());
        }
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
        //direct
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
            case 1://炮管朝右
            {
                g.fill3DRect(x,y,60,10,false);//坦克左边履带
                g.fill3DRect(x , y + 30, 60 , 10 ,false);//坦克右边履带
                g.fill3DRect(x + 10 , y + 10 , 40 , 20 , false);//坦克身体
                g.fillOval(x + 20 , y + 10 , 20 , 20);//坦克的盖子
                g.drawLine(x + 30 , y + 20 , x + 60 , y + 20);
                break;
            }
            case 2://向下
            {
                g.fill3DRect(x,y,10,60,false);//坦克左边履带
                g.fill3DRect(x + 30 , y , 10 , 60 ,false);//坦克右边履带
                g.fill3DRect(x + 10 , y + 10 , 20 , 40 , false);//坦克身体
                g.fillOval(x + 10 , y + 20 , 20 , 20);//坦克的盖子
                g.drawLine(x + 20 , y + 30 , x + 20 , y + 60);
                break;
            }
            case 3://向左
            {
                g.fill3DRect(x,y,60,10,false);//坦克左边履带
                g.fill3DRect(x , y + 30, 60 , 10 ,false);//坦克右边履带
                g.fill3DRect(x + 10 , y + 10 , 40 , 20 , false);//坦克身体
                g.fillOval(x + 20 , y + 10 , 20 , 20);//坦克的盖子
                g.drawLine(x + 30 , y + 20 , x , y + 20);
                break;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_W)
        {
            myTank.setDirect(0);//按下W键时坦克朝上
            myTank.removeW();//坦克向上移动
        }else if(e.getKeyCode() == KeyEvent.VK_S)
        {
            myTank.setDirect(2);//按下S键时坦克朝下
            myTank.removeS();//坦克向下移动
        }else if(e.getKeyCode() == KeyEvent.VK_A)
        {
            myTank.setDirect(3);//按下A键时坦克朝左
            myTank.removeA();//坦克向左移动
        }else if(e.getKeyCode() == KeyEvent.VK_D)
        {
            myTank.setDirect(1);//按下D键时坦克朝右
            myTank.removeD();//坦克向右移动
        }
        this.repaint();//让面板重绘
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
