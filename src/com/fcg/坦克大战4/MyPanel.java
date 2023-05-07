package com.fcg.坦克大战4;

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
public class MyPanel extends JPanel implements KeyListener, Runnable {
    //定义我们的坦克
    MyTank myTank = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();//存放敌人坦克的集合，用线程安全
    //定义一个vector，用于存放炸弹
    // 当 子弹击中坦克是加入炸弹

    Vector<Bomb> bombs = new Vector<>();

    int enemyCount = 3;

    Image image1 = null;
    Image image2 = null;
    Image image3 = null;

    //定义三张炸弹图片，用于显示爆炸
    public MyPanel() {
        myTank = new MyTank(100, 100, 10);//初始化我方坦克

        for (int i = 0; i < enemyCount; i++) {
            //创建敌方坦克
            EnemyTank enemyTank = new EnemyTank(100 + (i * 50), 300, 7);
            enemyTank.setDirect(2);//设置敌方坦克的炮管朝向
            //创建敌方坦克后，给敌方坦克加入子弹
            //启动敌人坦克线程
            Thread thread1 = new Thread(enemyTank);
            thread1.start();
            Shoot shoot = new Shoot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            //将子弹添加到敌方坦克的子弹集合
            enemyTank.shoots.add(shoot);
            //启动子弹线程
            Thread thread = new Thread(shoot);
            thread.start();
            enemyTanks.add(enemyTank);//添加敌方坦克到集合
        }
        //初始化图片对象
        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/20190215210241592.gif"));
        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/20190215210304713.gif"));
        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/20190215210323305.gif"));

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);

        //画出坦克-封装成方法
        drawTank(myTank.getX(), myTank.getY(), g, myTank.getDirect(), myTank.getType());
        //判断子弹状态，是否要画出
        if (myTank.shoot != null && myTank.shoot.isLive() == true) {
            g.fillOval(myTank.shoot.getX() - 2, myTank.shoot.getY() - 2, 4, 4);
        }

        //如果bombs集合中有对象，就画出
        for(int i = 0 ; i < bombs.size() ; i++)
        {
            //取出炸弹
            Bomb bomb = bombs.get(i);
            //根据当前bomb的life值画图片
            if(bomb.life > 6)
            {
                g.drawImage(image1 , bomb.x , bomb.y , 60 , 60 , this);
            }
            else if(bomb.life > 3)
            {
                g.drawImage(image2 , bomb.x , bomb.y , 60 , 60 , this);
            }
            else
            {
                g.drawImage(image3 , bomb.x , bomb.y , 60 , 60 , this);
            }
            //让炸弹的生命值减少
            bomb.lifeDown();
            //如果bomb life为0 就删除
            if(bomb.life == 0)
            {
                bombs.remove(bomb);
            }
        }
        //画出敌方坦克
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            //判断敌人坦克是否存活,存活才画
            if (enemyTank.isLive) {
                drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 1);
            }

            //画出敌方坦克子弹
            for (int j = 0; j < enemyTank.shoots.size(); j++) {
                Shoot shoot = enemyTank.shoots.get(j);
                //绘制子弹
                if (shoot.isLive()) {
                    g.fillOval(shoot.getX() - 2, shoot.getY() - 2, 4, 4);
                } else {
                    //子弹无效，删除
                    enemyTank.shoots.remove(shoot);
                }
            }
        }
    }


    //编写方法画出坦克

    /**
     * @param x      坦克位置的横坐标
     * @param y      坦克位置的纵坐标
     * @param g      画笔
     * @param direct 坦克的方向
     * @param type   坦克的状态
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        switch (type) {
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
        switch ((direct)) {
            case 0://初始方向，炮管朝上
            {
                g.fill3DRect(x, y, 10, 60, false);//坦克左边履带
                g.fill3DRect(x + 30, y, 10, 60, false);//坦克右边履带
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//坦克身体
                g.fillOval(x + 10, y + 20, 20, 20);//坦克的盖子
                g.drawLine(x + 20, y + 30, x + 20, y);
                break;
            }
            case 1://炮管朝右
            {
                g.fill3DRect(x, y, 60, 10, false);//坦克左边履带
                g.fill3DRect(x, y + 30, 60, 10, false);//坦克右边履带
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//坦克身体
                g.fillOval(x + 20, y + 10, 20, 20);//坦克的盖子
                g.drawLine(x + 30, y + 20, x + 60, y + 20);
                break;
            }
            case 2://向下
            {
                g.fill3DRect(x, y, 10, 60, false);//坦克左边履带
                g.fill3DRect(x + 30, y, 10, 60, false);//坦克右边履带
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//坦克身体
                g.fillOval(x + 10, y + 20, 20, 20);//坦克的盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 60);
                break;
            }
            case 3://向左
            {
                g.fill3DRect(x, y, 60, 10, false);//坦克左边履带
                g.fill3DRect(x, y + 30, 60, 10, false);//坦克右边履带
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//坦克身体
                g.fillOval(x + 20, y + 10, 20, 20);//坦克的盖子
                g.drawLine(x + 30, y + 20, x, y + 20);
                break;
            }
        }
    }

    //编写方法，判断我方的子弹是否击中敌方坦克
    public void hitEnemyTank(Shoot s, EnemyTank enemyTank) {
        //判断s是否击中坦克，即子弹的坐标是否在坦克的图形坐标范围内
        switch (enemyTank.getDirect()) {
            case 0://上
            case 2://下
            {
                if (s.getX() > enemyTank.getX() && s.getX() < enemyTank.getX() + 40
                        && s.getY() > enemyTank.getY() && s.getY() < enemyTank.getY() + 60) {
                    s.setLive(false);
                    enemyTank.isLive = false;
                    //击中坦克时，就把敌人的坦克从集合中删除
                    enemyTanks.remove(enemyTank);
                    //创建bomb对象，加入bombs集合
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
            }
            case 1:
            case 4: {
                if (s.getX() > enemyTank.getX() && s.getX() < enemyTank.getX() + 60
                        && s.getY() > enemyTank.getY() && s.getY() < enemyTank.getY() + 40) {
                    s.setLive(false);
                    enemyTank.isLive = false;
                    //创建bomb对象，加入bombs集合
                    Bomb bomb = new Bomb(enemyTank.getX(), enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            myTank.setDirect(0);//按下W键时坦克朝上
            myTank.removeW();//坦克向上移动
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            myTank.setDirect(2);//按下S键时坦克朝下
            myTank.removeS();//坦克向下移动
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            myTank.setDirect(3);//按下A键时坦克朝左
            myTank.removeA();//坦克向左移动
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            myTank.setDirect(1);//按下D键时坦克朝右
            myTank.removeD();//坦克向右移动
        } else if (e.getKeyCode() == KeyEvent.VK_J) {
            myTank.shotEnemyTank();
        }
        this.repaint();//让面板重绘
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            this.repaint();//不断绘制整个面板就能不断的绘制子弹
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //判断是否被击中
            if (myTank.shoot != null && myTank.shoot.isLive())//子弹存活
            {
                //遍历所有敌人坦克
                for (int i = 0; i < enemyTanks.size(); i++) {
                    EnemyTank enemyTank = enemyTanks.get(i);
                    hitEnemyTank(myTank.shoot, enemyTank);
                }
            }
            this.repaint();
        }
    }
}
