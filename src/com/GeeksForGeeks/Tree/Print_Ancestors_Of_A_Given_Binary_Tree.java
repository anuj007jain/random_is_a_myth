package com.GeeksForGeeks.Tree;

/**
 * Created by anuj.jain02 on 4/6/16.
 */

//http://www.geeksforgeeks.org/print-ancestors-of-a-given-node-in-binary-tree/
public class Print_Ancestors_Of_A_Given_Binary_Tree {

    boolean flag = false;
    private void printAncestors(Node node, int key,Node root){

        if(flag == true && node == root)
            return;

        if(node.key == key) {
            flag = true;
            return;
        }

        if(node.left!=null && !flag)
            printAncestors(node.left,key,root);

        if(node.right!=null && !flag)
            printAncestors(node.right,key,root);

        if(flag)
            System.out.print(node.key);


    }

    public static void main(String[] args) {

        Print_Ancestors_Of_A_Given_Binary_Tree paoagbt = new Print_Ancestors_Of_A_Given_Binary_Tree();
        Binary_Tree tree = new Binary_Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(6);
        paoagbt.printAncestors(tree.root,3,tree.root);


    }

}
