package com.GeeksForGeeks.Array;

/**
 * Created by anuj.jain02 on 16/6/16.
 */

//http://www.geeksforgeeks.org/maximum-absolute-difference-between-sum-of-two-contiguous-sub-arrays/
public class Maximum_Absolute_Difference_Between_Sum_Of_2_Contiguous_Subarrays {

    private void findSolution(int[] arr){

        int negativeCount = 0;
        int positiveCount= 0;
        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] < 0){
                negativeCount++;
                if(arr[i] > maxSum)
                    maxSum = arr[i];
            }
            else{
                positiveCount++;
                if(arr[i] < minSum)
                    minSum = arr[i];
            }
        }
        if(positiveCount == arr.length){
            maxSum = 0;
            for(int i = 0 ; i < arr.length ; i++)
                maxSum += arr[i];
            System.out.print("Max Difference: "+(maxSum-minSum));
            return;
        }
        if(negativeCount == arr.length){
            minSum = 0;
            for(int i = 0 ; i < arr.length ; i++)
                minSum += arr[i];
            System.out.print("Max Difference: "+(maxSum-minSum));
            return;
        }

        maxSum = 0;
        minSum = 0;
        int prevMaxSum = 0;
        int prevMinSum = 0;

        for(int i = 0; i < arr.length ; i++){
            if(arr[i] >= 0) {
                maxSum += arr[i];
                if(prevMaxSum < maxSum)
                    prevMaxSum = maxSum;
                }

            else if(arr[i]+maxSum < 0) {
                if(prevMaxSum < maxSum)
                    prevMaxSum = maxSum;
                maxSum = 0;
            }
            else{
                if(prevMaxSum < maxSum)
                    prevMaxSum = maxSum;
                maxSum += arr[i];
            }
            if(arr[i] <= 0){
                minSum += arr[i];
                if(prevMinSum > minSum)
                    prevMinSum = minSum;
            }
            else if(arr[i]+minSum > 0){
                if(prevMinSum > minSum )
                    prevMinSum = minSum;
                minSum = 0;
            }
            else{
                if(prevMinSum > minSum)
                    prevMinSum = minSum;
                minSum += arr[i];
            }
        }
        System.out.print("Max Difference: "+(prevMaxSum-prevMinSum));


    }

    public static void main(String[] args) {
        Maximum_Absolute_Difference_Between_Sum_Of_2_Contiguous_Subarrays madbso2cs = new Maximum_Absolute_Difference_Between_Sum_Of_2_Contiguous_Subarrays();
        int[] arr1 = {-2, -3, 4, -1, -2, 1, 5, -3};
        int[] arr2 = {2, 3, 4, 1, 2, 1, 5, 3};
        int[] arr3 = {-2, -3, -4, -1, -2, -1, -5, -3};
        int[] arr4 = {2, -1, -2, 1, -4, 2, 8};
        madbso2cs.findSolution(arr2);

    }

}
