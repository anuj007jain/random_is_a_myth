package com.GeeksForGeeks.Sorting;

/**
 * Created by anuj on 5/5/16.
 */
public class Insertion_Sort {

    private void insertionSort(int[] arr){

        int n = arr.length;
        for (int j = 1; j < n; j++) {
            int key = arr[j];
            int i = j-1;
            while ( (i > -1) && ( arr [i] > key ) ) {
                arr [i+1] = arr [i];
                i--;
            }
            arr[i+1] = key;
        }

        for(int i = 0 ; i < arr.length ; i++)
            System.out.print(arr[i]+" ");
        }


    public static void main(String[] args) {

        Insertion_Sort is = new Insertion_Sort();
        int[] arr = {3,6,2,4,6,2};
        is.insertionSort(arr);

    }

}
