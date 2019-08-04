package com.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LC_0542_01_Matrix {

    public static void main(String[] args) {
        LC_0542_01_Matrix lc_542_01_m = new LC_0542_01_Matrix();
        lc_542_01_m.updateMatrix(new int[][]{
                {1,0,1,1,0,0,1,0,0,1},
                {0,1,1,0,1,0,1,0,1,1},
                {0,0,1,0,1,0,0,1,0,0},
                {1,0,1,0,1,1,1,1,1,1},
                {0,1,0,1,1,0,0,0,0,1},
                {0,0,1,0,1,1,1,0,1,0},
                {0,1,0,1,0,1,0,0,1,1},
                {1,0,0,0,1,1,1,1,0,1},
                {1,1,1,1,1,1,1,0,1,0},
                {1,1,1,1,0,1,0,0,1,1}
        });
    }

    public int[][] updateMatrix(int[][] matrix) {

        int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0 ; i < matrix.length ; i++) {
            for (int j = 0 ; j < matrix[0].length ; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i,j});
                } else {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] top = queue.poll();
            for (int[] dir : dirs) {
                int x = top[0] + dir[0];
                int y = top[1] + dir[1];
                if (x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length)
                    continue;
                if (matrix[x][y] <= matrix[top[0]][top[1]] + 1)
                    continue;
                matrix[x][y] = matrix[top[0]][top[1]] + 1;
                queue.add(new int[]{x,y});
            }
        }
        printMatrix(matrix);
        return matrix;
    }

    public int[][] updateMatrixUsingMarkov(int[][] matrix) {
        //initialization
        int[][] newMatrix = new int[matrix.length][matrix[0].length];
        for (int i = 0 ; i < matrix.length ; i++) {
            for (int j = 0 ; j < matrix[0].length ; j++) {
                if (matrix[i][j] == 0) {
                    newMatrix[i][j] = 0;
                } else {
                    newMatrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        boolean change = true;
        while(change) {
            change = false;
            for (int i = 0 ; i < matrix.length ; i++) {
                for (int j = 0 ; j < matrix[0].length ; j++) {
                    if (matrix[i][j] != 0) {
                        newMatrix[i][j] = findMinDist(i, j, matrix);
                        if (newMatrix[i][j] > matrix[i][j]) {
                            System.out.println("ASd");
                            change = true;
                        }
                    }
                }
            }
            matrix = newMatrix;
            newMatrix = new int[matrix.length][matrix[0].length];
        }
        printMatrix(matrix);
        return matrix;
    }

    public int findMinDist(int i, int j, int[][] matrix) {
        int min = Integer.MAX_VALUE;
        if (i > 0 && matrix[i-1][j] + 1 < min) {
            min = matrix[i-1][j] + 1;
        }
        if (i < matrix.length - 1 && matrix[i+1][j] + 1 < min) {
            min = matrix[i+1][j] + 1;
        }
        if (j > 0 && matrix[i][j-1] + 1 < min) {
            min = matrix[i][j-1] + 1;
        }
        if (j < matrix[0].length - 1 && matrix[i][j+1] < min) {
            min = matrix[i][j+1] + 1;
        }
        return min;
    }

    public void printMatrix (int[][] matrix) {
        for (int i = 0 ; i < matrix.length ; i++) {
            for (int j = 0 ; j < matrix[0].length ; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
}
