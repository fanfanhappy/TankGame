package com.fcg.线程;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class HomeWork {
    public static void main(String[] args) {
        Method1 method1 = new Method1();
        Thread thread = new Thread(method1);
        Method2 method2 = new Method2(method1);
        Thread thread1 = new Thread(method2);
        thread.start();
        thread1.start();

    }
}

class Method1 implements Runnable
{
    private boolean loop = true;

    public boolean isLoop() {
        return loop;
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }

    //打印随机数方法
    public void print() throws InterruptedException {
        while(loop)
        {
            System.out.println((int)(Math.random()*100 + 1));
            Thread.sleep(2000);
        }
    }
    @Override
    public void run() {
        try {
            print();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class Method2 implements Runnable
{
    private Method1 m = null;
    Scanner scanner = new Scanner(System.in);
    public Method2(Method1 m) {
        this.m = m;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);

        while(true)
        {
            System.out.println("请输入Q : ");
            char num = scanner.next().toUpperCase().charAt(0);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(num == 'Q')
            {
                System.out.println("Method1退出");
                m.setLoop(false);
            }
            break;
        }

    }
}