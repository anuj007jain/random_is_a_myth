package com.GeeksForGeeks.Sorting;

/**
 * Created by anuj on 18/5/16.
 */
public class Merge_Sort {

    private void mergeSort(int[] arr, int start , int end){

        int mid = (start+end)/2;

        if(start < end) {

            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);

            merge(arr, start, mid, end);
        }
    }

    private void merge(int[] arr, int start , int mid, int end){

        int[] temp = new int[end-start+1];
        int i = start;
        int j = mid+1;
        int k = 0;

        while(i <= mid && j <= end){
            if(arr[i] > arr[j])
                temp[k++] = arr[j++];
            else
                temp[k++] = arr[i++];
        }
        while(i <= mid)
            temp[k++] = arr[i++];

        while(j <= end)
            temp[k++] = arr[j++];

        for(i=0; i<k; i++){
            arr[i+start] = temp[i];
        }

    }

    public static void main(String[] args) {

        Merge_Sort ms = new Merge_Sort();
        int[] arr = {3,4,2,4,5,1,8};
        int[] arr2 = {1,70,-10,60,-80,85};
        ms.mergeSort(arr2,0,(arr2.length-1));
        for(int i=0; i<=arr.length-1; i++){
            System.out.print(arr2[i]+" ");
        }


    }

}
