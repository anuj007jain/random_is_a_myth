package com.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC_0349_Intersection_Of_Two_Arrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        for (int num1 : nums1) {
            set1.add(num1);
        }
        for (int num2 : nums2) {
            if(set1.contains(num2)) {
                list.add(num2);
                set1.remove(num2);
            }
        }
        return convertIntegers(list);
    }

    public static int[] convertIntegers(List<Integer> integers)
    {
        int[] ret = new int[integers.size()];
        for (int i=0; i < ret.length; i++)
        {
            ret[i] = integers.get(i).intValue();
        }
        return ret;
    }
}
