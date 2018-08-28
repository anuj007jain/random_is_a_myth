package com.Algorithms_Coursera.Week2.StacksAndQueues;


import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by anuj.jain02 on 30/1/17.
 */
public class Deque<Item> implements Iterable<Item>{

    private Node first,last;
    private int size;

    private class Node
    {
        Item item;
        Node next;
    }

    public Deque()                     // construct an empty deque
    {
        first = last= null;
        size = 0;
    }

    public boolean isEmpty()                 // is the deque empty?
    {
        return size() == 0;
    }

    public int size()                        // return the number of items on the deque
    {
        return size;
    }

    public void addFirst(Item item)          // add the item to the front
    {
        if(item == null){
            throw new NullPointerException();
        }
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
        if(last == null){
            last = first;
        }
        size++;
    }

    public void addLast(Item item)           // add the item to the end
    {
        if(item == null){
            throw new NullPointerException();
        }
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()) {
            first = last;
        }
        else {
            oldLast.next = last;
        }
        size++;
    }

    public Item removeFirst()                // remove and return the item from the front
    {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Item removedItem = first.item;
        first = first.next;
        size--;
        if(isEmpty()){
            last = null;
        }
        return removedItem;
    }

    public Item removeLast()                 // remove and return the item from the end
    {
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        Item removedItem = last.item;
        Node prev = first;
        if(first.next == null){
            first = last = null;
            size--;
            return removedItem;
        }
        Node curr = first.next;
        while(curr.next != null){
            prev = curr;
            curr = curr.next;
        }
        last = prev;
        last.next = null;
        size--;
        return removedItem;

    }

    public Iterator<Item> iterator()         // return an iterator over items in order from front to end
    {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{

        Node curr = first;

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public Item next() {
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            Item item = curr.item;
            curr = curr.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /*public static void main(String[] args)   // unit testing (optional)
    {
        Deque deque = new Deque<>();
        *//*deque.addFirst(3);
        deque.addFirst("anuj");
        deque.addLast(5);
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeFirst());
        System.out.println(deque.removeLast());
        System.out.println(deque.removeLast());*//*

        *//*System.out.println(deque.isEmpty());
        deque.addLast(4);
        System.out.println(deque.isEmpty());
        System.out.println(deque.removeFirst());
        System.out.println(deque.isEmpty());
        deque.addFirst("anuj");
        System.out.println(deque.isEmpty());
        System.out.println(deque.removeFirst());
        System.out.println(deque.isEmpty());*//*

    }*/

}

