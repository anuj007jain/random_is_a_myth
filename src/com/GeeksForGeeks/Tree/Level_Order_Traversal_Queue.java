package com.GeeksForGeeks.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by anuj on 7/5/16.
 */
public class Level_Order_Traversal_Queue
{

    private void printLevelOrderTraversal(Binary_Tree tree){

        Queue<Node> queue = new LinkedList<>();
        queue.add(tree.root);
        while(!queue.isEmpty()){
            System.out.print(queue.peek().key);
            if(queue.peek().left!=null)
                queue.add(queue.peek().left);
            if(queue.peek().right!=null)
                queue.add(queue.peek().right);
            queue.poll();
        }

}

    public static void main(String[] args) {

        Level_Order_Traversal_Queue lotq = new Level_Order_Traversal_Queue();
        Binary_Tree tree = new Binary_Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.right = new Node(6);
        lotq.printLevelOrderTraversal(tree);


    }

}
