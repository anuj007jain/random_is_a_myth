package com.LeetCode;

public class LC_668_Kth_Smallest_Number_In_Multiplication_Table {

    class MaxHeap {

        int[] heap;
        int size;

        public MaxHeap(int k) {
            heap = new int[k];
            size = 0;
        }

        public void swim(int k) {
            while(k/2 > 0) {
                if(heap[k/2] < heap[k]) {
                    swap(k,k/2);
                    k = k/2;
                } else {
                    break;
                }
            }
        }

        public int max() {
            return heap[1];
        }

        public void insert(int elem) {
            heap[++size] = elem;
            swim(size);
        }

        public void add(int elem) {
            heap[++size] = elem;
        }

        public void heapify() {
            for(int i = size/2 ; i > 0 ; i--) {
                sink(i);
            }
        }

        public int deleteMax() {
            int deletedElem = heap[1];
            swap(1, size--);
            sink(1);
            return deletedElem;
        }

        public void sink(int k) {
            int j = 2*k;
            while(j <= size) {
                if (j+1 <= size) {
                    if(heap[j+1] > heap[j]) {
                        j = j+1;
                    }
                }
                if(heap[k] < heap[j]) {
                    swap(k,j);
                    k = j;
                    j = 2*k;
                } else {
                    break;
                }
            }
        }

        public void swap(int x, int y) {
            int temp = heap[x];
            heap[x] = heap[y];
            heap[y] = temp;
        }

        public int size() {
            return size;
        }
    }

    public int findKthNumber(int m, int n, int k) {

        MaxHeap heap = new MaxHeap(k+1);
        for(int i = 1 ; i <= m ; i++) {
            for(int j = 1; j <= n ; j++) {
                if(heap.size() < k) {
                    heap.add(i*j);
                    if(heap.size() == k) {
                        heap.heapify();
                    }

                } else {
                    if(heap.max() < i*j) {
                        break;
                    }
                    heap.deleteMax();
                    heap.insert(i*j);
                }
            }
        }
        return heap.max();
    }

    public static void main(String[] args) {
        LC_668_Kth_Smallest_Number_In_Multiplication_Table lc_668_ksnimt = new LC_668_Kth_Smallest_Number_In_Multiplication_Table();
        System.out.println(lc_668_ksnimt.findKthNumber(9895,28405,100787757));
    }

}
