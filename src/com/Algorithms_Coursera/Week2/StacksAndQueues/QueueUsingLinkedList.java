package com.Algorithms_Coursera.Week2.StacksAndQueues;

/**
 * Created by anuj.jain02 on 21/1/17.
 */
public class QueueUsingLinkedList {

    private Node first,last;

    private class Node{
        String item;
        Node next;
    }

    private boolean isEmpty(){
        return first == null;
    }

    private void enqueue(String item){
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if(isEmpty()){
            first = last;
        }
        else {
            oldLast.next = last;
        }
    }

    private String dequeue() throws Exception {
        if(isEmpty()){
            throw new Exception("No item to dequeue");
        }
        String dequeuedItem = first.item;
        first = first.next;
        if(isEmpty()){
            last = null;
        }
        return dequeuedItem;
    }

    public static void main(String[] args) throws Exception {
        QueueUsingLinkedList queueUsingLinkedList = new QueueUsingLinkedList();
        queueUsingLinkedList.enqueue("Anuj");
        queueUsingLinkedList.enqueue("Jain");
        System.out.println(queueUsingLinkedList.dequeue());
        System.out.println(queueUsingLinkedList.dequeue());
    }
}
