package com.GeeksForGeeks.Sorting;

/**
 * Created by anuj on 4/5/16.
 */
public class Bubble_Sort {

    private void bubbleSort(int[] arr, int n){

        if(n == 0)
            for(int i = 0 ; i < arr.length ; i++)
                System.out.print(arr[i]);
        else {
            for (int i = 1; i < n; i++) {
                if (arr[i - 1] > arr[i]) {
                    int temp = arr[i - 1];
                    arr[i - 1] = arr[i];
                    arr[i] = temp;
                }
            }
            bubbleSort(arr, n - 1);
        }
    }

    public static void main(String[] args) {

        Bubble_Sort bs = new Bubble_Sort();

        int[] arr = {2,4,1,5,3,5};
        bs.bubbleSort(arr, arr.length);
    }
}
