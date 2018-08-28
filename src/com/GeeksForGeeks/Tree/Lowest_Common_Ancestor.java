package com.GeeksForGeeks.Tree;

/**
 * Created by anuj.jain02 on 30/7/16.
 */
//http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
public class Lowest_Common_Ancestor {

    private Node findLCA(Node node, int key1, int key2){

        if(node == null) {
            return null;
        }

        if(node.key == key1 || node.key == key2)
            return node;

        Node leftSubTree = findLCA(node.left, key1, key2);
        Node rightSubTree = findLCA(node.right, key1, key2);
        if(leftSubTree != null && rightSubTree != null) {
            return node;
        }
        else if(leftSubTree != null)
            return findLCA(node.left, key1, key2);
        else
            return findLCA(node.right, key1, key2);

    }

    public static void main(String[] args) {

        Lowest_Common_Ancestor lca = new Lowest_Common_Ancestor();
        Binary_Tree tree = new Binary_Tree();
        tree.root = new Node(50);
        tree.root.left = new Node(40);
        tree.root.right = new Node(70);
        tree.root.left.left = new Node(26);
        tree.root.left.right = new Node(45);
        tree.root.right.left = new Node(63);
        tree.root.right.right = new Node(82);
        tree.root.right.left.left = new Node(58);
        tree.root.right.left.right = new Node(67);
        Node node = lca.findLCA(tree.root, 45, 58);
        System.out.print(node.key);

    }

}
