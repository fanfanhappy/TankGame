package com.fcg.java绘图;

import javax.swing.*;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class DrawCircle extends JFrame {
    private MyPanel mp = null;

    //构造器
    public DrawCircle()
    {
        //初始化面板
        mp = new MyPanel();
        //把面板放入框架
        this.add(mp);
        //设置窗口大小
        this.setSize(500 , 500);
        //当点击x时，程序完全推出
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //可以显示窗口
        this.setVisible(true);
    }
}
