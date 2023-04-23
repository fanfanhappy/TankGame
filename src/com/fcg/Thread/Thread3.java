package com.fcg.Thread;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class Thread3 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        Thread thread = new Thread(t1);
        Thread thread1 = new Thread(t2);
        thread.start();
        thread1.start();
    }
}

class T1 implements Runnable
{
    @Override
    public void run() {
        int count = 0;
        while(true)
        {
            count++;
            System.out.println("hello world");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count == 10)
            {
                break;
            }
        }
    }
}

class T2 implements Runnable
{
    @Override
    public void run() {
        int count = 0;
        while(true)
        {
            count++;
            System.out.println("hi");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count == 5)
            {
                break;
            }
        }
    }
}