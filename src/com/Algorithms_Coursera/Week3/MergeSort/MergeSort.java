package com.Algorithms_Coursera.Week3.MergeSort;
/**
 * Created by anuj.jain02 on 25/2/17.
 */
public class MergeSort {

    private void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {

        for (int k = lo; k <= hi; aux[k] = a[k++]) ;

        int i = lo;
        int j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            if (i > mid)
                a[k] = aux[j++];
            else if (j > hi)
                a[k] = aux[i++];
            else if (less(aux[i],aux[j]))
                a[k] = aux[i++];
            else
                a[k] = aux[j++];
        }
    }

    private void sort(Comparable[] a, Comparable[] aux, int lo, int hi){

        if(lo >= hi)
            return;
        int mid = (lo+hi)/2;

        sort(a, aux, lo, mid);
        sort(a, aux, mid+1, hi);
        merge(a, aux, lo, mid, hi);

    }

    private void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a, aux, 0, a.length-1);
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

    public static void main(String[] args) {

        MergeSort sort = new MergeSort();
        Integer[] integers = {2,1,5,3,6,4};
        String[] strings = {"Mrigank", "Pooja", "Anuj", "Shubham", "Rishi"};
        System.out.println(sort.isSorted(integers));
        System.out.println(sort.isSorted(strings));
        sort.sort(integers);
        sort.sort(strings);
        System.out.println(sort.isSorted(integers));
        System.out.println(sort.isSorted(strings));

    }

}
