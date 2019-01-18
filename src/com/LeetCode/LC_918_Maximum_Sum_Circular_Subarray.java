package com.LeetCode;

import java.util.Arrays;

public class LC_918_Maximum_Sum_Circular_Subarray {

    public int maxSubarraySumCircular(int[] A) {
        int[] solution = new int[A.length];
        solution[0] = A[0];
        for(int i = 1 ; i < A.length ; i++) {
            if(solution[i-1] + A[i] > A[i]) {
                solution[i] = solution[i-1] + A[i];
            } else {
                solution[i] = A[i];
            }
        }
        System.out.println(Arrays.toString(solution));
        return 1;
    }

    public static void main(String[] args) {
        int[] A = {1, -2, 3, -2};
        int[] B = {5, -3, 5};
        System.out.println(new LC_918_Maximum_Sum_Circular_Subarray().maxSubarraySumCircular(B));
    }

}
