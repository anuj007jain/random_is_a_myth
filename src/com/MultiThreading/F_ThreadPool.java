package com.MultiThreading;

import java.util.concurrent.*;

/**
 * Created by anuj.jain02 on 15/9/17.
 */
public class F_ThreadPool {

    class Processor implements Runnable {

        private int id;

        public Processor(int id) {
            this.id = id;
        }

        @Override
        public void run() {
            System.out.println("Starting "+id);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Completed "+id);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        for(int i = 0 ; i < 5 ; i++) {
            executorService.submit(new F_ThreadPool().new Processor(i));
        }
        executorService.shutdown();
        System.out.println("All threads submitted");
        executorService.awaitTermination(1, TimeUnit.DAYS);
        System.out.println("All threads completed");
    }

}
;