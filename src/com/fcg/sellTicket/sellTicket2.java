package com.fcg.sellTicket;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class sellTicket2 {
    public static void main(String[] args) {
        sellTicket02 sellTicket01 = new sellTicket02();
        sellTicket02 sellTicket02 = new sellTicket02();
        sellTicket02 sellTicket03 = new sellTicket02();
        Thread thread = new Thread(sellTicket01);
        Thread thread1 = new Thread(sellTicket02);
        Thread thread2 = new Thread(sellTicket03);
        thread.start();
        thread1.start();
        thread2.start();
    }
}

class sellTicket02 implements Runnable
{

    private static int ticketnumm = 100;
    @Override
    public void run() {
        while(true)
        {
            if(ticketnumm <= 0)
            {
                System.out.println("票已售完");
                break;
            }

            //判断票数后休眠
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //开始卖票
            System.out.println(Thread.currentThread().getName() + "卖了一张票\t" + "剩余票数：" + (--ticketnumm));
        }
    }
}