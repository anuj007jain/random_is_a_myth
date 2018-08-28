package com.Algorithms_Coursera.Week2.ElementarySorts;

/**
 * Created by anuj.jain02 on 24/2/17.
 */
public class SelectionSort {

    private void sort(Comparable[] a){
        for(int i = 0 ; i < a.length ; i++){
            int min = i;
            for(int j = i+1 ; j < a.length; j++){
                if(less(a[j],a[min])){
                    min = j;
                }
            }
            exch(a, i, min);
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

        SelectionSort sort = new SelectionSort();
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
