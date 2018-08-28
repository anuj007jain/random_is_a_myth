package com.Repeat_Practice;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * Created by anuj.jain02 on 2/8/17.
 */
public class QuickSort {

    private void sort(Comparable[] a) {
        StdRandom.shuffle(a);
        sort(a, 0, a.length-1);
    }

    private int partition(Comparable[] a, int lo, int hi){
        int i = lo;
        int j = hi+1;
        while(true){
            while(a[++i].compareTo(a[lo]) < 0){
                if(i == hi)
                    break;
            }
            while(a[--j].compareTo(a[lo]) > 0){
                if(j == lo)
                    break;
            }
            if(i < j){
                swap(a, i, j);
            }
            else{
                swap(a, lo, j);
                break;
            }
        }
        return j;
    }
    private void sort(Comparable[] a, int lo, int hi) {
        if(lo >= hi){
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private void swap(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {

        Integer[] integers = {4,7,5,3,8,4,5};
        QuickSort quickSort = new QuickSort();
        quickSort.sort(integers);
        System.out.println(Arrays.asList(integers));
    }

}
