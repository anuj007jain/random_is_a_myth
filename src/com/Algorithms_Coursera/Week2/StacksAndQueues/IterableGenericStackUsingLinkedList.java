package com.Algorithms_Coursera.Week2.StacksAndQueues;

import java.util.EmptyStackException;
import java.util.Iterator;

/**
 * Created by anuj.jain02 on 23/2/17.
 */
public class IterableGenericStackUsingLinkedList<Item> implements Iterable {

    Node first = null;

    private class Node{
        Item item;
        Node next;
    }

    private boolean isEmpty(){
        return first == null;
    }

    private void push(Item item){
        if(item == null)
            throw new NullPointerException();
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next  = oldFirst;
    }

    private Item pop(){
        if(isEmpty())
            throw new EmptyStackException();
        Item poppedItem = first.item;
        first = first.next;
        return poppedItem;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public class ListIterator implements Iterator<Item>{

        Node curr = first;

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public Item next() {
            Item next = curr.item;
            curr = curr.next;
            return next;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        IterableGenericStackUsingLinkedList iterableGenericStackUsingLinkedList = new IterableGenericStackUsingLinkedList();
        iterableGenericStackUsingLinkedList.push(1);
        iterableGenericStackUsingLinkedList.push("Anuj");
        iterableGenericStackUsingLinkedList.push(3);
        iterableGenericStackUsingLinkedList.push("Jain");
        iterableGenericStackUsingLinkedList.push(5);
        System.out.println("popped item "+iterableGenericStackUsingLinkedList.pop());
        Iterator iterator = iterableGenericStackUsingLinkedList.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
