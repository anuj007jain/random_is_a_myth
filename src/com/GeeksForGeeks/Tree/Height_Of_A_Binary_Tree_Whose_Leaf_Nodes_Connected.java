package com.GeeksForGeeks.Tree;

/**
 * Created by anuj.jain02 on 18/8/16.
 */
//http://www.geeksforgeeks.org/find-height-of-a-special-binary-tree-whose-leaf-nodes-are-connected/
public class Height_Of_A_Binary_Tree_Whose_Leaf_Nodes_Connected {

    private boolean isLeaf(Node node){
        if(node.left != null && node.right != null && node.left.right != null && node.right.left != null && node.equals(node.left.right) && node.equals(node.right.left)){
            return true;
        }
        return false;
    }

    private int findHeight(Node node) {

        if(isLeaf(node))
            return 1;

        if(node.left != null)
            return 1+findHeight(node.left);

        if(node.right != null)
            return 1+findHeight(node.right);

        return Math.max(findHeight(node.left), findHeight(node.right));

    }

    public static void main(String[] args) {

        Height_Of_A_Binary_Tree_Whose_Leaf_Nodes_Connected hoabtwlnc = new Height_Of_A_Binary_Tree_Whose_Leaf_Nodes_Connected();
        Binary_Tree tree = new Binary_Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.left.left = new Node(6);
        tree.root.right.left = tree.root.left.right;
        tree.root.right.right = tree.root.left.left.left;
        tree.root.left.right.left = tree.root.left.left.left;
        tree.root.left.right.right = tree.root.right;
        tree.root.left.left.left.left = tree.root.right;
        tree.root.left.left.left.right = tree.root.left.right;
        System.out.print(hoabtwlnc.findHeight(tree.root));
    }
}
