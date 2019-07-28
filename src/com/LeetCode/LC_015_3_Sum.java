package com.LeetCode;

import java.util.*;

public class LC_015_3_Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> solution = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0 ; i < nums.length ; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    solution.add(list);
                }
                if (sum > 0) {
                    k--;
                    continue;
                }
                j++;
            }
        }
        return new ArrayList<>(solution);
    }

    public static void main(String[] args) {
        LC_015_3_Sum lc_015_3sum = new LC_015_3_Sum();
        System.out.println(lc_015_3sum.threeSum(new int[]{-1,0,1,2,-1,4}));
    }
}
