package com.GeeksForGeeks.DynamicProgramming;

/**
 * Created by anuj on 14/5/16.
 */

//http://www.geeksforgeeks.org/dynamic-programming-set-6-min-cost-path/
public class Min_Cost_Path {

    private void findMinCost(int[][] costMatrix){

        int m = costMatrix.length;
        int n = costMatrix[0].length;
        int[][] minCostMatrix = new int[m+1][n+1];

        for(int i = 0 ; i <= m ; i++){
            for(int j = 0 ; j <= n ; j++){
                if(i == 0 || j == 0) {
                    if(i == 0 && j == 0)
                        minCostMatrix[i][j] = 0;
                    else
                        minCostMatrix[i][j] = Integer.MAX_VALUE;

                }
                else{
                    minCostMatrix[i][j] = costMatrix[i-1][j-1] + min(minCostMatrix[i-1][j-1],minCostMatrix[i-1][j], minCostMatrix[i][j-1]);
                }
            }
        }
        /*for(int i = 0 ; i <= m ; i++){
            for(int j = 0 ; j <= n ; j++){
                System.out.print(minCostMatrix[i][j]+" ");
            }
            System.out.println();
        }*/

        System.out.print(minCostMatrix[m][n]);
    }


    private int min(int x, int y, int z){
        if(x <= y && x <= z)
            return x;
        if(y <= x && y <= z)
            return y;
        return z;
    }

    public static void main(String[] args) {

        Min_Cost_Path mcp = new Min_Cost_Path();
        int[][] costMatrix = {{1,2,3},{4,8,2},{1,5,3}};
        mcp.findMinCost(costMatrix);

    }

}
