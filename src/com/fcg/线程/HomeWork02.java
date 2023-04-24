package com.fcg.线程;

/**
 * @author 好女人蕾赛
 * @version 1.0
 */
public class HomeWork02 {
    public static void main(String[] args) {
        User user = new User();
        Thread thread = new Thread(user);
        thread.setName("jack");
        Thread thread1 = new Thread(user);
        thread1.setName("tom");
        thread.start();
        thread1.start();

    }
}

class User implements Runnable
{
    private String name;
    private static Account account = new Account();
    boolean loop =true;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //取钱
    public synchronized void reduceMoney(double money) throws InterruptedException {
        //调取账户里的减余额方法
        if (account.getBalance() <= 1000)
        {
            System.out.println("余额不足1000");
            loop = false;
            return;
        }
        account.reduce(money);
        System.out.println(Thread.currentThread().getName()+ "取了1000" + "\t余额：" + account.getBalance());
        Thread.sleep(500);
    }


    @Override
    public void run() {
        while(loop)
        {
            try {
                reduceMoney(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Account
{
    private double balance = 10000;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void reduce(double money)
    {
        balance -=money;
    }

}