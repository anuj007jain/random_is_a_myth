package com.Repeat_Practice;

/**
 * Created by anuj.jain02 on 4/8/17.
 */
public class PingPong {
    static Object lock = new Object();


    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //System.out.println("First thread");
                    synchronized (lock) {
                        try {
                            lock.notifyAll();
                            System.out.println("Ping");
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    //System.out.println("Second thread");
                    synchronized (lock) {
                        lock.notifyAll();
                        try {
                            System.out.println("Pong");
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });
        t.start();
        t2.start();
    }
}
