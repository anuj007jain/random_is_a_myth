package com.LeetCode;

import javafx.scene.layout.Priority;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class LC_0969_Pancake_Sorting {

    public List<Integer> pancakeSort(int[] A) {
        List<Integer> solution = new ArrayList<>();
        int n = A.length;
        while (n > 1) {
            int maxIdx = findMaxIdx(A, n);
            if (maxIdx != 0) {
                solution.add(maxIdx + 1);
            }
            flip(A, maxIdx);
            solution.add(n--);
            flip(A, n);
        }
        return solution;
    }

    private void flip(int[] A, int maxIdx) {
        int i = 0;
        int j = maxIdx;
        while (i < j) {
            swap(A, i++, j--);
        }
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private int findMaxIdx(int[] A, int n) {
        int max = Integer.MIN_VALUE;
        int maxIdx = 0;
        for (int i = 0 ; i < n ; i++) {
            if (A[i] > max) {
                max = A[i];
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    public static void main(String[] args) {
        LC_0969_Pancake_Sorting lc_0969_ps = new LC_0969_Pancake_Sorting();
        System.out.println(lc_0969_ps.pancakeSort(new int[]{3,2,4,1}));
    }

}
