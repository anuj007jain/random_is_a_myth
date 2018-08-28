package com.GeeksForGeeks.Tree;

/**
 * Created by anuj.jain02 on 17/6/16.
 */
public class Invert_A_Binary_Tree_Using_Keys {

    private void invertTree(Binary_Tree tree,Node node){

        if(node.left == null && node.right == null)
            return;
        int temp = node.left.key;
        node.left.key = node.right.key;
        node.right.key = temp;
        invertTree(tree, node.left);
        invertTree(tree, node.right);

    }

    public static void main(String[] args) {

        Invert_A_Binary_Tree_Using_Keys iabtuk = new Invert_A_Binary_Tree_Using_Keys();
        Binary_Tree tree = new Binary_Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        iabtuk.invertTree(tree,tree.root);


    }

}
