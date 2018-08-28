package com.LeetCode;

import java.util.Arrays;

/**
 * Created by anuj.jain02 on 25/9/17.
 */
public class LC_062_Unique_Paths {

    static int count = 0;
    static int[][] input = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};

    static private void findUniquePaths(int x, int y, int m, int n, int[] path, int pathCounter){

        if(x == m-1) {
            while (y != n-1) {
                path[pathCounter++] = input[x][y++];
            }
        }
        if(y == n-1){
            while (x != m-1){
                path[pathCounter++] = input[x++][y];
            }
        }
        path[pathCounter++] = input[x][y];

        if(x == m-1 && y == n-1){
            System.out.println(Arrays.toString(path));
            count++;
            return;
        }

        findUniquePaths(x + 1, y, m, n, path, pathCounter);
        findUniquePaths(x, y + 1, m, n, path, pathCounter);
        //findUniquePaths(x+1, y + 1, m, n, path, pathCounter);
    }

    public static void main(String[] args) {
        int m = 4;
        int n = 4;
        uniquePaths(m,n);
    }

    public static void uniquePaths(int m, int n) {
        findUniquePaths(0, 0, m, n, new int[m+n-1], 0);
    }
}
