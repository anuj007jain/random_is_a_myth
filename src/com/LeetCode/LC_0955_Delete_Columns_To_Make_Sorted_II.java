package com.LeetCode;

import java.util.Arrays;

public class LC_0955_Delete_Columns_To_Make_Sorted_II {

    public int minDeletionSize(String[] A) {
        String[] temp1 = new String[A.length];
        String[] temp2 = new String[A.length];
        int size = A[0].length();
        int c = 0;
        for(int i = 0 ; i < size ; i++) {
            for (int j = 0 ; j < A.length ; j++) {
                temp1[j] = temp1[j]+String.valueOf(A[j].charAt(i));
            }
            if(!isSorted(temp1)) {
                c++;
                temp1 = Arrays.copyOf(temp2, temp2.length);
            } else {
                temp2 = Arrays.copyOf(temp1, temp1.length);
            }
        }
        return c;
    }

    public boolean isSorted(String[] A) {
        for (int i = 0; i < A.length - 1; ++i)
            if (A[i].compareTo(A[i+1]) > 0)
                return false;

        return true;
    }

    public static void main(String[] args) {
        LC_0955_Delete_Columns_To_Make_Sorted_II lc_955_dctmsii = new LC_0955_Delete_Columns_To_Make_Sorted_II();
        String[] arr = {"jwkwdc","etukoz"};
        System.out.println(lc_955_dctmsii.minDeletionSize(arr));
    }

}
