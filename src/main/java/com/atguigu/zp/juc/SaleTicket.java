package com.atguigu.zp.juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *  synchronized和lock的比较：https://www.cnblogs.com/handsomeye/p/5999362.html
 */
class Ticket { //资源类

    private int number = 30;  //票数

    /*public synchronized void saleTicket() {
        if (number > 0) {
            System.out.println (Thread.currentThread ().getName () + "\t" + "出售的第" + (number--) + "票，还剩" + number + "张票");
        }
    }*/

    private Lock lock = new ReentrantLock (); //可重复锁  手动控制

    public void saleTicket() {
        lock.lock ();
        try {
            if (number > 0) {
                System.out.println (Thread.currentThread ().getName () + "\t" + "出售的第" + (number--) + "票，还剩" + number + "张票");
            }
        } catch (Exception e) {
            e.printStackTrace ();
        } finally {
            lock.unlock ();
        }
    }
}
/**
 * @author zhangpeng
 * @create 2020/8/25 11:43
 */

/**
 * 题目：三个售票员   卖出    30张
 * 多线程编程的企业级套路+模板
 * <p>
 * 1  在高内聚低耦合的前提下，线程          操作（对外暴露的调用方法）     资源类
 */
public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket ();  //资源类

        new Thread (() -> {
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket ();
            }
        }, "A").start ();

        new Thread (() -> {
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket ();
            }
        }, "B").start ();

        new Thread (() -> {
            for (int i = 0; i < 40; i++) {
                ticket.saleTicket ();
            }
        }, "C").start ();

        /*new Thread (new Runnable () {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.saleTicket ();
                }
            }
        }, "A").start ();

        new Thread (new Runnable () {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.saleTicket ();
                }
            }
        }, "B").start ();


        new Thread (new Runnable () {
            @Override
            public void run() {
                for (int i = 0; i < 40; i++) {
                    ticket.saleTicket ();
                }
            }
        }, "C").start ();*/
    }
}
