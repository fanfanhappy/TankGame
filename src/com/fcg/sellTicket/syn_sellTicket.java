package com.fcg.sellTicket;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class syn_sellTicket {
    public static void main(String[] args) {
        syn_sellTicket02 syn_sellTicket01 = new syn_sellTicket02();
//        syn_sellTicket02 syn_sellTicket02 = new syn_sellTicket02();
//        syn_sellTicket02 syn_sellTicket03 = new syn_sellTicket02();
        Thread thread = new Thread(syn_sellTicket01);
        Thread thread1 = new Thread(syn_sellTicket01);
        Thread thread2 = new Thread(syn_sellTicket01);
        thread.start();
        thread1.start();
        thread2.start();
    }
}

class syn_sellTicket02 implements Runnable
{

    private static int ticketnumm = 1000;
    /**
     * 一开始票数设置为100时感觉没有体现出多线程的现象？
     * 因为我设置的票数太少了，当三个线程进来时，由于票数太少了，三个线程争夺锁的时候，每次都被线程0得到，所以
     * 就好像线程0一直在卖票，因为这个原因是的三个线程没有交替执行
     */
    boolean  loop = true;
    public synchronized void sell()
    {
        if(ticketnumm <= 0)
        {
            System.out.println("票已售完");
             loop = false;
            return;
        }

        //判断票数后休眠
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //开始卖票
        System.out.println(Thread.currentThread().getName() + "卖了一张票\t" + "剩余票数：" + (--ticketnumm));

    }
    @Override
    public void run() {
        while (loop) {
            sell();
        }
    }
}