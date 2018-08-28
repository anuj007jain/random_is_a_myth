package com.Repeat_Practice;

import java.util.Arrays;

/**
 * Created by anuj.jain02 on 7/7/17.
 */
public class InsertionSort {

    private void sort(Comparable[] arr) {
        for(int i = 1 ; i < arr.length ; i++){
            for(int j = i ; j > 0 ; j--){
                if(!cmp(j-1, j, arr)) {
                    swap(j-1, j, arr);
                }
                else {
                    break;
                }
            }
        }
    }

    private void swap(int i, int j, Comparable[] arr) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private boolean cmp(int i, int j, Comparable[] arr) {
        return arr[i].compareTo(arr[j]) < 0;
    }


    public static void main(String[] args) {

        InsertionSort insertionSort =  new InsertionSort();
        Integer[] integers = {3,4,2,6,1,5,7,0,9,8};
        String[] strings = {"Anuj","Manas","Shashi","Apurv","Pooja","Piyush"};
        insertionSort.sort(integers);
        insertionSort.sort(strings);
        System.out.println(Arrays.asList(integers));
        System.out.println(Arrays.asList(strings));

    }

}
