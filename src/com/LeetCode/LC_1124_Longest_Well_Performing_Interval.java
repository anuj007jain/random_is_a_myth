package com.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LC_1124_Longest_Well_Performing_Interval {

    public int longestWPI(int[] hours) {
        int res = 0, score = 0, n = hours.length;
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            score += hours[i] > 8 ? 1 : -1;
            if (score > 0) {
                res = i + 1;
            } else {
                seen.putIfAbsent(score, i);
                if (seen.containsKey(score - 1))
                    res = Math.max(res, i - seen.get(score - 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC_1124_Longest_Well_Performing_Interval lc_1124_lwpi = new LC_1124_Longest_Well_Performing_Interval();
        System.out.println(lc_1124_lwpi.longestWPI(new int[]{6,9,9}));
    }
}
