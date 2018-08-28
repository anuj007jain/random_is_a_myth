package com.Repeat_Practice;

import java.util.Arrays;

/**
 * Created by anuj.jain02 on 15/9/17.
 */
public class HeapSort {

    public void sort(Comparable[] a) {

        int N = a.length -1;
        for(int k = N/2 ; k >=1 ; k--){
            sink(a, k, N);
        }
        while(N > 1){
            exch(a, 1, N--);
            sink(a, 1, N);
        }

    }

    public void sink(Comparable[] a, int k, int N) {
        while (2*k <= N ){
            int j = 2*k;
            if(j < N && less(a, j, j+1)){
                j++;
            }
            if(less(a, k, j)){
                exch(a, k, j);
                k = j;
            }
            else return;
        }
    }

    public void swim(Comparable[] a, int k) {
        while (k > 1 && a[k].compareTo(a[k/2]) > 0) {
            exch(a, k, k/2);
            k = k/2;
        }
    }

    public boolean less(Comparable[] a, int i, int j){
        return a[i].compareTo(a[j]) < 0;
    }

    public void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        Integer[] integers = {null, 3, 1, 6, 3, 5, 4};
        String[] strings = {null, "Anuj", "Mrigank", "Ayush", "Shubham", "Pooja", "Rishi"};
        System.out.println("Before sorting: "+ Arrays.asList(integers));
        heapSort.sort(integers);
        System.out.println("After sorting: "+ Arrays.asList(integers));
        System.out.println("Before sorting: "+ Arrays.asList(strings));
        heapSort.sort(strings);
        System.out.println("After sorting: "+ Arrays.asList(strings));
    }

}
