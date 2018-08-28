package com.GeeksForGeeks.LinkedList;

/**
 * Created by anuj on 2/5/16.
 */

//www.geeksforgeeks.org/add-1-number-represented-linked-list/
public class Add_1_To_A_Number_As_Linked_List {
    private void add1ToANumberAsLinkedList(Integer_Linked_List ill){

        ill.head = ill.reverseLinkedList(ill.head);
        Integer_Node trav = ill.head;
        int flag = 0;
        while(trav!=null){
            if(trav.data == 9) {
                trav.data = 0;
                trav=trav.next;
            }
            else {
                flag = 1;
                trav.data++;
                break;
            }
        }

        if(flag == 0)
            ill.addNodeAtLast(1);


        ill.head = ill.reverseLinkedList(ill.head);
        ill.printLinkedList();

    }

    public static void main(String[] args) {
        Add_1_To_A_Number_As_Linked_List add = new Add_1_To_A_Number_As_Linked_List();
        Integer_Linked_List ill = new Integer_Linked_List();
        ill.head = new Integer_Node(9);
        Integer_Node first = new Integer_Node(9);
        Integer_Node second = new Integer_Node(9);
        Integer_Node third = new Integer_Node(8);
        ill.head.next=first;
        first.next=second;
        second.next=third;

        add.add1ToANumberAsLinkedList(ill);
    }
}
