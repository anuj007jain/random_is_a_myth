package com.GeeksForGeeks.Tree;

import java.util.LinkedList;

/**
 * Created by anuj.jain02 on 30/7/16.
 */
public class Find_Path_Till_A_Given_Node {

    LinkedList linkedList = new LinkedList();

    private void findPath(Node node, Node givenNode){

        linkedList.push(node.key);

        if(node.key == givenNode.key){
            System.out.print(linkedList);
        }
        if(node.left != null)
            findPath(node.left, givenNode);
        if(node.right != null)
            findPath(node.right, givenNode);

        linkedList.pop();

    }

    public static void main(String[] args) {

        Find_Path_Till_A_Given_Node fptagn = new Find_Path_Till_A_Given_Node();
        Binary_Tree tree = new Binary_Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        fptagn.findPath(tree.root, tree.root.right.right);

    }

}
