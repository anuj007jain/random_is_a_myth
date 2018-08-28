package com.GeeksForGeeks.Tree;

/**
 * Created by anuj on 25/4/16.
 */



class TreeTraversal {

    Node root;

    TreeTraversal(int key) {
        root = new Node(key);
    }

    TreeTraversal() {
        root = null;
    }

    private void printPreOrder(Node node){

        if(node == null)
            return;

        System.out.print(node.key + " ");

        printPreOrder(node.left);

        printPreOrder(node.right);
    }

    private void printInOrder(Node node){

        if(node == null)
            return;

        printInOrder(node.left);

        System.out.print(node.key + " ");

        printInOrder(node.right);
    }

    private void printPostOrder(Node node){

        if(node == null)
            return;

        printPostOrder(node.left);

        printPostOrder(node.right);

        System.out.print(node.key + " ");
    }


    public static void main(String[] args) {
        TreeTraversal tree = new TreeTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.println("PreOrder Traversal:");
        tree.printPreOrder(tree.root);

        System.out.println();
        System.out.println("InOrder Traversal:");
        tree.printInOrder(tree.root);

        System.out.println();
        System.out.println("PostOrder Traversal:");
        tree.printPostOrder(tree.root);
    }
}