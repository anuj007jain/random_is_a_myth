package com.Algorithms_Coursera.Week3.QuickSort;

import edu.princeton.cs.algs4.StdRandom;

/**
 * Created by anuj.jain02 on 5/3/17.
 */
public class QuickSelect {

    private static int partition(Comparable[] a, int lo, int hi){

        int i = lo;
        int j = hi+1;

        while(true) {
            while (less(a[++i], a[lo]))
                if (i == hi)
                    break;

            while (less(a[lo], a[--j]))
                if (j == lo)
                    break;

            if (i >= j)
                break;
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;

    }

    private static Comparable quickSelect(Comparable[] a, int k){
        StdRandom.shuffle(a);
        return quickSelect(a, k, 0, a.length-1);
    }

    private static Comparable quickSelect(Comparable[] a, int k, int lo, int hi){

        while (lo < hi) {
            int j = partition(a, lo, hi);
            if (j < k)
                lo = j + 1;
            else if (j > k)
                hi = j - 1;
            else
                return a[k];
        }
        return a[k];
    }

    private static boolean less(Comparable x, Comparable y){
        return x.compareTo(y) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {

        int k = 3;
        Integer[] integers = {3,6,4,1,9,3,1,2};
        String[] strings= {"Mrigank", "Pooja", "Anuj", "Shubham", "Rishi"};
        QuickSelect quickSelect = new QuickSelect();
        System.out.println(quickSelect.quickSelect(strings,k));

    }


}

