package com.GeeksForGeeks.LinkedList;

/**
 * Created by anuj on 19/4/16.
 */


public class String_Linked_List {

    String_Node head;

    public void printLinkedList(){
        String_Node n = head;

        while(n!=null){
            System.out.print(n.data);
            if(n.next==null)
                break;
            else
                System.out.print(" -> ");
            n=n.next;
        }
        System.out.println();
    }

    public void addNodeAtStart(String data){
        String_Node newStringNode = new String_Node(data);
        newStringNode.next = head;
        head = newStringNode;

    }

    public void addNodeAfterNode(String_Node second, String data) {
        String_Node newStringNode = new String_Node(data);
        newStringNode.next = second.next;
        second.next = newStringNode;
    }

    public void addNodeAtLast(String data){
        String_Node newStringNode = new String_Node(data);
        String_Node trav = head;
        if(head==null){
            newStringNode.next=null;
            head = newStringNode;
        }
        else {
            while (trav.next != null) {
                trav = trav.next;
            }
            trav.next = newStringNode;
            newStringNode.next = null;
        }
    }

    public void deleteNodeUsingKey(String key){
        String_Node prev = head;
        String_Node trav = head;
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
        String_Node prev = head;
        String_Node trav = head;

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
        String_Node trav = head;
        while(trav!=null) {
            count++;
            trav = trav.next;
        }
        return count;
    }

    public int getCountRecursive(){
        return getCountRecursiveInside(head);
    }

    private int getCountRecursiveInside(String_Node String_Node){
        if(String_Node == null)
            return 0;
        return 1 + getCountRecursiveInside(String_Node.next);
    }

    public static void main(String[] args){
        String_Linked_List ll = new String_Linked_List();

        ll.head = new String_Node("a");
        String_Node second = new String_Node("bc");
        String_Node third = new String_Node("a");
        ll.head.next = second;
        second.next = third;

        //display linked list
        ll.printLinkedList();

        //add node at the start of the linked list
        ll.addNodeAtStart("fg");

        ll.printLinkedList();

        //add node after a given node
        ll.addNodeAfterNode(second,"s");

        ll.printLinkedList();

        //add node at the end of the linked list
        ll.addNodeAtLast("rt");

        ll.printLinkedList();

        //delete node containing data provided
        ll.deleteNodeUsingKey("rt");

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




    }


}