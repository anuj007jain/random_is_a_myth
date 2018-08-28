package com.Repeat_Practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by anuj.jain02 on 27/8/17.
 */
class Reverse_Level_Order_Traversal_For_BST {

    public BSTNode root;

    class BSTNode {
        private int key;
        private BSTNode left;
        private BSTNode right;

        public BSTNode(int key){
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }

    public void insertNodeInBst(int key) {
        root = insertNodeInBst(root, key);
    }

    public BSTNode insertNodeInBst(BSTNode node, int key){

        if(node == null){
            System.out.println("Creating new node with key: "+key);
            return new BSTNode(key);
        }
        System.out.println("Inserting key: "+key+" on node: "+node.key);
        if(node.key > key){
            System.out.println("Recursive call: going left: "+node.left);
            node.left = insertNodeInBst(node.left, key);
        }
        else if(node.key < key){
            System.out.println("Recursive call: going right: "+node.right);
            node.right = insertNodeInBst(node.right, key);
        }
        System.out.println("Returning node: with key: "+node.key+" left: "+node.left+" right:"+node.right);
        return node;
    }

    public void printInorderTraversal(){
        printInorderTraversal(root);
    }

    public void printInorderTraversal(BSTNode node){
        if(node == null){
            return;
        }
        printInorderTraversal(node.left);
        System.out.print(node.key);
        printInorderTraversal(node.right);
    }

    void reverseLevelOrder(BSTNode node)
    {
        Stack<BSTNode> S = new Stack();
        Queue<BSTNode> Q = new LinkedList();
        Q.add(node);

        // Do something like normal level order traversal order.Following
        // are the differences with normal level order traversal
        // 1) Instead of printing a node, we push the node to stack
        // 2) Right subtree is visited before left subtree
        while (Q.isEmpty() == false)
        {
            /* Dequeue node and make it root */
            node = Q.peek();
            Q.remove();
            S.push(node);

            /* Enqueue right child */
            if (node.right != null)
                // NOTE: RIGHT CHILD IS ENQUEUED BEFORE LEFT
                Q.add(node.right);

            /* Enqueue left child */
            if (node.left != null)
                Q.add(node.left);
        }

        // Now pop all items from stack one by one and print them
        while (S.empty() == false)
        {
            node = S.peek();
            System.out.print(node.key + " ");
            S.pop();
        }
    }

    public static void main(String args[] ) throws Exception {

        // Read input from stdin and provide input before running
        // Use either of these methods for input

        //BufferedReader
        String line = "5 4 2 9 1";
        String[] elements = line.split(" ");
        System.out.println("elements: "+ Arrays.asList(elements));
        Reverse_Level_Order_Traversal_For_BST testClass = new Reverse_Level_Order_Traversal_For_BST();
        for(int i = 0 ; i < elements.length ; i++){
            System.out.println("Inserting: "+Integer.parseInt((elements[i])));
            testClass.insertNodeInBst(Integer.valueOf(elements[i]));
            testClass.printInorderTraversal();
        }
        //Scanner
        //Scanner s = new Scanner(System.in);
        //int N = s.nextInt();
        testClass.reverseLevelOrder();
        System.out.println("Hello World!");
    }

    private void reverseLevelOrder() {
        reverseLevelOrder(root);
    }
}
