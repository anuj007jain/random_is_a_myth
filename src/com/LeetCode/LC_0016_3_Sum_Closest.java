package com.LeetCode;

import java.util.Arrays;

public class LC_0016_3_Sum_Closest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int best = nums[0] + nums[1] + nums [2];
        for (int i = 0 ; i < nums.length -2 ; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                    if (best == target) {
                        return best;
                    }
                }
                if (sum > target) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return best;
    }

    public static void main(String[] args) {
        LC_0016_3_Sum_Closest lc_016_3_sc = new LC_0016_3_Sum_Closest();
        System.out.println(lc_016_3_sc.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
    }

}
