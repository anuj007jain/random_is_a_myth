package com.GeeksForGeeks.DynamicProgramming;

/**
 * Created by anuj on 13/5/16.
 */

//http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
public class Longest_Increasing_Subsequence {

    private void LIS(int[] arr){

        int[] lis = new int[arr.length];

        for(int i = 0 ; i < arr.length ; i++)
            lis[i] = 1;

        for(int i = 1 ; i < arr.length ; i++)
            for(int j = 0 ; j < i ; j++)
                if(arr[j] < arr[i] && lis[i] < (lis[j]+1))
                    lis[i] = lis[j]+1;

        int max=lis[0];
        for(int i = 1 ; i < arr.length ; i++)
            if(max < lis[i])
                max = lis[i];

        System.out.print(max);

    }

    public static void main(String[] args) {

        Longest_Increasing_Subsequence lis = new Longest_Increasing_Subsequence();
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        lis.LIS(arr);


    }

}
