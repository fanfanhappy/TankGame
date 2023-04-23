package com.fcg.Thread;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class Thread2 {
    public static void main(String[] args) throws InterruptedException {
        Cat cat = new Cat();
        Thread thread = new Thread(cat);
        thread.start();
        for(int i = 0 ; i < 10 ; i++)
        {
            System.out.println("main线程" + i);
            Thread.sleep(1000);
        }
    }
}

class Cat implements Runnable
{

    @Override
    public void run() {
        int count = 0;
        while(true)
        {
            count++;
            System.out.println("cat线程" + count);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}