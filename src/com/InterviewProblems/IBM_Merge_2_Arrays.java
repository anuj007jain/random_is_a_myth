package com.InterviewProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IBM_Merge_2_Arrays {

    public static List<Integer> mergeArrays(List<Integer> a, List<Integer> b) {
        // Write your code here
        List<Integer> mergedArray = new ArrayList<>();
        int i = 0, j = 0;
        while (i < a.size() && j < b.size()) {
            if (a.get(i) <= b.get(j)) {
                mergedArray.add(a.get(i++));
            } else {
                mergedArray.add(b.get(j++));
            }
        }
        while (i < a.size()) {
            mergedArray.add(a.get(i++));
        }
        while (j < b.size()) {
            mergedArray.add(b.get(j++));
        }
        return mergedArray;
    }

    public static void main(String[] args) {
        IBM_Merge_2_Arrays ibmm2a = new IBM_Merge_2_Arrays();
        System.out.println(ibmm2a.mergeArrays(Arrays.asList(1,2,3), Arrays.asList(2,5,5)));
    }

}
