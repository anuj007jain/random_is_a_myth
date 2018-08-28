package com.Algorithms_Coursera.Week2.StacksAndQueues;

import java.util.EmptyStackException;

/**
 * Created by anuj.jain02 on 22/1/17.
 */
public class GenericStackUsingResizingArray<Item> {

    Item[] stack;
    int size;

    private GenericStackUsingResizingArray() {
        //stack = new Item[1]; --> generic array creation not allowed in Java
        stack = (Item[]) new Object[1];
        size = 0;
    }

    private boolean isEmpty(){
        return size == 0;
    }

    private void push(Item item){
        if(size == stack.length){
            resize(stack.length*2);
        }
        stack[size++] = item;
    }

    private Item pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        Item poppedItem = stack[--size];
        stack[size] = null; //avoids loitering
        if(size > 0 && size == stack.length/4){
            resize(stack.length/2);
        }
        return poppedItem;
    }

    private void resize(int newSize){
        Item[] newArray = (Item[]) new Object[newSize];
        for(int i = 0 ; i < size ; i++){
            newArray[i] = stack[i];
        }
        stack = newArray;
    }

    private int size(){
        return size;
    }

    public static void main(String[] args) {
        GenericStackUsingResizingArray genericStackUsingResizingArray = new GenericStackUsingResizingArray();
        genericStackUsingResizingArray.push(1);
        genericStackUsingResizingArray.push("Anuj");
        genericStackUsingResizingArray.push(new Integer(3));
        genericStackUsingResizingArray.push("Jain");
        genericStackUsingResizingArray.push(5);
        System.out.println(genericStackUsingResizingArray.pop());
        System.out.println("size: "+genericStackUsingResizingArray.size());
        System.out.println(genericStackUsingResizingArray.pop());
        System.out.println("size: "+genericStackUsingResizingArray.size());
        System.out.println(genericStackUsingResizingArray.pop());
        System.out.println("size: "+genericStackUsingResizingArray.size());
        System.out.println(genericStackUsingResizingArray.pop());
        System.out.println("size: "+genericStackUsingResizingArray.size());
        System.out.println(genericStackUsingResizingArray.pop());
        System.out.println("size: "+genericStackUsingResizingArray.size());
        //System.out.println(genericStackUsingResizingArray.pop());
        System.out.println("size: "+genericStackUsingResizingArray.size());

    }

}
