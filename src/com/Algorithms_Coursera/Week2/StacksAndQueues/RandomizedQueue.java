package com.Algorithms_Coursera.Week2.StacksAndQueues;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by anuj.jain02 on 31/1/17.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private Item[] randomizedQueue;
    private int size;

    public RandomizedQueue()                 // construct an empty randomized queue
    {
        randomizedQueue = (Item[]) new Object[1];
        size = 0;
    }
    public boolean isEmpty()                 // is the queue empty?
    {
        return size() == 0;
    }
    public int size()                        // return the number of items on the queue
    {
        return size;
    }
    public void enqueue(Item item)           // add the item
    {
        if(item == null){
            throw new NullPointerException();
        }
        if(randomizedQueue.length == size){
            resize(randomizedQueue.length * 2);
        }
        randomizedQueue[size++] = item;
    }

    private void resize(int newSize) {
        Item[] newRandomizedQueue = (Item[]) new Object[newSize];
        for(int i = 0 ; i < size ; i++){
            newRandomizedQueue[i] = randomizedQueue[i];
        }
        randomizedQueue = newRandomizedQueue;
    }

    public Item dequeue()                    // remove and return a random item
    {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        int randomNumber = StdRandom.uniform(size);
        Item dequedItem = randomizedQueue[randomNumber];
        randomizedQueue[randomNumber] = randomizedQueue[--size];
        randomizedQueue[size] = null; // avoids loitering
        if(size > 0 && size < randomizedQueue.length/4){
            resize(randomizedQueue.length/2);
        }
        return dequedItem;
    }
    public Item sample()                     // return (but do not remove) a random item
    {
        return randomizedQueue[StdRandom.uniform(size)];
    }
    public Iterator<Item> iterator()         // return an independent iterator over items in random order
    {
        return new RandomizedIterator();
    }

    private class RandomizedIterator implements Iterator<Item>{

        private int i;
        private Item[] temp;

        public RandomizedIterator() {
            i = 0;
            temp = (Item[]) new Object[size];
            for(int i = 0 ; i < size ; i++){
                temp[i] = randomizedQueue[i];
            }
        }

        @Override
        public boolean hasNext() {
            return i < size;
        }

        @Override
        public Item next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            int randomNumber = StdRandom.uniform(size-i);
            Item next = temp[randomNumber];
            temp[randomNumber] = temp[size - (++i)]; //size should not change while iterating
            temp[size - i] = null;
            return next;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
    /*public static void main(String[] args)   // unit testing (optional)
    {
        RandomizedQueue randomizedQueue = new RandomizedQueue();
        randomizedQueue.enqueue(1);
        randomizedQueue.enqueue("Anuj");
        randomizedQueue.enqueue(2);
        randomizedQueue.enqueue(4);
        //System.out.println(randomizedQueue.dequeue());
        randomizedQueue.enqueue("Jain");
        //System.out.println(randomizedQueue.dequeue());
        Iterator iterator = randomizedQueue.iterator();
        Iterator iterator2 = randomizedQueue.iterator();
        while(iterator.hasNext() || iterator2.hasNext()){
            if(iterator.hasNext())
                System.out.println("Iterator 1: "+iterator.next());
            if(iterator2.hasNext())
                System.out.println("Iterator 2: "+iterator2.next());
        }
    }*/
}

