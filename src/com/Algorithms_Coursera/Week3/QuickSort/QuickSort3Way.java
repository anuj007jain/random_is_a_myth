package com.Algorithms_Coursera.Week3.QuickSort;

import edu.princeton.cs.algs4.StdRandom;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anuj.jain02 on 10/3/17.
 */
//Dutch National Flag problem
public class QuickSort3Way {

    private static Pair<Integer, Integer> partition3Way(Comparable[] a, int lo, int hi ){

        Comparable pivot = a[lo];
        int i = lo+1;
        int lt = lo;
        int gt = hi;
        while(i <= gt) {
            if (less(a[i], pivot)) {
                exch(a, i++, lt++);
            } else if (less(pivot, a[i])) {
                exch(a, i, gt--);
            } else {
                i++;
            }
        }
        return new Pair<>(lt,gt);
    }

    private static void sort(Comparable[] a){
        StdRandom.shuffle(a);
        sort(a, 0, a.length -1);
    }

    private static void sort(Comparable[] a, int lo, int hi){

        if(lo >= hi) {
            return;
        }

        Pair pair = partition3Way(a, lo, hi);
        sort(a, lo, (int)pair.getKey() - 1); //lt - 1
        sort(a, (int)pair.getValue() + 1, hi); //gt + 1
    }

    private static boolean less (Comparable x, Comparable y){
        return x.compareTo(y) < 0;
    }

    private static void exch (Comparable[] a, int i, int j){
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static boolean isSorted(Comparable[] a){
        for(int i = 0  ; i < a.length-1 ; i++)
            if(less(a[i+1],a[i]))
                return false;
        return true;
    }

    public static void main(String[] args) {

        QuickSort3Way quickSort3Way = new QuickSort3Way();
        Character[] characters = {'P', 'A', 'B', 'X', 'W', 'P', 'P', 'V', 'P', 'D', 'P', 'C', 'Y', 'Z'};
        System.out.println(quickSort3Way.isSorted(characters));
        quickSort3Way.sort(characters);
        System.out.println(quickSort3Way.isSorted(characters));

    }

}
