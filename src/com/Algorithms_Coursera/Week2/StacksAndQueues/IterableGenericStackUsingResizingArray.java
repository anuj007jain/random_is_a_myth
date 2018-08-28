package com.Algorithms_Coursera.Week2.StacksAndQueues;

import java.util.EmptyStackException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by anuj.jain02 on 23/2/17.
 */
public class IterableGenericStackUsingResizingArray<Item> implements Iterable {

    private int size;
    private Item[] stack;

    public IterableGenericStackUsingResizingArray() {
        size = 0;
        stack = (Item[]) new Object[1];
    }

    private int size(){
        return size;
    }

    private boolean isEmpty(){
        return size() == 0;
    }

    private void push(Item item){
        Set<Item> set = new HashSet<>();
        if(item == null)
            throw new NullPointerException();
        if(stack.length == size())
            resize(stack.length*2);
        stack[size++] = item;
    }

    private Item pop(){
        if(isEmpty())
            throw new EmptyStackException();
        Item poppedItem = stack[--size];
        stack[size] = null; //avoids loitering
        if(size > 0 && size == stack.length/4)
            resize(stack.length/2);
        return poppedItem;
    }

    private void resize(int newSize){
        Item[] newStack = (Item[]) new Object[newSize];
        for(int i = 0 ; i < size() ; newStack[i] = stack[i++]);
        stack = newStack;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ArrayIterator();
    }

    private class ArrayIterator implements Iterator {

        private int N = size;

        @Override
        public boolean hasNext() {
            return N > 0;
        }

        @Override
        public Object next() {
            return stack[--N];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        IterableGenericStackUsingResizingArray iterableGenericStackUsingResizingArray = new IterableGenericStackUsingResizingArray();
        System.out.println(iterableGenericStackUsingResizingArray.stack.length);
        iterableGenericStackUsingResizingArray.push(1);
        System.out.println(iterableGenericStackUsingResizingArray.stack.length);
        iterableGenericStackUsingResizingArray.push("A");
        System.out.println(iterableGenericStackUsingResizingArray.stack.length);
        iterableGenericStackUsingResizingArray.push(2);
        System.out.println(iterableGenericStackUsingResizingArray.stack.length);
        iterableGenericStackUsingResizingArray.push("B");
        System.out.println(iterableGenericStackUsingResizingArray.stack.length);
        iterableGenericStackUsingResizingArray.push(3);
        System.out.println(iterableGenericStackUsingResizingArray.stack.length);
        iterableGenericStackUsingResizingArray.push("C");
        System.out.println(iterableGenericStackUsingResizingArray.stack.length);
        System.out.println(iterableGenericStackUsingResizingArray.pop());
        System.out.println(iterableGenericStackUsingResizingArray.stack.length);
        Iterator iterator = iterableGenericStackUsingResizingArray.iterator();
        while (iterator.hasNext())
            System.out.println(iterator.next());
        System.out.println(iterableGenericStackUsingResizingArray.pop());
        System.out.println(iterableGenericStackUsingResizingArray.stack.length);;
        System.out.println(iterableGenericStackUsingResizingArray.pop());
        System.out.println(iterableGenericStackUsingResizingArray.stack.length);
        System.out.println(iterableGenericStackUsingResizingArray.pop());
        System.out.println(iterableGenericStackUsingResizingArray.stack.length);
        System.out.println(iterableGenericStackUsingResizingArray.pop());
        System.out.println(iterableGenericStackUsingResizingArray.stack.length);
    }
}
