package com.GeeksForGeeks.DynamicProgramming;

/**
 * Created by anuj on 13/5/16.
 */


//http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
public class Longest_Common_Subsequence {

    private int max(int x, int y) {
        return (x > y)? x:y;
    }


    private void LCS(String x, String y){

        int m = x.length();
        int n = y.length();
        int[][] matrix = new int[m+1][n+1];

        for(int i = 0 ; i <= m; i++){
            for(int j = 0 ; j <= n ; j++){

                if( i == 0 || j == 0 )
                    matrix[i][j]=0;

                else if(x.charAt(i-1) == y.charAt(j-1))
                    matrix[i][j] = matrix[i-1][j-1]+1;

                else
                    matrix[i][j] = max(matrix[i-1][j],matrix[i][j-1]);

            }
        }
        /*for(int i =0; i<=m;i++) {
            for (int j = 0; j <= n; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.println();
        }*/
        System.out.print(matrix[m][n]);
    }

    public static void main(String[] args) {

        Longest_Common_Subsequence lcs = new Longest_Common_Subsequence();
        String A = "AGGTAB";
        String B = "GXTXAYB";
        lcs.LCS(A,B);


    }

}
