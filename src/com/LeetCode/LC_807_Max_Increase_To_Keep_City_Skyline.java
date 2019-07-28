package com.LeetCode;

public class LC_807_Max_Increase_To_Keep_City_Skyline {

    public int maxIncreaseKeepingSkyline(int[][] grid) {
        //2nd index for row/column
        int[][] maxvalues = new int[grid.length][2];
        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0 ; j < grid[0].length ; j++) {
                if (maxvalues[i][0] < grid[i][j]) {
                    maxvalues[i][0] = grid[i][j];
                }
                if (maxvalues[j][1] < grid[i][j]) {
                    maxvalues[j][1] = grid[i][j];
                }
            }
        }
        int solution = 0;
        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0 ; j < grid[0].length ; j++) {
                //System.out.println(maxvalues[i][0]);
                //System.out.println(maxvalues[j][1]);
                solution += (maxvalues[i][0] <= maxvalues[j][1] ? maxvalues[i][0] : maxvalues[j][1]) - grid[i][j];
                //System.out.println(solution);
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        int[][] grid = {{3, 0, 8, 4}, {2, 4, 5, 7},
                {9, 2, 6, 3}, {0, 3, 1, 0}};
        LC_807_Max_Increase_To_Keep_City_Skyline lc_807_mitkcs = new LC_807_Max_Increase_To_Keep_City_Skyline();
        System.out.println(lc_807_mitkcs.maxIncreaseKeepingSkyline(grid));
    }

}
