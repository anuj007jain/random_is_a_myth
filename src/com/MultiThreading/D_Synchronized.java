package com.MultiThreading;

/**
 * Created by anuj.jain02 on 7/9/17.
 */
public class D_Synchronized {

    private int count = 0;

    private synchronized void increment() {
        count++;
    }

    class Runner implements Runnable {
        @Override
        public void run() {
            for(int i = 0 ; i < 400000 ; i++){
                increment();
            }
        }
    }

    public static void main(String[] args) {
        D_Synchronized d_synchronized = new D_Synchronized();
        Thread thread1 = new Thread(d_synchronized.new Runner());
        Thread thread2 = new Thread(d_synchronized.new Runner());
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(d_synchronized.count);

    }

}
