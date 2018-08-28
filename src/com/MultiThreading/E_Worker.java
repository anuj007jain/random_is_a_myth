package com.MultiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by anuj.jain02 on 14/9/17.
 */
public class E_Worker {

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    private List<Integer> list1 = new ArrayList<>();
    private List<Integer> list2 = new ArrayList<>();

    private Random random = new Random();

    public void addToList1(){
        synchronized (lock1) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list1.add(random.nextInt(100));
        }
    }

    public void addToList2(){
        synchronized (lock2) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list2.add(random.nextInt(100));
        }
    }

    public void process(){
        for(int i = 0 ; i < 1000 ; i++) {
            addToList1();
            addToList2();
        }
    }

    public static void main(String[] args) {
        E_Worker e_worker = new E_Worker();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                e_worker.process();
            }
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                e_worker.process();
            }
        });
        long t1 = System.currentTimeMillis();
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        long t2 = System.currentTimeMillis();
        System.out.println("list1 size: "+e_worker.list1.size() + " list2 size: "+e_worker.list2.size());
        System.out.println("Time taken: "+(t2-t1));

    }

}

