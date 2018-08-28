package com.GeeksForGeeks.Array;

/**
 * Created by anuj.jain02 on 17/9/17.
 */
public class Equal_Subset_Sum {

    public boolean find(int[] arr) {
        int sum = 0;
        for(int i = 0  ; i < arr.length ; i++) {
            sum += arr[i];
        }
        if(sum %2 != 0){
            return false;
        }
        return findUtil(arr, sum/2, arr.length-1);
    }

    private boolean findUtil(int[] arr, int sum, int N) {
        if(sum == 0){
            return true;
        }
        if(N == 0) {
            return false;
        }
        if(arr[N] > sum){
            return findUtil(arr, sum, N-1);
        }
        return findUtil(arr, sum, N-1) || findUtil(arr, sum-arr[N], N-1);
    }


    public static void main(String[] args) {

        Equal_Subset_Sum equal_subset_sum = new Equal_Subset_Sum();
        int[] arr = {1, 5, 3};
        System.out.println(equal_subset_sum.find(arr));

    }

}
