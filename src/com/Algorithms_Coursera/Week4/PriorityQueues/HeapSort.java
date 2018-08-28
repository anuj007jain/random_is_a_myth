package com.Algorithms_Coursera.Week4.PriorityQueues;

import java.util.Arrays;

/**
 * Created by anuj.jain02 on 21/3/17.
 */
public class HeapSort {

    private void sort(Comparable[] a){

        int N = a.length - 1;
        for(int k = N/2 ; k >= 1; k--){
            sink(a, k, N);
        }
        while(N > 1){
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    private void sink(Comparable[] a, int k, int N){

        while(2*k <= N){
            int j = 2*k;
            if(j < N && less(a, j, j+1)) {
                j++;
            }
            if(!less(a, k, j))
                break;
            exch(a, k, j);
            k = j;
        }

    }

    private void swim(Comparable[] a, int k, int N){

        while(k > 1){
            if(less(a, k/2, k)){
                exch(a, k/2, k);
                k = k/2;
            }
        }

    }

    private boolean less(Comparable[] a, int i, int j){
        return a[i].compareTo(a[j]) < 0;
    }

    private void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        Integer[] integers = {null,3,2,8,4,7,6,1,5};
        String[] strings = {null, "Mrigank", "Pooja", "Anuj", "Shubham", "Rishi"};
        heapSort.sort(integers);
        heapSort.sort(strings);
        System.out.println(Arrays.asList(integers));
        System.out.println(Arrays.asList(strings));

    }

}
