package com.GeeksForGeeks.LinkedList;

/**
 * Created by anuj on 8/5/16.
 */
public class Doubly_Integer_Linked_List {

    public Doubly_Integer_Linked_List_Node head = null;

    public void printDoublyLinkedList(Doubly_Integer_Linked_List_Node n){

        while(n!=null){
            System.out.print(n.data);
            if(n.next==null)
                break;
            System.out.print(" -> ");
            n=n.next;
        }
        System.out.println();
        while(n!=null){
            System.out.print(n.data);
            if(n.prev==null)
                break;
            System.out.print(" -> ");
            n=n.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Doubly_Integer_Linked_List dill = new Doubly_Integer_Linked_List();
        dill.head = new Doubly_Integer_Linked_List_Node(25);
        dill.head.next = new Doubly_Integer_Linked_List_Node(12);
        dill.head.next.next = new Doubly_Integer_Linked_List_Node(30);
        dill.head.next.next.next = new Doubly_Integer_Linked_List_Node(10);
        dill.head.next.next.next.next = new Doubly_Integer_Linked_List_Node(36);
        dill.head.next.next.next.next.next = new Doubly_Integer_Linked_List_Node(15);
        dill.head.next.next.next.next.next.prev = dill.head.next.next.next.next;
        dill.head.next.next.next.next.prev = dill.head.next.next.next;
        dill.head.next.next.next.prev = dill.head.next.next;
        dill.head.next.next.prev = dill.head.next;
        dill.head.next.prev = dill.head;
        dill.printDoublyLinkedList(dill.head);
    }

}
