package com.LeetCode;

import java.util.Arrays;

public class LC_498_Diagonal_Traverse {

    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int row = 0, col = 0, k = 0;
        int M = matrix.length;
        int N = matrix[0].length;
        int[] solution = new int[M * N];
        while (k < solution.length) {
            //going up
            while (row >= 0 && col < N) {
                solution[k++] = matrix[row--][col++];
                //System.out.println(solution[k-1]);
            }
            if (col >= N) {
                row += 2;
                col--;
            } else {
                row = 0;
            }
            //going down
            while (col >= 0 && row < M) {
                solution[k++] = matrix[row++][col--];
                //System.out.println(solution[k-1]);
            }
            if (row >= M) {
                col += 2;
                row--;
            } else {
                col = 0;
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        LC_498_Diagonal_Traverse lc_498_dt = new LC_498_Diagonal_Traverse();
        System.out.println(Arrays.toString(lc_498_dt.findDiagonalOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}})));
    }

}
