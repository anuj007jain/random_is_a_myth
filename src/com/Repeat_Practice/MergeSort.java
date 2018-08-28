package com.Repeat_Practice;

import java.util.Arrays;

/**
 * Created by anuj.jain02 on 1/8/17.
 */
public class MergeSort {

    public static void mergeSort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
    }

    public static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi){

        for(int i = lo ; i <= hi ; i++){
            aux[i] = a[i];
        }

        int k = lo;
        int i = lo;
        int j = mid+1;
        while(i <= mid && j <= hi){
            if(aux[i].compareTo(aux[j]) < 0){
                a[k++] = aux[i++];
            }
            else{
                a[k++] = aux[j++];
            }
        }
        while (i<=mid){
            a[k++] = aux[i++];
        }
        while (j<=lo){
            a[k++] = aux[j++];
        }
    }

    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi){

        if(lo >= hi)
            return;
        int mid = (lo+hi)/2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);

    }

    public static void main(String[] args) {

        Integer[] integers = {3,2,5,1,3,6,4};
        String[] strings = {"Mrigank", "Pooja", "Anuj", "Shubham", "Rishi"};
        MergeSort mergeSort = new MergeSort();
        mergeSort.mergeSort(integers);
        mergeSort.mergeSort(strings);
        System.out.println(Arrays.asList(integers));
        System.out.println(Arrays.asList(strings));

    }
}
