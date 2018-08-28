package com.GeeksForGeeks.Tree;

import com.GeeksForGeeks.LinkedList.Doubly_Integer_Linked_List;
import com.GeeksForGeeks.LinkedList.Doubly_Integer_Linked_List_Node;

/**
 * Created by anuj on 8/5/16.
 */
//http://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
public class Binary_Tree_To_Doubly_Linked_List {

    public Doubly_Integer_Linked_List dill = new Doubly_Integer_Linked_List();
    private void binaryTreeToDoublyLinkedList(Node node){

        if(node.left!=null)
            binaryTreeToDoublyLinkedList(node.left);

        if(dill.head == null)
            dill.head = new Doubly_Integer_Linked_List_Node(node.key);
        else {
            Doubly_Integer_Linked_List_Node trav = dill.head;
            while (trav.next != null) {
                trav = trav.next;
            }
            trav.next = new Doubly_Integer_Linked_List_Node(node.key);
            trav.next.prev = trav;
        }
        if(node.right!=null)
            binaryTreeToDoublyLinkedList(node.right);
        dill.printDoublyLinkedList(dill.head);

    }

    public static void main(String[] args) {

        Binary_Tree_To_Doubly_Linked_List bttdll = new Binary_Tree_To_Doubly_Linked_List();
        Binary_Tree tree = new Binary_Tree();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);
        bttdll.binaryTreeToDoublyLinkedList(tree.root);
    }

}
