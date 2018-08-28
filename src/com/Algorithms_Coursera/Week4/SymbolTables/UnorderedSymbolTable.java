package com.Algorithms_Coursera.Week4.SymbolTables;

import java.util.Iterator;

/**
 * Created by anuj.jain02 on 9/4/17.
 */
public class UnorderedSymbolTable<Key, Value> implements Iterable<Key> {

    Node first;
    int size;

    @Override
    public Iterator<Key> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Key>{

        Node curr = first;

        @Override
        public boolean hasNext() {
            return curr != null;
        }

        @Override
        public Key next() {
            Node next = curr;
            curr = curr.next;
            return (Key) next.key;
        }

        @Override
        public void remove() {
            /*
            not supported
             */
        }
    }

    public class Node<Key, Value>{
        Key key;
        Value value;
        Node next;
    }

    public UnorderedSymbolTable() {
        first = null;
        size = 0;
    }

    public void put(Key key, Value value){
        Node newNode = first;
        if (newNode == null){
            newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            newNode.next = null;
            size++;
            first = newNode;
        }
        else {
            while (newNode.next != null && newNode.key != key) {
                newNode = newNode.next;
            }
            if (newNode.key == key){
                newNode.value = value;
            }
            else {
                Node oldFirst = first;
                newNode = new Node();
                newNode.key = key;
                newNode.value = value;
                newNode.next = null;
                first = newNode;
                first.next = oldFirst;
                size++;
            }
        }
    }

    public Value get(Key key){
        Node node = first;
        while (node != null && node.key != key){
            node = node.next;
        }
        if(node == null){
            return null;
        }
        else {
            return (Value) node.value;
        }
    }

    public void delete(Key key){
        Value val = get(key);
        if(val != null) {
            size--;
            put(key, null);
        }
    }

    public boolean contains(Key key){
        return get(key) != null;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public int size(){
        return size;
    }

    public void print(){
        Node trav = first;
        while (trav != null){
            System.out.println("Key: "+trav.key+" Val: "+trav.value);
            trav = trav.next;
        }
    }

    public static void main(String[] args) {
        UnorderedSymbolTable unorderedSymbolTable = new UnorderedSymbolTable();
        unorderedSymbolTable.put("S",0);
        unorderedSymbolTable.put("E",1);
        unorderedSymbolTable.put("A",2);
        unorderedSymbolTable.put("R",3);
        unorderedSymbolTable.put("C",4);
        unorderedSymbolTable.put("H",5);
        unorderedSymbolTable.put("E",6);
        unorderedSymbolTable.put("X",7);
        unorderedSymbolTable.put("A",8);
        unorderedSymbolTable.put("M",9);
        unorderedSymbolTable.put("P",10);
        unorderedSymbolTable.put("L",11);
        unorderedSymbolTable.put("E",12);

        unorderedSymbolTable.print();

        System.out.println(unorderedSymbolTable.contains("X"));
        System.out.println(unorderedSymbolTable.contains("A"));
        System.out.println(unorderedSymbolTable.contains("B"));
        System.out.println(unorderedSymbolTable.contains("C"));

        System.out.println(unorderedSymbolTable.get("X"));
        System.out.println(unorderedSymbolTable.get("A"));
        System.out.println(unorderedSymbolTable.get("B"));
        System.out.println(unorderedSymbolTable.get("C"));

        unorderedSymbolTable.delete("X");

        System.out.println(unorderedSymbolTable.get("X"));
        System.out.println(unorderedSymbolTable.get("A"));
        System.out.println(unorderedSymbolTable.get("B"));
        System.out.println(unorderedSymbolTable.get("C"));

        Iterator iterator = unorderedSymbolTable.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

}
