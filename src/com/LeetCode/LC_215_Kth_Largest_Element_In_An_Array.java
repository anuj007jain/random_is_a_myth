package com.LeetCode;

public class LC_215_Kth_Largest_Element_In_An_Array {

    class MaxHeap {

        int[] heap;
        int n;

        public MaxHeap(int[] arr) {
            n = arr.length;
            heap = new int[n+1];
            for(int i = 1 ; i <= n ; i++) {
                heap[i] = arr[i-1];
            }
            heapify();
        }

        private void heapify() {
            for (int i = n/2 ; i > 0 ; i--) {
                sink(i);
            }
        }

        private void sink(int k) {
            while (2*k <= n) {
                int j = 2*k;
                if (j < n) {
                    if(heap[j+1] > heap[j]) {
                        j = j+1;
                    }
                }
                if (heap[j/2] < heap[j]) {
                    swap(j/2, j);
                    k = j;
                } else {
                    break;
                }
            }
        }

        //later
        private void swim(int k) {

        }

        private void swap(int i, int j) {
            int temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        private int deleteMin() {
            int deletedElement = heap[1];
            swap(1, n--);
            sink(1);
            return deletedElement;
        }

    }

    public int findKthLargest(int[] nums, int k) {
        MaxHeap heap = new MaxHeap(nums);
        for(int i = 1 ; i < k ; i++) {
            heap.deleteMin();
        }
        int x = heap.deleteMin();
        System.out.println(x);
        return x;
    }

    public static void main(String[] args) {
        LC_215_Kth_Largest_Element_In_An_Array lc_215_kleiaa = new LC_215_Kth_Largest_Element_In_An_Array();
        lc_215_kleiaa.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6}, 4);
    }

}
