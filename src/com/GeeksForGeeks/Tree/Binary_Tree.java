package com.GeeksForGeeks.Tree;

/**
 * Created by anuj on 22/4/16.
 */


public class Binary_Tree {

    public Node root;

    Binary_Tree(int key) {
        root = new Node(key);
    }

    public Binary_Tree() {
        root = null;
    }


    public static void main(String[] args) {
        Binary_Tree tree = new Binary_Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

    }
}