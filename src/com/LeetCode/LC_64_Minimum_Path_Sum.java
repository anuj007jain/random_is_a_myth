package com.LeetCode;

//https://leetcode.com/problems/minimum-path-sum/
public class LC_64_Minimum_Path_Sum {

    public int minPathSum(int[][] grid) {

        int[][] solutionMatrix = new int[grid.length][grid[0].length];

        //base cases
        int sum = 0;
        for(int i = 0 ; i < grid.length ; i++) {
            sum += grid[i][0];
            solutionMatrix[i][0] = sum;
        }
        sum = 0;
        for(int j = 0 ; j < grid[0].length ; j++) {
            sum += grid[0][j];
            solutionMatrix[0][j] = sum;
        }

        for (int i = 1 ; i < grid.length ; i++) {
            for (int j = 1 ; j < grid[0].length ; j++) {
                solutionMatrix[i][j] = Math.min(solutionMatrix[i-1][j], solutionMatrix[i][j-1]) + grid[i][j];
            }
        }
        return solutionMatrix[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {

        LC_64_Minimum_Path_Sum lc_64_mps = new LC_64_Minimum_Path_Sum();
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(lc_64_mps.minPathSum(grid));

    }

}

