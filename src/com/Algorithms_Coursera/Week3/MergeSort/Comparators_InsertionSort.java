package com.Algorithms_Coursera.Week3.MergeSort;

import java.util.Comparator;

/**
 * Created by anuj.jain02 on 28/2/17.
 */
public class Comparators_InsertionSort {

    public static void sort(Object[] a, Comparator comparator ){

        for(int i = 1; i < a.length ; i++){
            for(int j = i; j > 0 ; j--){
                if(less(comparator, a[j], a[j-1])){
                    exch(a, j, j-1);
                }
                else{
                    break;
                }
            }
        }
    }

    private static boolean less(Comparator comparator, Object x, Object y){

        return comparator.compare(x,y) < 0;

    }

    private static void exch(Object[] a, int i, int j){

        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;

    }

}
