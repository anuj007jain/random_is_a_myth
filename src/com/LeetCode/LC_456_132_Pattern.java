package com.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC_456_132_Pattern {

    public boolean find132pattern(int[] nums) {
        if(nums.length < 3) {
            return false;
        }
        List<int[]> previousRanges = new ArrayList<int[]>();
        boolean previousPresent = false;
        int i = 0 ;
        while(i+1 < nums.length && nums[i+1] < nums[i]) {
            i++;
        }
        if(i+1 == nums.length) {
            return false;
        }
        int min = nums[i++];
        int max = nums[i++];
        while(i < nums.length) {
            if (nums[i] >= max) {
                if (previousPresent) {
                    for (int[] previousRange : previousRanges) {
                        if (nums[i] > previousRange[0] && nums[i] < previousRange[1]) {
                            return true;
                        }
                        if (nums[i] > previousRange[1]) {
                            continue;
                        }
                    }
                }
                max = nums[i++];
                continue;
            }
            if (nums[i] > min) {
                return true;
            }
            previousRanges.add(new int[]{min, max});
            min = nums[i];
            max = nums[i];
            previousPresent = true;
            i++;
        }
        return false;
    }
}
