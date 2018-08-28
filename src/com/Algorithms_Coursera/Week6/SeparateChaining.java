package com.Algorithms_Coursera.Week6;

/**
 * Created by anuj.jain02 on 21/11/17.
 */
public class SeparateChaining<Key, Value> {

    private final static int M = 4;

    private Node[] st = new Node[M];

    private static class Node {
        private Object key;
        private Object value;
        private Node next;

        public Node(Object key, Object value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    private int hash(Key key) {
        return (Math.abs(key.hashCode()) & 0x7fffffff) % M;
    }

    private Value get (Key key) {
        int hash = hash(key);
        Node node = st[hash];
        while (node != null) {
            if(node.key.equals(key)) {
                return (Value) node.value;
            }
            node = node.next;
        }
        return null;
    }

    private void put(Key key, Value value) {
        int hash = hash(key);
        Node node = st[hash];
        while (node != null) {
            if(node.equals(key)) {
                node.value = value;
                return;
            }
            node = node.next;
        }
        st[hash] = new Node(key, value, st[hash]);
    }

    public static void main(String[] args) {
        SeparateChaining separateChaining = new SeparateChaining();
        separateChaining.put("S", 0);
        separateChaining.put("E", 1);
        separateChaining.put("A", 2);
        separateChaining.put("R", 3);
        separateChaining.put("C", 4);
        separateChaining.put("H", 5);
        separateChaining.put("E", 6);
        separateChaining.put("X", 7);
        separateChaining.put("A", 8);
        separateChaining.put("M", 9);
        separateChaining.put("P", 10);
        separateChaining.put("L", 11);
        separateChaining.put("E", 12);
        System.out.println(separateChaining.get("R"));
        System.out.println(separateChaining.get("L"));
        System.out.println(separateChaining.get("E"));
        System.out.println(separateChaining.get("X"));
    }

}
