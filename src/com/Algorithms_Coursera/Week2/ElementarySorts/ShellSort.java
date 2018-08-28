package com.Algorithms_Coursera.Week2.ElementarySorts;

/**
 * Created by anuj.jain02 on 24/2/17.
 */
public class ShellSort {

    private void sort(Comparable[] a){

        int h = 1;
        while(h < a.length/3)
            h = 3*h+1; // knuth's formula

        while(h >= 1){ // h-sort the array
            for(int i = h ; i < a.length ; i++){
                for(int j = i ; j >= h ; j-=h){
                    if(less(a[j],a[j-h]))
                        exch(a, j, j-h);

                }
            }
            h/=3;
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

        ShellSort sort = new ShellSort();
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