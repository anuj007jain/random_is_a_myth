package com.InterviewProblems;

import java.util.HashMap;
import java.util.Map;


/*
    Remove redundant linked list nodes
 */
public class Salesforce_Redundancy_In_Linked_List {

    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static SinglyLinkedListNode distinct(SinglyLinkedListNode head) {
        // Write your code here

        SinglyLinkedList solutionList = new SinglyLinkedList();

        SinglyLinkedListNode trav = head;
        Map map = new HashMap();
        while (trav != null) {
            if(map.get(trav.data) == null) {
                solutionList.insertNode(trav.data);
                map.put(trav.data, 1);
            }
            trav = trav.next;
        }

        return solutionList.head;

    }

    public static void main(String[] args) {
        SinglyLinkedList inputList = new SinglyLinkedList();
        inputList.insertNode(3);
        inputList.insertNode(4);
        inputList.insertNode(3);
        inputList.insertNode(2);
        inputList.insertNode(6);
        inputList.insertNode(1);
        inputList.insertNode(2);
        inputList.insertNode(6);

        distinct(inputList.head);

    }

}
