package com.GeeksForGeeks.LinkedList;

/**
 * Created by anuj on 29/4/16.
 */

//http://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
public class Looped_Linked_List {

    private void getLoopStartElement(Integer_Node node){

        Integer_Node tortoise = node;
        Integer_Node hare = node;
        tortoise=tortoise.next;
        hare=hare.next.next;

        while(tortoise!=hare && hare!=null){
            if(hare.next==null) {
                System.out.println("No loop");
                return;
            }
            tortoise=tortoise.next;
            hare=hare.next.next;
        }

            int count=1;
            while(tortoise.next!=hare){
                count++;
                tortoise=tortoise.next;
            }
        tortoise=node;
        for(int i=0 ; i<count ; i++ ){
            hare=hare.next;
        }
        while(tortoise!=hare){
            tortoise=tortoise.next;
            hare=hare.next;
        }
        System.out.print(tortoise.data);


    }

    public static void main(String[] args) {

        Looped_Linked_List lll = new Looped_Linked_List();
        Integer_Linked_List ill = new Integer_Linked_List();
        Integer_Node first = new Integer_Node(1);
        ill.head = first;
        Integer_Node second = new Integer_Node(2);
        ill.head.next = second;
        ill.addNodeAfterNode(second,3);
        ill.addNodeAtLast(4);
        ill.addNodeAtStart(0);
        ill.head.next.next.next.next.next=second;
        lll.getLoopStartElement(ill.head);

    }

}
