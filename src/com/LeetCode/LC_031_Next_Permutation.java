package com.LeetCode;

import java.util.Arrays;

public class LC_031_Next_Permutation {

    public void nextPermutation(int[] nums) {
        boolean flag = false;
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = nums.length - 2 ; i>=0 ; i--) {
            for (int j = i + 1 ; j < nums.length ; j++) {
                if(nums[i] < nums[j]) {
                    flag = true;
                    if(nums[j] < min) {
                        //System.out.println("new min:"+nums[j]);
                        min = nums[j];
                        minIndex = j;
                    }
                }
            }
            if(flag) {
                //System.out.println("i: "+i+" min index: "+minIndex);
                swap(nums, i, minIndex);
                Arrays.sort(nums, i+1, nums.length);
                return;
            }
        }
        Arrays.sort(nums);
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        LC_031_Next_Permutation lc_031_np = new LC_031_Next_Permutation();
        int[] nums = {1,1,5,4};
        lc_031_np.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

}
