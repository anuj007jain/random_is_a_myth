package com.MultiThreading;

/**
 * Created by anuj.jain02 on 3/9/17.
 */

class Runner2 implements Runnable {

    @Override
    public void run() {
        for (int i = 0 ; i < 10 ; i ++) {
            System.out.println(i+" "+Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class B_ImplementingRunnable {

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runner2());
        thread1.start();
        Thread thread2 = new Thread(new Runner2());
        thread2.start();

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0 ; i < 10 ; i ++) {
                    System.out.println(i+" "+Thread.currentThread().getName());
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread3.start();
    }

}
