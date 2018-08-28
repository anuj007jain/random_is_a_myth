package com.GeeksForGeeks.LinkedList;

/**
 * Created by anuj on 29/4/16.
 */

//http://www.geeksforgeeks.org/a-linked-list-with-next-and-arbit-pointer/
public class Incomplete_Copy_Linked_List_With_Random_Pointer {

    public void copyLinkedList(Integer_Linked_List_With_Random_Pointer illwrp){

        Integer_Node_With_Random_Pointer trav = illwrp.head;
        while(trav!=null){
            Integer_Node_With_Random_Pointer newnode = new Integer_Node_With_Random_Pointer(trav.data);
            newnode.next = trav.next;
            trav.next = newnode;
            if(trav.next.next==null)
                trav=null;
            else
                trav = trav.next.next;
            illwrp.printLinkedList();
        }

    }

    public static void main(String[] args) {

        Incomplete_Copy_Linked_List_With_Random_Pointer cllwrp = new Incomplete_Copy_Linked_List_With_Random_Pointer();
        Integer_Linked_List_With_Random_Pointer illwrp = new Integer_Linked_List_With_Random_Pointer();
        illwrp.head = new Integer_Node_With_Random_Pointer(0);
        Integer_Node_With_Random_Pointer first = new Integer_Node_With_Random_Pointer(1);
        Integer_Node_With_Random_Pointer second = new Integer_Node_With_Random_Pointer(2);
        Integer_Node_With_Random_Pointer third = new Integer_Node_With_Random_Pointer(3);
        illwrp.head.next=first;
        first.next=second;
        second.next=third;

        illwrp.head.random=third;
        first.random=third;
        second.random=illwrp.head;
        third.random = second;
        illwrp.printLinkedList();
        cllwrp.copyLinkedList(illwrp);

    }

}
