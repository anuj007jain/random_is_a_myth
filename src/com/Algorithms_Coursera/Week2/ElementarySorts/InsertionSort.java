package com.Algorithms_Coursera.Week2.ElementarySorts;

/**
 * Created by anuj.jain02 on 24/2/17.
 */
public class InsertionSort {

    private void sort(Comparable[] a){

        for(int i = 1 ; i < a.length ; i++){
            for(int j = i; j > 0 ; j--){
                if(less(a[j],a[j-1]))
                    exch(a, j-1, j);
                else
                    break;
            }
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
        for(int i = 0  ; i < a.length-1 ; i++)
            if(less(a[i+1],a[i]))
                return false;
        return true;
    }

    public static void main(String[] args) {

        InsertionSort sort = new InsertionSort();
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
