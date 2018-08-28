package com.Algorithms_Coursera.Week2.StacksAndQueues;

import java.util.EmptyStackException;

/**
 * Created by anuj.jain02 on 21/1/17.
 */
public class QueueUsingResizingArray{

    String[] queue;
    int head;
    int tail;
    int n;

    private QueueUsingResizingArray() {
        queue = new String[1];
        head = 0;
        tail = 0;
        n = 0;
    }

    private int size(){
        return n;
    }

    private boolean isEmpty(){
        return size() == 0;
    }

    private void push(String item){
        if(n == queue.length){
            resize(queue.length*2);
        }
        queue[tail++] = item;
        if(tail == queue.length){
            tail = 0; //wrap around
        }
        n++;
    }

    private String pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        String poppedItem = queue[head];
        queue[head++] = null;
        n--;
        if(head == queue.length){
            head = 0; //wrap around
        }
        if(n > 0 && n == queue.length/4){
            resize(queue.length/2);
        }
        return poppedItem;
    }

    private void resize(int newSize){
        String[] newArray = new String[newSize];
        for(int i = 0 ; i < newSize ; i++){
            newArray[i] = queue[(head+i) % queue.length]; // because of wrapping around
        }
        queue = newArray;
        head = 0;
        tail = n;
    }

    public static void main(String[] args) {
        QueueUsingResizingArray queueUsingResizingArray = new QueueUsingResizingArray();
        System.out.println(queueUsingResizingArray.isEmpty());
        System.out.println(queueUsingResizingArray.size());
        //System.out.println(queueUsingResizingArray.pop());
        queueUsingResizingArray.push("to");
        queueUsingResizingArray.push("be");
        queueUsingResizingArray.push("or");
        System.out.println(queueUsingResizingArray.pop());
        System.out.println(queueUsingResizingArray.pop());
        System.out.println(queueUsingResizingArray.pop());
        System.out.println(queueUsingResizingArray.pop());

    }


}
