package com.Algorithms_Coursera.Week4.PriorityQueues;

/**
 * Created by anuj.jain02 on 19/3/17.
 */
public class BinaryHeap<Key extends Comparable<Key>> {

    private Key[] priorityQueue;
    private int size;

    public BinaryHeap() {
        priorityQueue = (Key[]) new Comparable[1];
        size = 0;
    }

    private void insert(Key v){
        if(size+1 == priorityQueue.length){
            resize(priorityQueue.length*2);
        }
        priorityQueue[++size] = v;
        swim(size);
    }

    private Key delMax(){
        Key maxElement = priorityQueue[1];
        exch(1,size--);
        sink(1);
        priorityQueue[size+1] = null;
        if(size > 0 && size < priorityQueue.length/4){
            resize(priorityQueue.length/2);
        }
        return maxElement;
    }

    private void swim(int k){
        while(k > 1 && less(k/2,k)){
            exch(k/2, k);
            k = k/2;
        }
    }

    private void sink(int k){
        while(2*k <= size){
            int j = 2*k;
            if(j < size && less(j, j+1)){
                j++;
            }
            if(less(k,j)){
                exch(k,j);
                k = j;
            }
            else{
                break;
            }
        }
    }

    private boolean less(int i, int j){
        return priorityQueue[i].compareTo(priorityQueue[j]) < 0;
    }

    private void exch(int i, int j){
        Key temp = priorityQueue[i];
        priorityQueue[i] = priorityQueue[j];
        priorityQueue[j] = temp;
    }

    private boolean isEmpty(){
        return size == 0;
    }

    private void resize(int newSize){
        Key[] copy = (Key[]) new Comparable[newSize];
        for(int i = 1 ; i <= size ; i++ ){
            copy[i] = priorityQueue[i];
        }
        priorityQueue =copy;
    }

    public static void main(String[] args) {
        BinaryHeap binaryHeap = new BinaryHeap();
        binaryHeap.insert(1);
        binaryHeap.insert(2);
        binaryHeap.insert(3);
        System.out.println(binaryHeap.delMax());
        binaryHeap.insert(2);
        System.out.println(binaryHeap.delMax());
        binaryHeap.insert(6);
        binaryHeap.insert(0);
        System.out.println(binaryHeap.delMax());
        System.out.println(binaryHeap.delMax());
        System.out.println(binaryHeap.delMax());
        System.out.println(binaryHeap.delMax());
    }
}
