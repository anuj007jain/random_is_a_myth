package com.GeeksForGeeks.Heap;

/**
 * Created by anuj on 11/5/16.
 */
public class Min_Heap {

    public int[] heap;
    public int size;

    public Min_Heap(int maxSize){
        this.heap = new int[maxSize+1];
        heap[0] = Integer.MIN_VALUE;
        this.size = 0;
    }

    public int getParent(int position){
        return position/2;
    }

    public int getLeftChild(int position){
        return position*2;
    }

    public int getRightChild(int position){
        return position*2+1;
    }

    public boolean isLeaf(int position){
        if(position>size/2)
            return true;
        return false;
    }

    public void swap(int x, int y){
        int temp = heap[x];
        heap[x] = heap[y];
        heap[y] = temp;
    }

    public void insert(int data){
        heap[++size] = data;
        int currentItem = size;
        while(heap[currentItem]<heap[getParent(currentItem)]){
            swap(currentItem,getParent(currentItem));
            currentItem = getParent(currentItem);
        }
    }

    public void delete(int position){
        int itemPopped = heap[position];
        heap[position] = heap[size--];
        heapify(1);
    }

    public void heapify(int position){
        if(isLeaf(position))
            return;
        if(heap[getLeftChild(position)] < heap[position] || heap[getRightChild(position)] < heap[position]){
            if(heap[getRightChild(position)] > heap[getLeftChild(position)]) {
                swap(position, getRightChild(position));
                heapify(getRightChild(position));
            }
            else{
                swap(position,getLeftChild(position));
                heapify(getLeftChild(position));
            }
        }
    }

    public void printHeap(){
        for(int i = 1;i <= size/2 ; i++){
            System.out.println("Parent: "+heap[i]+" Left Child: "+heap[getLeftChild(i)]+" Right Child: "+heap[getRightChild(i)]);
        }
    }

    public static void main(String[] args) {

        Min_Heap minHeap = new Min_Heap(10);
        minHeap.insert(1);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(4);
        minHeap.delete(2);
        minHeap.printHeap();

    }

}
