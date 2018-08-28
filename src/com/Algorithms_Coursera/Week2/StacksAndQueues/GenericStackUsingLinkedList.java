package com.Algorithms_Coursera.Week2.StacksAndQueues;

import java.util.EmptyStackException;

/**
 * Created by anuj.jain02 on 22/1/17.
 */
public class GenericStackUsingLinkedList<Item> {

    Node first = null;

    private class Node{
        Item item;
        Node next;
    }

    private boolean isEmpty(){
        return first == null;
    }

    private void push(Item item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    private Item pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        Item poppedItem = first.item;
        first = first.next;
        return poppedItem;
    }

    public static void main(String[] args) {
        GenericStackUsingLinkedList genericStackUsingLinkedList = new GenericStackUsingLinkedList();
        genericStackUsingLinkedList.push(1);
        genericStackUsingLinkedList.push("Anuj");
        System.out.println(genericStackUsingLinkedList.pop());
        System.out.println(genericStackUsingLinkedList.pop());
        System.out.println(genericStackUsingLinkedList.pop());
    }
}
