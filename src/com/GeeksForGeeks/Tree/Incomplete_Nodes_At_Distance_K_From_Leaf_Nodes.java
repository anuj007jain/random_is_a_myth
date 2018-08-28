package com.GeeksForGeeks.Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by anuj on 10/5/16.
 */
public class Incomplete_Nodes_At_Distance_K_From_Leaf_Nodes {

    Map<Integer,Integer> map = new HashMap<>();

    private void printNodesAtDistanceKFromLeafNodes(Node node, int k, int count){
        map.put(node.key,count);
        if(node.left!=null){
            count++;
            printNodesAtDistanceKFromLeafNodes(node.left,k,count);
        }
        count--;
        if(node.right!=null){
            count++;
            printNodesAtDistanceKFromLeafNodes(node.right,k,count);
        }
    }


    public static void main(String[] args) {

        Incomplete_Nodes_At_Distance_K_From_Leaf_Nodes nadkfln = new Incomplete_Nodes_At_Distance_K_From_Leaf_Nodes();
        Binary_Tree tree = new Binary_Tree();
        tree.root = new Node(1);
        tree.root.left =  new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);
        nadkfln.printNodesAtDistanceKFromLeafNodes(tree.root,1,0);

    }

}
