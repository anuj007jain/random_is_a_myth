package com.GeeksForGeeks.Tree;

import java.util.Stack;

/**
 * Created by anuj on 20/5/16.
 */

//http://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/
public class Print_ZigZag_Traversal_Of_Binary_Tree
{
    private void printZigzagTraversal(Node node){

        Stack<Node> s1 = new Stack();
        Stack<Node> s2 = new Stack();
        s1.push(node);
        if(!s1.empty() || !s2.empty()) {
            while (!s1.empty()) {
                if(s1.peek().right!=null)
                    s2.push(s1.peek().right);
                if(s1.peek().left!=null)
                    s2.push(s1.peek().left);
                System.out.print(s1.pop().key+" ");
            }
            while (!s2.empty()) {
                if(s2.peek().left!=null)
                    s1.push(s2.peek().left);
                if(s2.peek().right!=null)
                    s1.push(s2.peek().right);
                System.out.print(s2.pop().key+" ");
            }
        }

    }

    public static void main(String[] args) {

        Print_ZigZag_Traversal_Of_Binary_Tree pztobt = new Print_ZigZag_Traversal_Of_Binary_Tree();
        Binary_Tree tree = new Binary_Tree();
        tree.root = new Node(30);
        tree.root.left = new Node(20);
        tree.root.right = new Node(40);
        tree.root.left.left = new Node(15);
        tree.root.left.right = new Node(25);
        tree.root.right.left = new Node(37);
        tree.root.right.right = new Node(45);
        pztobt.printZigzagTraversal(tree.root);

    }

}
