package com.GeeksForGeeks.LinkedList;

/**
 * Created by anuj on 19/4/16.
 */


public class Integer_Linked_List {

    Integer_Node head;

    public void printLinkedList(){
        Integer_Node n = head;

        while(n!=null){
            System.out.print(n.data);
            if(n.next==null)
                break;
            System.out.print(" -> ");
            n=n.next;
        }
        System.out.println();
    }

    public void addNodeAtStart(int data){
        Integer_Node newIntegerNode = new Integer_Node(data);
        newIntegerNode.next = head;
        head = newIntegerNode;

    }

    public void addNodeAfterNode(Integer_Node second, int data) {
        Integer_Node newIntegerNode = new Integer_Node(data);
        newIntegerNode.next = second.next;
        second.next = newIntegerNode;
    }

    public void addNodeAtLast(int data){
        Integer_Node newIntegerNode = new Integer_Node(data);
        Integer_Node trav = head;
        if(head==null){
            newIntegerNode.next=null;
            head = newIntegerNode;
        }
        else {
            while (trav.next != null) {
                trav = trav.next;
            }
            trav.next = newIntegerNode;
            newIntegerNode.next = null;
        }
    }

    public void deleteNodeUsingKey(int key){
        Integer_Node prev = head;
        Integer_Node trav = head;
        if(head == null){
            System.out.println("Cannot delete as already empty");
            return;
        }
        if(trav.data == key){
            head = trav.next;
            return;
        }
        trav =trav.next;
        while(trav != null){
            if(trav.data == key){
                prev.next = trav.next;
                return;
            }
            else
                trav = trav.next;
                prev = prev.next;
        }
        System.out.println("Key not present");
    }

    public void deleteNodeUsingPosition(int position){
        Integer_Node prev = head;
        Integer_Node trav = head;

        if(head == null){
            System.out.println("Cannot delete as already empty");
            return;
        }

        if(position == 0){
            head = head.next;
            return;
        }

        trav=trav.next;
        for(int i = 0 ; i < position-1 && trav != null ; i++){
            trav = trav.next;
            prev = prev.next;
        }

        if(trav==null){
            System.out.println("Position not present");
            return;
        }

        prev.next = trav.next;

    }

    public int getCountIterative(){

        int count =0;
        Integer_Node trav = head;
        while(trav!=null) {
            count++;
            trav = trav.next;
        }
        return count;
    }

    public int getCountRecursive(){
            return getCountRecursiveInside(head);
    }

    private int getCountRecursiveInside(Integer_Node integerNode){
        if(integerNode == null)
            return 0;
        return 1 + getCountRecursiveInside(integerNode.next);
    }

    public Integer_Node reverseLinkedList(Integer_Node node){
        Integer_Node prevNode = null;
        Integer_Node currNode = node;
        Integer_Node nextNode = null;

        while(currNode!=null){
            nextNode = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode=nextNode;
        }
        Integer_Node newHead = prevNode;
        return newHead;
    }


    public static void main(String[] args){
        Integer_Linked_List ll = new Integer_Linked_List();

        ll.head = new Integer_Node(1);
        Integer_Node second = new Integer_Node(2);
        Integer_Node third = new Integer_Node(4);
        ll.head.next = second;
        second.next = third;

        //display linked list
        ll.printLinkedList();

        //add node at the start of the linked list
        ll.addNodeAtStart(0);

        ll.printLinkedList();

        //add node after a given node
        ll.addNodeAfterNode(second,3);

        ll.printLinkedList();

        //add node at the end of the linked list
        ll.addNodeAtLast(5);

        ll.printLinkedList();

        //delete node containing data provided
        ll.deleteNodeUsingKey(0);

        ll.printLinkedList();

        //delete node have the position provided
        ll.deleteNodeUsingPosition(4);

        ll.printLinkedList();

        //size of linked list by iteration
        int count = ll.getCountIterative();

        System.out.println("Count: "+count);

        //size of linked list by recursion
        int countByRecursive = ll.getCountRecursive();

        System.out.println("Count By Recursive: "+countByRecursive);

        //reverse the linked list
        ll.head = ll.reverseLinkedList(ll.head);

        ll.printLinkedList();



    }


}