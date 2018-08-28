package com.GeeksForGeeks.Sorting;

/**
 * Created by anuj on 4/5/16.
 */
public class Selection_Sort {

    private void selectionSort(int[] arr){

        for(int i = 0 ; i < arr.length ; i++){
            int min = arr[i];
            int minPos = 0;
            boolean swapped = false;
            for(int j = i+1 ; j < arr.length ; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minPos = j;
                    swapped = true;
                }
            }
            if(min<arr[i]){
                int temp = arr[i];
                arr[i] = arr[minPos];
                arr[minPos] = temp;

            }
            if(!swapped)
                break;
        }
        for(int i = 0 ; i < arr.length ; i++)
            System.out.print(arr[i]);
    }

    public static void main(String[] args) {

        Selection_Sort ss = new Selection_Sort();

        int[] arr = {1,2,3,4,5};
        ss.selectionSort(arr);
    }

}
