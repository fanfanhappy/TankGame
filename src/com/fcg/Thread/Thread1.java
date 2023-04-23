package com.fcg.Thread;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class Thread1 {
    public static void main(String[] args) throws InterruptedException {
        Dog dog = new Dog();
        dog.start();
        for(int i = 0 ; i < 10 ; i++)
        {
            Thread.sleep(1000);
            System.out.println("main" + i);
        }
    }
}

class Dog extends Thread
{
    @Override
    public void run() {
        int count = 0;
        while(true)
        {
            count++;
            System.out.println("小狗叫" + count);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(count == 20)
            {
                break;
            }
        }
    }
}