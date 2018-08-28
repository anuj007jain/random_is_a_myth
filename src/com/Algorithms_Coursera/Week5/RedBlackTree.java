package com.Algorithms_Coursera.Week5;

/**
 * Created by anuj.jain02 on 24/8/17.
 */
public class RedBlackTree<Key extends Comparable, Value> {

    private static final Boolean RED = true;
    private static final Boolean BLACK = false;
    public RedBlackNode root;

    public class RedBlackNode {

        Key key;
        Value value;
        RedBlackNode left;
        RedBlackNode right;
        Boolean color;

        public RedBlackNode(Key key, Value value, Boolean red) {
            this.key = key;
            this.value = value;
            this.color = red;
        }
    }

    public Value get(Key key) {
        RedBlackNode trav = root;
        while(trav != null && trav.key.compareTo(key) != 0){
            if(trav.key.compareTo(key) < 0){
                trav = trav.right;
            }
            else {
                trav = trav.left;
            }
        }
        return trav == null ? null : trav.value;
    }

    public Key ceiling(Key key) {
        return ceiling(root, key);
    }

    private Key ceiling(RedBlackNode node, Key key) {

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

    public Boolean isRed(RedBlackNode node) {
        if(node == null) //null links are black
            return false;
        return node.color == RED;
    }

    private RedBlackNode rotateLeft(RedBlackNode node) {
        RedBlackNode temp = node.right;
        node.right = temp.left;
        temp.left = node;
        temp.color = node.color;
        node.color = RED;
        return temp;
    }

    private RedBlackNode rotateRight(RedBlackNode node) {
        RedBlackNode temp = node.left;
        node.left = temp.right;
        temp.right = node;
        temp.color = node.color;
        node.color = RED;
        return temp;
    }

    private void flipColors(RedBlackNode node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    private void put(Key key, Value value){
        root = put(root, key, value);
    }

    private RedBlackNode put(RedBlackNode node, Key key, Value value) {
        if(node == null){
            return new RedBlackNode(key, value, RED);
        }
        int cmp = key.compareTo(node.key);
        if(cmp < 0) {
            node.left = put(node.left, key, value);
        }
        else if (cmp > 0) {
            node.right = put(node.right, key, value);
        }
        else {
            node.value = value;
        }

        if(!isRed(node.left) && isRed(node.right)){
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)){
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)){
            flipColors(node);
        }
        return node;
    }

    public static void main(String[] args) {
        RedBlackTree redBlackTree = new RedBlackTree();
        redBlackTree.put("S", 0);
        redBlackTree.put("E", 1);
        redBlackTree.put("A", 2);
        redBlackTree.put("R", 3);
        redBlackTree.put("C", 4);
        redBlackTree.put("H", 5);
        redBlackTree.put("E", 6);
        redBlackTree.put("X", 7);
        redBlackTree.put("A", 8);
        redBlackTree.put("M", 9);
        redBlackTree.put("P", 10);
        redBlackTree.put("L", 11);
        redBlackTree.put("E", 12);
        redBlackTree.put("I", 13);
    }

}
