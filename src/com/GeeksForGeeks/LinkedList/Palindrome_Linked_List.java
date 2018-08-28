package com.GeeksForGeeks.LinkedList;

/**
 * Created by anuj on 26/4/16.
 */

//http://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
public class Palindrome_Linked_List {

    Integer_Node head;

    private void isPalindrome(String_Node stringNode){
        String str = "";
        String_Node trav = stringNode;
        while(trav!=null){
            str=str+(trav.data);
            trav=trav.next;
        }

        int l = 0;
        int h = str.length()-1;
        while(l<h){
            if(str.charAt(l++) == str.charAt(h--)){
                continue;
            }
            else {
                System.out.println("Not a palindrome");
                return;
            }
        }
        System.out.println("Palindrome");
        return;

    }

    public static void main(String[] args) {
        Palindrome_Linked_List pll = new Palindrome_Linked_List();
        String_Linked_List sll = new String_Linked_List();
        sll.addNodeAtStart("ab");
        sll.addNodeAtLast("asa");
        sll.addNodeAtLast("ba");
        pll.isPalindrome(sll.head);


    }
}
