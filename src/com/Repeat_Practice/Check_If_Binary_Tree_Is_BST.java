package com.Repeat_Practice;

import com.GeeksForGeeks.Tree.Binary_Tree;
import com.GeeksForGeeks.Tree.Node;

/**
 * Created by anuj.jain02 on 17/9/17.
 */
public class Check_If_Binary_Tree_Is_BST {

    static boolean flag = true;
    int lastValue = Integer.MIN_VALUE;

    public static void main(String[] args) {

        Check_If_Binary_Tree_Is_BST cibtis = new Check_If_Binary_Tree_Is_BST();
        Binary_Tree tree = new Binary_Tree();
        tree.root  = new Node(20);
        tree.root.left = new Node(10);
        tree.root.right = new Node(25);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(19);
        cibtis.isBST(tree.root);
        System.out.println(flag);

    }

    private void isBST(Node node) {
        if(node == null){
            return;
        }
        if(flag){
            isBST(node.left);
        }
        if(flag){
            if(node.key < lastValue){
                flag = false;
            }
            else {
                lastValue = node.key;
            }
        }
        if(flag){
            isBST(node.right);
        }
    }

}
