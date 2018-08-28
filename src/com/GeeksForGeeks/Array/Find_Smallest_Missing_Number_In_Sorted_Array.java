package com.GeeksForGeeks.Array;

/**
 * Created by anuj on 20/5/16.
 */

//http://www.geeksforgeeks.org/find-the-first-missing-number/
public class Find_Smallest_Missing_Number_In_Sorted_Array {

    private void findSmallestNumberInSortedArray(int[] arr, int l, int h){

        if(l==h) {
            System.out.print(arr[l] - 1);
            return;
        }
        int mid = (l+h)/2;
        if(arr[mid] > mid+1) //wrong position
            findSmallestNumberInSortedArray(arr,l,mid);
        else
            findSmallestNumberInSortedArray(arr,mid+1,h);
    }

    public static void main(String[] args) {

        Find_Smallest_Missing_Number_In_Sorted_Array fsmnisa = new Find_Smallest_Missing_Number_In_Sorted_Array();
        int[] arr = {2,3,4,5,6,7,8,9,10,11,13};
        fsmnisa.findSmallestNumberInSortedArray(arr,0,arr.length-1);

    }

}