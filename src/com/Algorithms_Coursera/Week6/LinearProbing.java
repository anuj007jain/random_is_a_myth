package com.Algorithms_Coursera.Week6;

/**
 * Created by anuj.jain02 on 21/11/17.
 */
public class LinearProbing<Key, Value> {

    final static private int M = 20;

    Node[] st = new Node[M];

    private static class Node {

        private Object key;
        private Object value;

        public Node(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    private int hash(Key key) {
        return (Math.abs(key.hashCode()) & 0x7fffffff) % M;
    }

    private Value get(Key key) {
        int hash = hash(key);
        while (st[hash] != null && !st[hash].key.equals(key)) {
            hash = (hash + 1) % M;
        }
        return st[hash]!= null?(Value) st[hash].value:null;
    }

    private void put(Key key, Value value) {
        int hash = hash(key);
        while (st[hash] != null && !st[hash].key.equals(key)) {
            hash = (hash + 1) % M;
        }
        if(st[hash]!= null) {
            st[hash].value = value;
            return;
        }
        st[hash] = new Node(key, value);
    }

    public static void main(String[] args) {
        LinearProbing linearProbing = new LinearProbing();
        linearProbing.put("S", 0);
        linearProbing.put("E", 1);
        linearProbing.put("A", 2);
        linearProbing.put("R", 3);
        linearProbing.put("C", 4);
        linearProbing.put("H", 5);
        linearProbing.put("E", 6);
        linearProbing.put("X", 7);
        linearProbing.put("A", 8);
        linearProbing.put("M", 9);
        linearProbing.put("P", 10);
        linearProbing.put("L", 11);
        linearProbing.put("E", 12);
        System.out.println(linearProbing.get("R"));
        System.out.println(linearProbing.get("L"));
        System.out.println(linearProbing.get("E"));
        System.out.println(linearProbing.get("X"));
        System.out.println(linearProbing.get("J"));
    }

}
