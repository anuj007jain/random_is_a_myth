package com.GeeksForGeeks.Backtracking;

/**
 * Created by anuj on 27/5/16.
 */

//http://www.geeksforgeeks.org/backtracking-set-3-n-queen-problem/
public class N_Queens_Problem {

    int N = 8;
    int flag = 0;
    int[][] solution = new int[N][N];

    private boolean isSafe(int x, int y){

        for(int i = 0 ; i < y ; i++)
            if(solution[x][i] == 1)
                return false;

        for(int i = x, j = y ; i>=0 && j>=0 ; i--, j--){
            if(solution[i][j]==1)
                return false;
        }
        for(int i = x, j = y ; i<4 && j>=0 ; i++, j--){
            if(solution[i][j]==1)
                return false;
        }
        return true;
    }
    private void findSolution(int n){

        if(n==N) {
            flag = 1;
            return;
        }
        for(int i = 0 ; i < N && flag!=1; i++){
            if(isSafe(i,n)) {
                solution[i][n]=1;
                findSolution(n + 1);
            }
            //backtrack
            if(flag!=1)
                solution[i][n]=0;
        }



    }

    public static void main(String[] args) {

        N_Queens_Problem fqp = new N_Queens_Problem();
        int[][] grid = new int[fqp.N][fqp.N];
        fqp.findSolution(0);
        for(int i = 0 ; i < fqp.N ; i++){
            for(int j = 0 ; j < fqp.N ; j++)
                System.out.print(fqp.solution[i][j]+" ");
        System.out.println();
        }

    }

}
