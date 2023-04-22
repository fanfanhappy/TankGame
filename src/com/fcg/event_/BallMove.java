package com.fcg.event_;

import javafx.scene.input.KeyCode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class BallMove {
    public static void main(String[] args) {
        new MyFarm();

    }
}

class MyPanel extends JPanel implements KeyListener
{
    int x = 100;
    int y = 100;
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillOval(x , y , 20 , 20);
    }

    //有字符输出时就会被触发
    @Override
    public void keyTyped(KeyEvent e) {

    }

    //当某个按键被按下时会被触发
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            y -= 2;
        } else if(e.getKeyCode() == KeyEvent.VK_DOWN)
        {
            y += 2;
        }else if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            x -= 2;
        }else if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            x += 2;
        }
        this.repaint();
    }

    //当某个按键被松开时会被触发
    @Override
    public void keyReleased(KeyEvent e) {

    }
}

class MyFarm extends JFrame
{
    MyPanel myPanel = null;

    public MyFarm()
    {
        myPanel = new MyPanel();
        this.add(myPanel);
        this.setSize(400 , 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(myPanel);
        this.setVisible(true);
    }


}
