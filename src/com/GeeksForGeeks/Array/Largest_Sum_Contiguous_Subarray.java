package com.GeeksForGeeks.Array;

/**
 * Created by anuj.jain02 on 10/6/16.
 */

//http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
public class Largest_Sum_Contiguous_Subarray {

    private void findLargestSum(int[] arr){

        int maxSum = Integer.MIN_VALUE;
        int negativeCount = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 0){
                negativeCount++;
                if(arr[i] > maxSum)
                    maxSum = arr[i];
            }
            if(negativeCount == arr.length) {
                System.out.print(maxSum);
                return;
            }
        }

        maxSum=0;
        int currentSum = 0;
        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] > 0) {
                currentSum += arr[i];
                if(maxSum < currentSum)
                    maxSum = currentSum;
            }
            else if(arr[i] < 0 ) {
                if(currentSum+arr[i] <= 0){
                    if(maxSum < currentSum)
                        maxSum = currentSum;
                    currentSum = 0;
                }
                else{
                    if(maxSum < currentSum)
                        maxSum = currentSum;
                    currentSum += arr[i];
                }
            }
        }
        System.out.print(maxSum);

    }

    public static void main(String[] args) {

        Largest_Sum_Contiguous_Subarray lscs = new Largest_Sum_Contiguous_Subarray();
        int[] arr1 = {-2, -3, 4, -1, -2, 1, 5, -3};
        int[] arr2 = {2, 3, 4, 1, 2, 1, 5, 3};
        int[] arr3 = {-2, -3, -4, -1, -2, -1, -5, -3};
        int[] arr4 = {8, 2, -1, -2, 1, -4, 2};
        lscs.findLargestSum(arr4);

    }

}
