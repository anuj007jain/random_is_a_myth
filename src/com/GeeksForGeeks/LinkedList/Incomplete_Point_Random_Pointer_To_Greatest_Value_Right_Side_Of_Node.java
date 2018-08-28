package com.GeeksForGeeks.LinkedList;

/**
 * Created by anuj on 2/5/16.
 */

//http://www.geeksforgeeks.org/point-arbit-pointer-greatest-value-right-side-node-linked-list/
public class Incomplete_Point_Random_Pointer_To_Greatest_Value_Right_Side_Of_Node {

    private void pointRandomPointerToGreatestValueRightSideOfNode(Integer_Linked_List_With_Random_Pointer illwrp){

        illwrp.printLinkedList();

    }

    public static void main(String[] args) {

        Incomplete_Point_Random_Pointer_To_Greatest_Value_Right_Side_Of_Node prptgvrson = new Incomplete_Point_Random_Pointer_To_Greatest_Value_Right_Side_Of_Node();
        Integer_Linked_List_With_Random_Pointer illwrp = new Integer_Linked_List_With_Random_Pointer();
        illwrp.head = new Integer_Node_With_Random_Pointer(1);
        illwrp.head.next = new Integer_Node_With_Random_Pointer(2);
        illwrp.head.next.next = new Integer_Node_With_Random_Pointer(3);
        illwrp.head.next.next.next = new Integer_Node_With_Random_Pointer(4);
        prptgvrson.pointRandomPointerToGreatestValueRightSideOfNode(illwrp);
    }
}
