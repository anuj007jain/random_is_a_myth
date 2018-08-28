package com.GeeksForGeeks.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by anuj on 7/5/16.
 */

public class Connect_Nodes_At_Same_Level {


    private static class Node{
        int key;
        Node left;
        Node right;
        int level;

        Node(int key){
            this.key = key;
            this.left=null;
            this.right=null;


        }
    }

    private static class Binary_Tree {

        Node root;

        Binary_Tree(int key) {
            root = new Node(key);
        }

        Binary_Tree() {
            root = null;
        }

        }

    private void connectNodesAtSameLevel(Binary_Tree tree){
        Queue<Node> queue = new LinkedList<>();
        int level = 1;
        tree.root.level=1;
        queue.add(tree.root);
        while(!queue.isEmpty()){
            while(queue.peek().level == level){
                if(queue.peek().left!=null) {
                    queue.peek().left.level = level + 1;
                    queue.add(queue.peek().left);
                }
                if(queue.peek().right!=null) {
                    queue.peek().right.level = level + 1;
                    queue.add(queue.peek().right);
                }
                Node temp = queue.poll();
                Node next = queue.peek();
                if(next.level == level)
                    temp.right=next;
                else
                    temp.right=null;
            }
        level++;
        }

    }


    public static void main(String[] args) {
        Connect_Nodes_At_Same_Level cnatl = new Connect_Nodes_At_Same_Level();
        Binary_Tree tree = new Binary_Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        cnatl.connectNodesAtSameLevel(tree);


    }

}
