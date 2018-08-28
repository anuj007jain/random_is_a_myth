package com.Algorithms_2_Coursera.Week2.MinimumSpanningTrees;

import java.util.Iterator;

/**
 * Created by anuj.jain02 on 30/4/18.
 */
public class MinPriorityQueue<Key extends Comparable> implements Iterable {

    private Key[] queue;
    private int size;

    public MinPriorityQueue() {
        queue = (Key[]) new Comparable[1];
        size = 0;
    }

    public void swim(int k) {
        while (k/2 > 0) {
            Key parent = queue[k/2];
            if(parent.compareTo(queue[k]) > 0) {
                swap(k/2, k);
                k = k/2;
            } else {
                break;
            }
        }
    }

    public void sink(int k) {
        while (k <= size/2) {
            int child1position = k*2;
            int child2position = k*2+1;
            int smallerChild = k*2;
            if(k*2 < size) { // to check if child2 exists (null check)
                if(less(child2position, child1position)) {
                    smallerChild = k*2+1;
                }
            }
            if(less(smallerChild, k)) {
                swap(smallerChild, k);
                k = smallerChild;
            } else {
                break;
            }
        }
    }

    public void insert(Key k) {
        if(queue.length == size+1) {
            resize(queue.length*2);
        }
        queue[++size] = k;
        swim(size);
    }

    private void resize(int newSize) {
        Key[] temp = (Key[]) new Comparable[newSize];
        for(int i = 0 ; i <= size() ; i++) {
            temp[i] = queue[i];
        }
        queue = temp;
    }

    public Key delMin() {
        Key deletedKey = queue[1];
        swap(1, size--);
        sink(1);
        queue[size+1] = null;
        if(size > 0 && size < queue.length/4) {
            resize(queue.length/2);
        }
        return deletedKey;
    }

    private void swap(int i, int j) {
        Key temp = queue[i];
        queue[i] = queue[j];
        queue[j] = temp;
    }

    public int size() {
        return size;
    }

    public boolean less(int i, int j) {
        return queue[i].compareTo(queue[j]) < 0;
    }

    @Override
    public Iterator iterator() {
        return new HeapIterator();
    }

    public class HeapIterator implements Iterator{

        MinPriorityQueue copy = new MinPriorityQueue();

        public HeapIterator() {
            for(int i = 1 ; i <= size ; i++) {
                copy.insert(queue[i]);
            }
        }

        @Override
        public boolean hasNext() {
            return copy.size > 0;
        }

        @Override
        public Comparable next() {
            return copy.delMin();
        }
    }

    public static void main(String[] args) {
        MinPriorityQueue minPQ = new MinPriorityQueue();
        minPQ.insert(3);
        minPQ.insert(2);
        minPQ.insert(5);
        minPQ.insert(1);
        //minPQ.delMin();
        Iterator iterator = minPQ.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+" ");
        }
        System.out.println();
        iterator = minPQ.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next()+" ");
        }
    }
}
