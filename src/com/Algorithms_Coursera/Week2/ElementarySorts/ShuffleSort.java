package com.Algorithms_Coursera.Week2.ElementarySorts;

import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

/**
 * Created by anuj.jain02 on 24/2/17.
 */
public class ShuffleSort {

    private void sort(Comparable[] a){
        for(int i = 0 ; i < a.length ; i++){
            int r = StdRandom.uniform(i+1);
            exch(a, i, r);
        }
    }

    private void exch(Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private boolean less(Comparable x, Comparable y){
        return x.compareTo(y) < 0;
    }

    private boolean isSorted(Comparable[] a){
        for(int i = 0 ; i < a.length-1 ; i++)
            if(less(a[i+1],a[i]))
                return false;
        return true;
    }

    public static void main(String[] args) {

        ShuffleSort sort = new ShuffleSort();
        Integer[] integers = {2,1,5,3,6,4};
        String[] strings = {"Mrigank", "Pooja", "Anuj", "Shubham", "Rishi"};
        sort.sort(integers);
        sort.sort(strings);
        System.out.println(Arrays.asList(integers));
        System.out.println(Arrays.asList(strings));
    }

}