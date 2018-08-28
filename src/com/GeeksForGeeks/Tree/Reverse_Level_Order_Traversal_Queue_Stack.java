package com.GeeksForGeeks.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by anuj on 9/5/16.
 */
public class Reverse_Level_Order_Traversal_Queue_Stack {

    private void printReverseLevelOrderTraversal(Node node){
        Queue<Node> queue = new LinkedList();
        Stack<Node> stack = new Stack();
        queue.add(node);
        while(!queue.isEmpty()){
            if(queue.peek().right!=null)
                queue.add(queue.peek().right);
            if(queue.peek().left!=null)
                queue.add(queue.peek().left);
            stack.push(queue.poll());
        }
        while(!stack.empty())
            System.out.print(stack.pop().key+" ");
    }

    public static void main(String[] args) {

        Reverse_Level_Order_Traversal_Queue_Stack rlotqs = new Reverse_Level_Order_Traversal_Queue_Stack();
        Binary_Tree tree = new Binary_Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        rlotqs.printReverseLevelOrderTraversal(tree.root);

    }

}
