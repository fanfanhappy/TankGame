package com.fcg.坦克大战2;

import javax.swing.*;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class MyFrame extends JFrame {
    MyPanel mp = null;

    //初始化框架（地图）
    public MyFrame()
    {
        mp = new MyPanel();
        //把游戏面板放入框架，也就是游戏的绘图区域
        this.add(mp);
        //设置区域大小
        this.setSize(1000,750);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
