package com.fcg.sellTicket;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class ThreadMethod {
    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        Thread thread = new Thread(t1);


        for(int i = 0 ; i< 20 ; i++)
        {
            System.out.println("hi" + i);
            Thread.sleep(1000);
            if(i == 5)
            {
                thread.start();
                thread.join();
                System.out.println("子线程结束");
            }
        }
        System.out.println("主线程结束");
    }
}


class T1 implements Runnable
{
    int count = 0;
    @Override
    public void run() {
        while(true)
        {
            count++;
            System.out.println("hello" + count);
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