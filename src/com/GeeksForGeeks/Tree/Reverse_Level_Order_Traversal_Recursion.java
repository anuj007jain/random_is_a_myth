package com.GeeksForGeeks.Tree;

/**
 * Created by anuj on 9/5/16.
 */
public class Reverse_Level_Order_Traversal_Recursion {

    private void printLevelOrderTraversal(Node node){

        if(node.left != null)
            printLevelOrderTraversal(node.left);
        if(node.right != null)
            printLevelOrderTraversal(node.right);
        System.out.print(node.key);

    }

    public static void main(String[] args) {

        Reverse_Level_Order_Traversal_Recursion rlotr = new Reverse_Level_Order_Traversal_Recursion();
        Binary_Tree tree = new Binary_Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        rlotr.printLevelOrderTraversal(tree.root);

    }

}
