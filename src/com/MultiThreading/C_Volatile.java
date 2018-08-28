package com.MultiThreading;

import java.util.Scanner;

/**
 * Created by anuj.jain02 on 6/9/17.
 */
class Runner extends Thread{
    private volatile boolean running = true;

    @Override
    public void run() {
        while (running) {
            System.out.println("Hello World");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void shutdown() {
        running = false;
    }
}

public class C_Volatile {
    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.start();
        System.out.println("Press something to stop");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        runner.shutdown();
    }
}
