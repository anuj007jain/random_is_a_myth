package com.GeeksForGeeks.Tree;

/**
 * Created by anuj on 25/4/16.
 */
public class Node{
    public int key;
    public Node left;
    public Node right;

    public Node(int item){
        key = item;
        left = right = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Node node = (Node) o;

        if (key != node.key) return false;
        if (!left.equals(node.left)) return false;
        return right.equals(node.right);

    }

    @Override
    public int hashCode() {
        int result = key;
        result = 31 * result + left.hashCode();
        result = 31 * result + right.hashCode();
        return result;
    }
}