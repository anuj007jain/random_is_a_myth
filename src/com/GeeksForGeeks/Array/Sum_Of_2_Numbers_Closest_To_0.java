package com.GeeksForGeeks.Array;

/**
 * Created by anuj on 22/5/16.
 */

//http://www.geeksforgeeks.org/two-elements-whose-sum-is-closest-to-zero/
public class Sum_Of_2_Numbers_Closest_To_0 {

    private void findPair(int[] arr){

        mergeSort(arr,0,(arr.length-1));
        int i = 0;
        int j = arr.length-1;
        int min_diff = Integer.MAX_VALUE;
        int x=0;
        int y=0;
        while(i<j){
            if(arr[i]+arr[j]>0) {
                if(Math.abs(arr[i]+arr[j])<min_diff) {
                    min_diff = Math.abs(arr[i] + arr[j]);
                    x=arr[i];
                    y = arr[j];
                }
                j--;
            }
            else{
                if(Math.abs(arr[i]+arr[j])<min_diff) {
                    min_diff = Math.abs(arr[i] + arr[j]);
                    x=arr[i];
                    y = arr[j];
                }
                i++;
            }
        }
        System.out.print(x+" "+y);


    }

    private void mergeSort(int[] arr, int start, int end){

        int mid = (start+end)/2;

        if(start < end) {

            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);

            merge(arr, start, mid, end);
        }
    }

    private void merge(int[] arr, int start, int mid, int end ){

        int[] temp = new int[end-start+1];
        int i = start;
        int j = mid+1;
        int k = 0;

        while(i<=mid && j<=end){
            if(arr[i]<arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while(i<=mid)
            temp[k++] = arr[i++];
        while(j<=end)
            temp[k++] = arr[j++];

        for( i = 0 ; i< k ; i++)
            arr[i+start] = temp[i];

    }

    public static void main(String[] args) {

        Sum_Of_2_Numbers_Closest_To_0 so2nct0 = new Sum_Of_2_Numbers_Closest_To_0();
        int[] arr = {+1,+70,-10,+60,-80,+85};
        so2nct0.findPair(arr);

    }

}
