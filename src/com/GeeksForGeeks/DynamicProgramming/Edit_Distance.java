package com.GeeksForGeeks.DynamicProgramming;

/**
 * Created by anuj on 13/5/16.
 */

//http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
public class Edit_Distance {

    private int min(int x, int y, int z){
        if(x <= y && x <= z)
            return x;
        if(y <= x && y <= z)
            return y;
        return z;
    }

    private void findEditDistance(String str1, String str2){

        int m = str1.length();
        int n = str2.length();

        int[][] matrix = new int[m+1][n+1];

        for(int i = 0 ; i <= m ; i++){
            for(int j = 0 ; j <= n ; j++){
                if(i == 0)
                    matrix[i][j]=j;
                else if(j == 0)
                    matrix[i][j]=i;
                else if(str1.charAt(i-1) == str2.charAt(j-1))
                    matrix[i][j] = matrix[i-1][j-1];
                else
                    matrix[i][j] = 1+min(matrix[i-1][j-1], matrix[i-1][j], matrix[i][j-1]);
            }
        }
        /*for(int i = 0 ; i <= m ; i++){
            for(int j = 0 ; j <= n ; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }*/
        System.out.print(matrix[m][n]);

    }

    public static void main(String[] args) {

        Edit_Distance ed = new Edit_Distance();
        String str1 = "sunday";
        String str2 = "saturday";
        ed.findEditDistance(str1,str2);
    }

}
