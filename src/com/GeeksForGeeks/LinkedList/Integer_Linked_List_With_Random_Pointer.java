package com.GeeksForGeeks.LinkedList;

/**
 * Created by anuj on 29/4/16.
 */
public class Integer_Linked_List_With_Random_Pointer {

    Integer_Node_With_Random_Pointer head;

    public void printLinkedList(){
        Integer_Node_With_Random_Pointer travNext = head;
        Integer_Node_With_Random_Pointer travRandom = head;
        while(travNext!=null){
            System.out.print(travNext.data);
            if(travRandom==null)
                System.out.print("null");
            else
                System.out.print(travRandom.data);
            /*if(travNext.next==null)
                break;*/
            System.out.print(" -> ");
            travRandom = travNext.random;
            if(travNext.next==null)
                break;
            travNext = travNext.next;
        }
        System.out.print("null");
        System.out.print(travRandom.data);
        System.out.println();

    }

    public static void main(String[] args) {


    }
}
