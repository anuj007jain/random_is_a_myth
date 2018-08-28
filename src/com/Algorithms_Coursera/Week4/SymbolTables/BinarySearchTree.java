package com.Algorithms_Coursera.Week4.SymbolTables;

import java.util.*;

/**
 * Created by anuj.jain02 on 1/5/17.
 */
public class BinarySearchTree<Key extends Comparable, Value> {

    Node head;

    public class Node {
        Key key;
        Value value;
        Node left;
        Node right;
        int count;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }

        public Node(Key key, Value value, int count) {
            this(key, value);
            this.count = count;
        }
    }

    public Value getUsingRecursion(Key key){
        return get(key, head);
    }

    private Value get(Key key, Node node) {
        if(node == null) {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if(cmp < 0) {
            get(key, node.left);
        }
        else if(cmp >0) {
            get(key, node.right);
        }
        else {
            return node.value;
        }
        return null;
    }

    public Value get (Key key){
        Node trav = head;
        while (trav != null && trav.key.compareTo(key) != 0){
            if(trav.key.compareTo(key) < 0){
                trav = trav.right;
            }
            else {
                trav = trav.left;
            }
        }
        return trav == null ? null : trav.value;
    }

    public void putUsingLoop (Key key, Value value){
        Node prev = head, curr = head;
        if(head == null){
            head = new Node(key, value, 1);
            return;
        }
        while (curr != null && curr.key.compareTo(key) != 0){
            prev = curr;
            if(curr.key.compareTo(key) < 0){
                curr = curr.right;
            }
            else {
                curr = curr.left;
            }

        }
        if(curr == null){
            if(prev.key.compareTo(key) < 0){
                prev.right = new Node(key, value, 1);
            }
            else{
                prev.left = new Node(key, value, 1);
            }
            increaseCountOfParentTrees(key);
        }
        else{
            curr.value = value;
        }
    }

    private void increaseCountOfParentTrees(Key key) {
        Node trav = head;
        while(trav != null && trav.key.compareTo(key) != 0) {
            trav.count++;
            if(trav.key.compareTo(key) < 0){
                trav = trav.right;
            } else {
                trav = trav.left;
            }
        }
    }

    private int size(Node node){
        if(node == null){
            return 0;
        }
        return node.count;
    }

    public void putUsingRecursion(Key key, Value value) {
        head = putUsingRecursion(head, key, value);
    }

    private Node putUsingRecursion(Node node, Key key, Value value) {
        if(node == null){
            return new Node(key, value, 1);
        }
        int cmp = node.key.compareTo(key);
        if(cmp < 0){
            node.right = putUsingRecursion(node.right, key, value);
        }
        else if (cmp > 0){
            node.left = putUsingRecursion(node.left, key, value);
        }
        else {
            node.key = key;
        }
        node.count = size(node.left) + size(node.right)  + 1;
        return node;
    }

    private Key floor(Key key){

        Node trav = head;
        Key solutionKey = null;
        while (trav != null && trav.key.compareTo(key) != 0) {
            if(trav.key.compareTo(key) < 0) {
                if(solutionKey == null || solutionKey.compareTo(trav.key) < 0){
                    solutionKey = trav.key;
                }
                trav = trav.right;
            }
            else {
                trav = trav.left;
            }
        }
        if(trav == null){
            return solutionKey;
        }
        else {
            return trav.key;
        }
    }

    private Key floorUsingRecursion(Key key){
        Node x = floorUsingRecursion(head, key);
        if(x == null){
            return null;
        }
        return x.key;
    }

    private Node floorUsingRecursion(Node node, Key key){
        if (node == null){
            return null;
        }
        int cmp = key.compareTo(node.key);
        if(cmp == 0){
            return node;
        }
        else if(cmp < 0){
            return floorUsingRecursion(node.left, key);
        }
        else{
            Node t = floorUsingRecursion(node.right, key);
            if(t != null && t.key.compareTo(node.key) > 0){ // 2nd condition optional because it will always be a better solution
                return t;                                   // if it is not null and comes from the right hand side of the tree
            }
            else{
                return node;
            }
        }
    }

    public void delete(Key key){

        Node trav = head;
        if(trav == null){
            return;
        }
        Node prev = trav;
        while(trav != null && trav.key != key){
            prev = trav;
            if(trav.key.compareTo(key) < 0){
                trav = trav.right;
            }
            else {
                trav = trav.left;
            }
        }
        if(trav == null){
            return;
        }
        else {
            //Node deletedNode = trav;
            if(trav.left == null && trav.right == null){
                if(prev.key.compareTo(key) <  0){
                    prev.right = null;
                }
                else if(prev.key.compareTo(key) > 0){
                    prev.left = null;
                }
                else {
                    head = null;
                }
            }
            else{
                if(trav.right != null) {
                    Node travPrev = trav;
                    trav = trav.right;
                    if (trav.left == null) {
                        trav.left = travPrev.left;
                        if (prev.key.compareTo(key) < 0) {
                            prev.right = trav;
                        } else if (prev.key.compareTo(key) > 0) {
                            prev.left = trav;
                        } else {
                            trav.left = travPrev.left;
                            head = travPrev.right;
                        }
                        return;
                    } else {
                        while (trav.left != null) {
                            travPrev = trav;
                            trav = trav.left;
                        }
                        travPrev.left = trav.right;
                        if (prev.key.compareTo(key) < 0) {
                            prev.right.key = trav.key;
                            prev.right.value = trav.value;
                        } else {
                            prev.left.key = trav.key;
                            prev.left.value = trav.value;
                        }
                    }
                }
                else{
                    prev.left = trav.left;
                }
            }
        }
    }

    private void deleteMin(){
        head = deleteMin(head);
    }

    private Node deleteMin(Node node) {
        if(node.left == null)
            return node.right;
        node.left = deleteMin(node.left);
        node.count = 1 + size(node.left) + size(node.right);
        return node;
    }

    private void deleteUsingRecursion(Key key){
        head = deleteUsingRecursion(head, key);
    }

    private Node deleteUsingRecursion(Node node, Key key) {
        if(node == null){
            return node;
        }
        int cmp = node.key.compareTo(key);
        if(cmp < 0){
            node.right = deleteUsingRecursion(node.right, key);
        }
        else if (cmp > 0){
            node.left = deleteUsingRecursion(node.left, key);
        }
        else {
            if(node.left == null) {
                return node.right;
            }
            else if (node.right == null){
                return node.left;
            }
            else {
                Node temp = min(node.right);
                temp.right = deleteMin(node.right);
                temp.left = node.left;
                node = temp;
            }
        }
        node.count = size(node.left) + size(node.right) + 1;
        return node;
    }

    private Node min(Node node) {
        if(node.left == null)
            return node;
        node = min(node.left);
        return node;
    }

    private int rank(Key key) {
        return rank(head, key);
    }

    private int rank(Node node, Key key) { //node = S, key = E
        if(node == null){
            return 0;
        }
        int cmp = node.key.compareTo(key);
        if(cmp < 0){
            return 1 + size(node.left) + rank(node.right, key);
        }
        else if(cmp > 0){
            return rank(node.left, key);
        }
        else {
            return size(node.left);
        }
    }

    private Iterable<Key> keys(){
        Queue<Key> queue = new LinkedList();
        inorder(head, queue);
        return queue;
    }

    private void inorder(Node node, Queue<Key> queue) {
        if(node.left != null){
            inorder(node.left, queue);
        }
        queue.add(node.key);
        if(node.right != null){
            inorder(node.right, queue);
        }
    }

    public Key ceiling(Key key) {
        return ceiling(head, key);
    }

    private Key ceiling(Node node, Key key) {

        if(node == null){
            return null;
        }
        int cmp = node.key.compareTo(key);
        if(cmp < 0) {
            return ceiling(node.right, key);
        }
        else if(cmp > 0) {
            Key t = ceiling(node.left, key);
            if(t == null){
                return node.key;
            }
            return t;
        }
        else return node.key;
    }

    public int rangeCount(Key lo, Key hi) {
        if(contains(hi)){
            return rank(hi) - rank(lo) + 1 > 0 ? rank(hi) - rank(lo) + 1 : 0;
        }
        return rank(hi) - rank(lo) > 0 ? rank(hi) - rank(lo) : 0;
    }

    private boolean contains(Key key) {
        return get(key) != null;
    }

    public List<Key> rangeSearch(Key lo, Key hi) {
        List<Key> rangeSearchKeys = new ArrayList<>();
        rangeSearchUtil(head, lo, hi, rangeSearchKeys);
        return rangeSearchKeys;
    }

    private void rangeSearchUtil(Node node, Key lo, Key hi, List<Key> rangeSearchKeys) {
        if(node == null){
            return;
        }
        int lowCompare = node.key.compareTo(lo);
        int highCompare = node.key.compareTo(hi);
        if(lowCompare >= 0 && highCompare <= 0){
            rangeSearchKeys.add(node.key);
            rangeSearchUtil(node.left, lo, hi, rangeSearchKeys);
            rangeSearchUtil(node.right, lo, hi, rangeSearchKeys);
        }
        else if(lowCompare >= 0) {
            rangeSearchUtil(node.left, lo, hi, rangeSearchKeys);
        }
        else if(highCompare <= 0) {
            rangeSearchUtil(node.right, lo, hi, rangeSearchKeys);
        }
        else return;
    }

    public static void main(String[] args) {

        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.putUsingLoop("S", 0);
        binarySearchTree.putUsingLoop("E", 1);
        binarySearchTree.putUsingLoop("A", 2);
        binarySearchTree.putUsingLoop("R", 3); //                       S
        binarySearchTree.putUsingLoop("C", 4); //                    E     X
        binarySearchTree.putUsingLoop("H", 5); //                 A    R
        binarySearchTree.putUsingLoop("E", 6); //                  C  H
        binarySearchTree.putUsingLoop("X", 7); //                      M
        binarySearchTree.putUsingLoop("A", 8); //                     L P
        binarySearchTree.putUsingLoop("M", 9);
        binarySearchTree.putUsingLoop("P", 10);
        binarySearchTree.putUsingLoop("L", 11);
        binarySearchTree.putUsingLoop("E", 12);

        System.out.println(binarySearchTree.rangeCount("Y","A"));
        System.out.println(binarySearchTree.rangeSearch("Y","A"));

        /*BinarySearchTree binarySearchTree2 = new BinarySearchTree();
        binarySearchTree2.putUsingRecursion("S", 0);
        binarySearchTree2.putUsingRecursion("E", 1);
        binarySearchTree2.putUsingRecursion("A", 2);
        binarySearchTree2.putUsingRecursion("R", 3);
        binarySearchTree2.putUsingRecursion("C", 4);
        binarySearchTree2.putUsingRecursion("H", 5);
        binarySearchTree2.putUsingRecursion("E", 6);
        binarySearchTree2.putUsingRecursion("X", 7);
        binarySearchTree2.putUsingRecursion("A", 8);
        binarySearchTree2.putUsingRecursion("M", 9);
        binarySearchTree2.putUsingRecursion("P", 10);
        binarySearchTree2.putUsingRecursion("L", 11);
        binarySearchTree2.putUsingRecursion("E", 12);

        System.out.println("Ceiling for G: "+binarySearchTree.ceiling("G"));
        System.out.println("Ceiling for S: "+binarySearchTree.ceiling("S"));
        System.out.println("Ceiling for Y: "+binarySearchTree.ceiling("Y"));
        System.out.println("Ceiling for B: "+binarySearchTree.ceiling("B"));
        System.out.println("Ceiling for I: "+binarySearchTree.ceiling("I"));

        System.out.println();

        System.out.println("Min node: "+(binarySearchTree2
        .min(binarySearchTree2.head.left.right).key));

        System.out.println("Getting without recursion for A: "+binarySearchTree.get("A"));
        System.out.println("Getting without recursion for R: "+binarySearchTree.get("R"));
        System.out.println("Getting without recursion for Z: "+binarySearchTree.get("Z"));
        System.out.println("Getting without recursion for P: "+binarySearchTree.get("P"));

        System.out.println("Getting with recursion for A: "+binarySearchTree.getUsingRecursion("A"));
        System.out.println("Getting with recursion for R: "+binarySearchTree.getUsingRecursion("R"));
        System.out.println("Getting with recursion for Z: "+binarySearchTree.getUsingRecursion("Z"));
        System.out.println("Getting with recursion for P: "+binarySearchTree.getUsingRecursion("P"));
        System.out.println(binarySearchTree.floor("G"));
        System.out.println(binarySearchTree.floor("S"));
        System.out.println(binarySearchTree.floor("Y"));
        System.out.println(binarySearchTree.floor("B"));
        System.out.println(binarySearchTree.floor("I"));

        System.out.println();

        System.out.println(binarySearchTree.floorUsingRecursion("G"));
        System.out.println(binarySearchTree.floorUsingRecursion("S"));
        System.out.println(binarySearchTree.floorUsingRecursion("Y"));
        System.out.println(binarySearchTree.floorUsingRecursion("B"));
        System.out.println(binarySearchTree.floorUsingRecursion("I"));

        System.out.println(binarySearchTree.rank("Z"));

        Iterator iterator = binarySearchTree.keys().iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next()+" ");
        }
        System.out.println();
        binarySearchTree.deleteUsingRecursion("H");
        binarySearchTree.deleteUsingRecursion("A");
        binarySearchTree.deleteUsingRecursion("R");
        iterator = binarySearchTree.keys().iterator();
        while(iterator.hasNext()) {
            System.out.print(iterator.next()+" ");
        }*/
    }
}