package com.Algorithms_Coursera.Week2.StacksAndQueues;

import java.util.EmptyStackException;

/**
 * Created by anuj.jain02 on 12/1/17.
 */
public class StackUsingFixedSizeArray {

    String[] s;
    int N;

    private StackUsingFixedSizeArray(int n) { // 'n' hack. -> solved by resizing arrays
        N = 0;
        s = new String[n];

    }

    private String pop(){
        if(N > 0) {
            String item = s[--N];
            s[N] = null; // avoids loitering
            return item;
        }
        throw new EmptyStackException();
    }

    private void push(String item){
        if(N < s.length){
            s[N++] = item;
            return;
        }
        throw new StackOverflowError();
    }

    private boolean isEmpty(){
        return N == 0;
    }

    public static void main(String[] args) {
        StackUsingFixedSizeArray stack = new StackUsingFixedSizeArray(10);
        System.out.println(stack.isEmpty());
        stack.push("Anuj");
        stack.push("Jain");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        //System.out.println(stack.pop());
        stack.push("Hi");
        stack.push("Hi");
        stack.push("Hi");
        stack.push("Hi");
        stack.push("Hi");
        stack.push("Hi");
        stack.push("Hi");
        stack.push("Hi");
        stack.push("Hi");
        stack.push("Hi");
        stack.push("Hi");
    }
}
