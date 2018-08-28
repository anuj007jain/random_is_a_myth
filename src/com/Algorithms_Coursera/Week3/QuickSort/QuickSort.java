package com.Algorithms_Coursera.Week3.QuickSort;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by anuj.jain02 on 5/3/17.
 */
public class QuickSort {

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo;
        int j = hi+1;

        while (true) {
            while (less(a[++i], a[lo])) {
                if (i == hi)
                    break;
            }

            while (less(a[lo], a[--j])) {
                if (j == lo)
                    break;
            }

            if (i >= j)
                break;
            exch(a, i, j);
        }

        exch(a, lo, j);
        return j;

    }

    private static void sort(Comparable[] a, int lo, int hi){
        StdRandom.shuffle(a);
        if(lo >= hi)
            return;
        int j = partition(a, lo, hi);
        sort(a, lo, j-1);
        sort(a, j+1, hi);
    }

    private static boolean less(Comparable x, Comparable y){
        return x.compareTo(y) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private boolean isSorted(Comparable[] a){
        for(int i = 0  ; i < a.length-1 ; i++)
            if(less(a[i+1],a[i]))
                return false;
        return true;
    }

    public static void main(String[] args) {

        QuickSort sort = new QuickSort();
        Integer[] integers = {2,1,5,3,6,4,8,4,2,4,21,2,1};
        String[] strings = {"Mrigank", "Pooja", "Anuj", "Shubham", "Rishi"};
        System.out.println(sort.isSorted(integers));
        System.out.println(sort.isSorted(strings));
        sort(integers, 0, integers.length-1);
        sort(strings, 0, strings.length-1);
        System.out.println(sort.isSorted(integers));
        System.out.println(sort.isSorted(strings));

    }

}
