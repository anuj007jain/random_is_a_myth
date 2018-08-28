package com.GeeksForGeeks.Tree;

/**
 * Created by anuj.jain02 on 3/6/16.
 */

//http://www.geeksforgeeks.org/diameter-of-a-binary-tree/

/**
 * The diameter of a tree T is the largest of the following quantities:

 * the diameter of T’s left subtree
 * the diameter of T’s right subtree
 * the longest path between leaves that goes through the root of T (this can be computed from the heights of the subtrees of T)
 */
public class Diameter_Of_A_Binary_Tree {

    private int diameter(Node node){

        if(node == null)
            return 0;

        int lh = height(node.left);
        int rh = height(node.right);

        int ld = diameter(node.left);
        int rd = diameter(node.right);

        return (Math.max(Math.max(ld,rd),lh+rh+1));

    }

    private int height(Node node){
        if(node == null)
            return 0;
        else
            return 1+Math.max(height(node.left),height(node.right));
    }

    public static void main(String[] args) {

        Diameter_Of_A_Binary_Tree doabt = new Diameter_Of_A_Binary_Tree();
        Binary_Tree tree = new Binary_Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);
        tree.root.left.right.left = new Node(7);
        tree.root.left.right.right = new Node(8);
        tree.root.right.right.right= new Node(9);
        tree.root.right.right.right.left = new Node(10);
        tree.root.right.right.right.right = new Node(11);
        tree.root.right.right.right.left.left = new Node(12);
        tree.root.right.right.right.left.right = new Node(13);
        int diameter = doabt.diameter(tree.root);
        System.out.print(diameter);

    }

}
