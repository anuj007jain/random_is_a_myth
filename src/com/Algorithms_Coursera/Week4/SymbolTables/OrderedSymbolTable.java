package com.Algorithms_Coursera.Week4.SymbolTables;

import java.util.Iterator;

/**
 * Created by anuj.jain02 on 9/4/17.
 */
public class OrderedSymbolTable<Key extends Comparable<Key>, Value> implements Iterable<Key> {

    Key[] keys ;
    Value[] values ;
    int size;

    public OrderedSymbolTable() {
        keys = (Key[]) new Comparable[100];
        values = (Value[]) new Comparable[100];
        size = 0;
    }

    public void put(Key key, Value value){
        int k = binarySearch(key);
        if(k != -1){
            values[k] = value;
        }
        else {
            for(k = size ; k > 0 ; k--){
                if(keys[k-1].compareTo(key) < 0){
                    break;
                }
                keys[k] = keys[k-1];
                values[k] = values[k-1];
            }
            keys[k] = key;
            values[k] = value;
            size++;
        }
    }

    private Value get(Key key){
        int i = binarySearch(key);
        if(i == -1){
            return null;
        }
        return values[i];
    }

    private int binarySearch(Key key) {
        int lo = 0, hi = size-1;
        while (lo <= hi){
            int mid = (lo+hi)/2;
            if(key.compareTo(keys[mid]) < 0){
                hi = mid-1;
            }
            else if(key.compareTo(keys[mid]) > 0){
                lo = mid+1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    private void print(){
        for(int i = 0 ; i < size ; i++){
            System.out.print("Key: "+keys[i]);
            System.out.println(" Value: "+values[i]);
        }
    }

    @Override
    public Iterator<Key> iterator() {
        return null;
    }

    public static void main(String[] args) {
        OrderedSymbolTable orderedSymbolTable = new OrderedSymbolTable();
        orderedSymbolTable.put("S",0);
        orderedSymbolTable.put("E",1);
        orderedSymbolTable.put("A",2);
        orderedSymbolTable.put("R",3);
        orderedSymbolTable.put("C",4);
        orderedSymbolTable.put("H",5);
        orderedSymbolTable.put("E",6);
        orderedSymbolTable.put("X",7);
        orderedSymbolTable.put("A",8);
        orderedSymbolTable.put("M",9);
        orderedSymbolTable.put("P",10);
        orderedSymbolTable.put("L",11);
        orderedSymbolTable.put("E",12);

        orderedSymbolTable.print();

        System.out.println(orderedSymbolTable.get("A"));
        System.out.println(orderedSymbolTable.get("R"));
        System.out.println(orderedSymbolTable.get("Z"));
    }
}
