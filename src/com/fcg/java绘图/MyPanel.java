package com.fcg.java绘图;

import javax.swing.*;
import java.awt.*;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class MyPanel extends JPanel {
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        //画一个圆
       // g.drawOval(40 , 40 , 40 , 40);
       // System.out.println("paint被调用");
//        g.setColor(Color.blue);
//        g.fillRect(20 , 20 ,50 , 50);
        //画图片

        //先画一个黑色的矩形背景
        g.setColor(Color.black);
        g.fillRect(150 , 150  , 200 , 200);
        //画蓝色的坦克底座
        g.setColor(Color.cyan);
        g.fillRect(220 , 210 , 60 , 80);
        g.setColor(Color.blue);
        g.drawOval(230 , 230 , 30 , 30);

//

    }
}
