package com.MultiThreading;

/**
 * Created by anuj.jain02 on 3/9/17.
 */

class Runner1 extends Thread {

    @Override
    public void run() {
        for (int i = 0 ; i < 10 ; i++) {
            System.out.println(i+" "+Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

public class A_ExtendingThread {

    public static void main(String[] args) {
        Runner1 runner1 = new Runner1();
        runner1.start();
        //runnable1.start(); -> IllegalStateException
        Runner1 runner2 = new Runner1();
        runner2.start();

        Thread t1 = new Thread(new Runner1());
        t1.start();
        try {
            runner1.join();
            runner2.join();
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
