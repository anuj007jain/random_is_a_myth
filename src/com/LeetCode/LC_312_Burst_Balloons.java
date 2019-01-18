package com.LeetCode;

public class LC_312_Burst_Balloons {

    public int maxCoins(int[] nums) {

        int T[][] = new int[nums.length][nums.length];

        for (int len = 1; len <= nums.length; len++) {
            for (int i = 0; i <= nums.length - len; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    //leftValue/rightValue is initially 1. If there is element on
                    // left/right of k then left/right value will take that value.
                    int leftValue = 1;
                    int rightValue = 1;
                    if (i != 0) {
                        leftValue = nums[i-1];
                    }
                    if (j != nums.length -1) {
                        rightValue = nums[j+1];
                    }

                    //before is initially 0. If k is i then before will
                    //stay 0 otherwise it gets value T[i][k-1]
                    //after is similarly 0 initially. if k is j then after will
                    //stay 0 other will get value T[k+1][j]
                    int before = 0;
                    int after = 0;
                    if (i != k) {
                        before = T[i][k-1];
                    }
                    if (j != k) {
                        after = T[k+1][j];
                    }
                    T[i][j] = Math.max(leftValue * nums[k] * rightValue + before + after,
                            T[i][j]);
                }
            }
        }

        for(int i = 0 ; i < nums.length ; i++) {
            for(int j = 0 ; j < nums.length ; j++) {
                System.out.print(T[i][j]+" ");
            }
            System.out.println();
        }

        return T[0][nums.length - 1];

    }

    public static void main(String[] args) {
        LC_312_Burst_Balloons lc_312_bb = new LC_312_Burst_Balloons();
        int[] arr = {3,1,5,8};
        System.out.println(lc_312_bb.maxCoins(arr));
    }

}
