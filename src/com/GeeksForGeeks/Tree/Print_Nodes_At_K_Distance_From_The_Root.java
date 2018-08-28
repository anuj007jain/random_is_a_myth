package com.GeeksForGeeks.Tree;

/**
 * Created by anuj.jain02 on 4/6/16.
 */

//http://www.geeksforgeeks.org/print-nodes-at-k-distance-from-root/
public class Print_Nodes_At_K_Distance_From_The_Root {

    private void print(Node node,int distance,int k){

        if(distance == k)
            System.out.print(node.key);
        if(node.left!=null)
            print(node.left,distance+1,k);
        if(node.right!=null)
            print(node.right,distance+1,k);

    }

    public static void main(String[] args) {

        Print_Nodes_At_K_Distance_From_The_Root pnakdftr = new Print_Nodes_At_K_Distance_From_The_Root();
        Binary_Tree tree = new Binary_Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);
        pnakdftr.print(tree.root,0,0);

    }

}
