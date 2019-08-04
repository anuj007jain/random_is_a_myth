package com.LeetCode;

public class LC_0152_Maximum_Product_Subarray {

    public int maxProduct(int[] nums) {

        int best = 1;
        int positive = 1, negative = 1;

        for (int i = 0 ; i <  nums.length ; i++) {

            if (nums[i] == 0) {
                if (best < positive) {
                    best = positive;
                }
                positive = 1;
                negative = 1;
            } else if (nums[i] > 0) {
                positive = positive * nums[i];
                negative = Math.min(negative * nums[i], 1);
            } else {
                int temp = positive;
                positive = Math.max(negative * nums[i], 1);
                negative = temp * nums[i];
            }
            if (best < positive) {
                best = positive;
            }
        }
        return best;
    }

    public static void main(String[] args) {
        LC_0152_Maximum_Product_Subarray lc_152_mps = new LC_0152_Maximum_Product_Subarray();
        int[] arr1 = {};
        System.out.println(lc_152_mps.maxProduct(new int[]{2, 3, -2, 4}));
    }

}
