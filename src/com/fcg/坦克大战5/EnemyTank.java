package com.fcg.坦克大战5;

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
    //拿到敌人坦克集合
    Vector<EnemyTank> enemyTanks = new Vector<>();

    public EnemyTank(int x, int y, int speed) {
        super(x, y, speed);
    }

    public EnemyTank() {
    }

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    //判断当前坦克和其他的敌人坦克碰撞情况
    public boolean isTouchEnemTank()
    {
        //判断当前敌人坦克方向
        switch(this.getDirect())
        {
            case 0://上
            {
                //遍历敌人坦克集合
                for(int i = 0 ; i < enemyTanks.size() ; i++)
                {
                    //从vector中啊u出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if(this != enemyTank)
                    {
                        //如果敌人坦克时上下
                        if(enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2)
                        {
                            //当前坦克上面两个角是否在判断坦克范围
                            //1，判断左上角
                            if(this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60)
                            {
                                return true;
                            }
                            //2，判断右上角
                            if(this.getX() + 40>= enemyTank.getX()
                                    && this.getX() + 40<= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60)
                            {
                                return true;
                            }

                        }
                        //如果敌人坦克是左右
                        if(enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3)
                        {
                            //左上角
                            if(this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40)
                            {
                                return true;
                            }
                            //右上角
                            if(this.getX() + 40>= enemyTank.getX()
                                    && this.getX() + 40<= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40)
                            {
                                return true;
                            }
                        }
                    }
                }
                break;
            }
            case 1://左
            {
                //遍历敌人坦克集合
                for(int i = 0 ; i < enemyTanks.size() ; i++)
                {
                    //从vector中啊u出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if(this != enemyTank)
                    {
                        //如果敌人坦克时上下
                        if(enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2)
                        {
                            //当前坦克上面两个角是否在判断坦克范围
                            //1，判断左上角
                            if(this.getX() + 60>= enemyTank.getX()
                                    && this.getX() + 60<= enemyTank.getX() + 40
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 60)
                            {
                                return true;
                            }
                            //2，判断右上角
                            if(this.getX() + 60>= enemyTank.getX()
                                    && this.getX() + 60<= enemyTank.getX() + 40
                                    && this.getY() +40>= enemyTank.getY()
                                    && this.getY() +40<= enemyTank.getY() + 60)
                            {
                                return true;
                            }

                        }
                        //如果敌人坦克是左右
                        if(enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3)
                        {
                            //左上角
                            if(this.getX() + 60>= enemyTank.getX()
                                    && this.getX() + 60<= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40)
                            {
                                return true;
                            }
                            //右上角
                            if(this.getX() + 60>= enemyTank.getX()
                                    && this.getX() + 60<= enemyTank.getX() + 60
                                    && this.getY() + 40>= enemyTank.getY()
                                    && this.getY() + 40<= enemyTank.getY() + 40)
                            {
                                return true;
                            }
                        }
                    }
                }
                break;
            }
            case 2://下
            {
                //遍历敌人坦克集合
                for(int i = 0 ; i < enemyTanks.size() ; i++)
                {
                    //从vector中啊u出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if(this != enemyTank)
                    {
                        //如果敌人坦克时上下
                        if(enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2)
                        {
                            //当前坦克上面两个角是否在判断坦克范围
                            //1，判断左上角
                            if(this.getX() + 40>= enemyTank.getX()
                                    && this.getX() + 40<= enemyTank.getX() + 40
                                    && this.getY() + 60>= enemyTank.getY()
                                    && this.getY() + 60<= enemyTank.getY() + 60)
                            {
                                return true;
                            }
                            //2，判断右上角
                            if(this.getX() + 60>= enemyTank.getX()
                                    && this.getX() + 60<= enemyTank.getX() + 40
                                    && this.getY() +40>= enemyTank.getY()
                                    && this.getY() +40<= enemyTank.getY() + 60)
                            {
                                return true;
                            }

                        }
                        //如果敌人坦克是左右
                        if(enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3)
                        {
                            //左上角
                            if(this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() + 60>= enemyTank.getY()
                                    && this.getY() + 60<= enemyTank.getY() + 40)
                            {
                                return true;
                            }
                            //右上角
                            if(this.getX() + 40>= enemyTank.getX()
                                    && this.getX() + 40<= enemyTank.getX() + 60
                                    && this.getY() + 60>= enemyTank.getY()
                                    && this.getY() + 60<= enemyTank.getY() + 40)
                            {
                                return true;
                            }
                        }
                    }
                }
                break;
            }
            case 3://右
            {
                //遍历敌人坦克集合
                for(int i = 0 ; i < enemyTanks.size() ; i++)
                {
                    //从vector中啊u出一个敌人坦克
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比较
                    if(this != enemyTank)
                    {
                        //如果敌人坦克时上下
                        if(enemyTank.getDirect() == 0 || enemyTank.getDirect() == 2)
                        {
                            //当前坦克上面两个角是否在判断坦克范围
                            //1，判断左上角
                            if(this.getX() + 40>= enemyTank.getX()
                                    && this.getX() + 40<= enemyTank.getX() + 40
                                    && this.getY() + 60>= enemyTank.getY()
                                    && this.getY() + 60<= enemyTank.getY() + 60)
                            {
                                return true;
                            }
                            //2，判断右上角
                            if(this.getX() + 60>= enemyTank.getX()
                                    && this.getX() + 60<= enemyTank.getX() + 40
                                    && this.getY() +40>= enemyTank.getY()
                                    && this.getY() +40<= enemyTank.getY() + 60)
                            {
                                return true;
                            }

                        }
                        //如果敌人坦克是左右
                        if(enemyTank.getDirect() == 1 || enemyTank.getDirect() == 3)
                        {
                            //左上角
                            if(this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() >= enemyTank.getY()
                                    && this.getY() <= enemyTank.getY() + 40)
                            {
                                return true;
                            }
                            //右上角
                            if(this.getX() >= enemyTank.getX()
                                    && this.getX() <= enemyTank.getX() + 60
                                    && this.getY() + 40>= enemyTank.getY()
                                    && this.getY() + 40<= enemyTank.getY() + 40)
                            {
                                return true;
                            }
                        }
                    }
                }
                break;
            }

        }
        return false;
    }

    @Override
    public void run() {
        while(true)
        {
            //如果子弹集合里没有子弹了就新创建一个
            if(isLive && shoots.size() < 3)
            {
                Shoot s = null;
                //判断坦克的方向创建对于的子弹
                switch(getDirect())
                {

                    case 0://朝上
                    {
                        s = new Shoot(getX() + 20 , getY() , 0);
                        break;

                    }
                    case 1:
                    {
                        s = new Shoot(getX() + 60 , getY() + 20 , 1);
                        break;
                    }
                    case 2:
                    {
                        s = new Shoot(getX() + 20 , getY() + 60, 2);
                        break;
                    }
                    case 3:
                    {
                        s = new Shoot(getX() , getY() + 20 , 3);
                        break;
                    }
                }
                shoots.add(s);
                //启动线程
                new Thread(s).start();

            }
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
                        if(getY() > 0 && !isTouchEnemTank())
                        {
                            removeW();
                        }

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
                        if(getX() + 60 < 1000 && !isTouchEnemTank())
                        {
                            removeD();
                        }

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
                        if(getY() + 60 < 750 && !isTouchEnemTank())
                        {
                            removeS();
                        }

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
                        if(getX() > 0 && !isTouchEnemTank())
                        {
                            removeA();
                        }

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
