package com.Algorithms_Coursera.Week2.StacksAndQueues;

import java.util.EmptyStackException;

/**
 * Created by anuj.jain02 on 10/1/17.
 */
public class StackUsingLinkedList {

    private Node first = null;

    private class Node{
        String item;
        Node next;
    }

    private boolean isEmpty(){
        return first == null;
    }

    private String pop(){
        if(first != null) {
            String item = first.item;
            first = first.next;
            return item;
        }
        throw new EmptyStackException();
    }

    private void push(String item){
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public static void main(String[] args) {
        StackUsingLinkedList stack = new StackUsingLinkedList();
        System.out.println(stack.isEmpty());
        stack.push("Anuj");
        stack.push("Jain");
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
