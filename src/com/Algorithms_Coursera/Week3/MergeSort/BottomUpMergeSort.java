package com.Algorithms_Coursera.Week3.MergeSort;

/**
 * Created by anuj.jain02 on 25/2/17.
 */
public class BottomUpMergeSort {

    private static Comparable[] aux;

    private void merge(Comparable[] a, int lo, int mid, int hi) {

        for (int k = lo; k <= hi; aux[k] = a[k++]) ;

        int i = lo;
        int j = mid + 1;

        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[i], aux[j]))
                a[k] = aux[i++];
            else
                a[k] = aux[j++];
        }
    }

    private boolean less(Comparable x, Comparable y){
        return x.compareTo(y) < 0;
    }

    private boolean isSorted(Comparable[] a){
        for(int i = 0  ; i < a.length-1 ; i++)
            if(less(a[i+1],a[i]))
                return false;
        return true;
    }

    private void sort(Comparable[] a) {

        aux = new Comparable[a.length];

        for(int sz = 1 ; sz < a.length ; sz = sz+sz){
            for(int i = 0 ; i < a.length -sz ; i = i+sz+sz){
                merge(a, i, i + sz -1, Math.min(i + sz + sz - 1, a.length-1));
            }
        }
    }

    public static void main(String[] args) {

        BottomUpMergeSort sort = new BottomUpMergeSort();
        Integer[] integers = {2,1,5,3,6,4,8,4,2,4,21,2,1};
        String[] strings = {"Mrigank", "Pooja", "Anuj", "Shubham", "Rishi"};
        System.out.println(sort.isSorted(integers));
        System.out.println(sort.isSorted(strings));
        sort.sort(integers);
        sort.sort(strings);
        System.out.println(sort.isSorted(integers));
        System.out.println(sort.isSorted(strings));

    }
}
