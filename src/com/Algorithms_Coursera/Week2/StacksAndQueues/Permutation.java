package com.Algorithms_Coursera.Week2.StacksAndQueues;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by anuj.jain02 on 5/2/17.
 */
public class Permutation {

    public static void main(String[] args) {
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<String>();
        int count = Integer.parseInt(args[0]);
        while(!StdIn.isEmpty()){
            randomizedQueue.enqueue(StdIn.readString());
        }
        while(count-- > 0){
            StdOut.println(randomizedQueue.dequeue());
        }
    }

}
