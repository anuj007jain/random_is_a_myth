package com.Algorithms_Coursera.Week2.StacksAndQueues;

import java.util.EmptyStackException;

/**
 * Created by anuj.jain02 on 17/1/17.
 */
public class StackUsingResizingArray {

    String[] stack;
    int size;

    public StackUsingResizingArray() {
        stack = new String[1];
        size = 0;
    }

    private void push(String item){
        if(size == stack.length){
            resize(size*2);
        }
        stack[size++] = item;
    }

    private String pop(){
        if(size == 0) {
            throw new EmptyStackException();
        }
        String poppedItem = stack[--size];
        stack[size] = null;
        if(size > 0 && size == stack.length/4){
            resize(stack.length/2);
        }
        return poppedItem;
    }

    private void resize(int newSize){
        String[] newArray = new String [newSize];
        for(int i = 0 ; i < size ; i++){
            newArray[i] = stack[i];
        }
        stack = newArray;

    }

    private boolean isEmpty(){
        return size == 0;
    }

    public static void main(String[] args) {
        StackUsingResizingArray stackUsingResizingArray = new StackUsingResizingArray();
        stackUsingResizingArray.push("to");
        System.out.println(stackUsingResizingArray.stack.length);
        stackUsingResizingArray.push("be");
        System.out.println(stackUsingResizingArray.stack.length);
        stackUsingResizingArray.push("or");
        System.out.println(stackUsingResizingArray.stack.length);
        stackUsingResizingArray.push("not");
        System.out.println(stackUsingResizingArray.stack.length);
        stackUsingResizingArray.push("to");
        System.out.println(stackUsingResizingArray.stack.length);
        System.out.println(stackUsingResizingArray.pop());
        System.out.println(stackUsingResizingArray.stack.length);
        stackUsingResizingArray.push("be");
        System.out.println(stackUsingResizingArray.stack.length);
        System.out.println(stackUsingResizingArray.pop());
        System.out.println(stackUsingResizingArray.stack.length);
        System.out.println(stackUsingResizingArray.pop());
        System.out.println(stackUsingResizingArray.stack.length);
        stackUsingResizingArray.push("that");
        System.out.println(stackUsingResizingArray.stack.length);
        System.out.println(stackUsingResizingArray.pop());
        System.out.println(stackUsingResizingArray.stack.length);
        System.out.println(stackUsingResizingArray.pop());
        System.out.println(stackUsingResizingArray.stack.length);
        System.out.println(stackUsingResizingArray.pop());
        System.out.println(stackUsingResizingArray.stack.length);
        stackUsingResizingArray.push("is");
        System.out.println(stackUsingResizingArray.stack.length);
    }
}
