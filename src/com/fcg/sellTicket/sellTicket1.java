package com.fcg.sellTicket;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class sellTicket1 {
    public static void main(String[] args) {
        sellTicket01 sellTicket01 = new sellTicket01();
        sellTicket01 sellTicket02 = new sellTicket01();
        sellTicket01 sellTicket03 = new sellTicket01();
        sellTicket01.start();
        sellTicket02.start();
        sellTicket03.start();
    }
}

class sellTicket01 extends Thread
{
    private static int  ticketnumm = 100;
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