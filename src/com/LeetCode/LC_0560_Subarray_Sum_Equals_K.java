package com.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LC_0560_Subarray_Sum_Equals_K {

    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> sumWithCount = new HashMap<>();
        int count = 0;
        int sum = 0;
        sumWithCount.put(0, 1);
        for (int i = 0 ; i < nums.length ; i++) {
            sum += nums[i];
            if (sumWithCount.containsKey(sum-k)) {
                count+=sumWithCount.get(sum-k);
            }
            if(sumWithCount.containsKey(sum)) {
                sumWithCount.put(sum, sumWithCount.get(sum)+1);
            } else {
                sumWithCount.put(sum, 1);
            }
        }
        return count;
    }

}
