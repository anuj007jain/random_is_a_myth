package com.GeeksForGeeks.LinkedList;

/**
 * Created by anuj on 1/6/16.
 */

//http://www.geeksforgeeks.org/sort-linked-list-already-sorted-absolute-values/
public class Sort_Linked_List_Sorted_On_Absolute_Values {

    private void sort(Integer_Linked_List ill){

        Integer_Node prev = ill.head;
        Integer_Node curr = ill.head.next;
        Integer_Node next = ill.head.next.next;
        boolean flag = false;
        while(!flag){
            if(curr.data < 0) {
                prev.next = curr.next;
                curr.next = ill.head;
                ill.head = curr;
                if(prev.next == null)
                    flag = true;
                else {
                    curr = prev.next;
                    next = curr.next;
                }
            }
            else{
                prev = prev.next;
                curr = curr.next;
                next = next.next;
            }


        }

    }

    public static void main(String[] args) {

        Sort_Linked_List_Sorted_On_Absolute_Values sllsoav = new Sort_Linked_List_Sorted_On_Absolute_Values();
        Integer_Linked_List ill = new Integer_Linked_List();
        ill.head = new Integer_Node(-1);
        ill.head.next = new Integer_Node(2);
        ill.head.next.next = new Integer_Node(-3);
        ill.head.next.next.next = new Integer_Node(4);
        ill.head.next.next.next.next = new Integer_Node(-5);
        sllsoav.sort(ill);
        ill.printLinkedList();


    }

}
