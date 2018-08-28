package com.GeeksForGeeks.Backtracking;

/**
 * Created by anuj on 31/5/16.
 */

//http://www.geeksforgeeks.org/backttracking-set-5-m-coloring-problem/
public class m_Coloring_Problem {

    boolean flag = false;

    private void solveMColoringProblem(int[][] graph, int m, int[] solution, int size, int row) {

        if (row == 4) {
            printSolution(solution);
            flag = true;
            return;
        }
        for (int c = 1; c <= m && !flag; c++) {

            if (isSafe(row, graph, solution, c)) {
                solution[row] = c;
                solveMColoringProblem(graph,m,solution,size,row+1);
            }

        }
        if(!flag)
            solution[row]=0;
    }


    private boolean isSafe(int row, int[][] graph, int[] solution, int i){

        for(int j = 0 ; j < solution.length ; j++)
            if(graph[row][j] == 1 && solution[j]==i)
                return false;
        return true;
    }
    private void printSolution(int[] solution){
        for(int i = 0 ; i<solution.length ; i++)
            System.out.print(solution[i]+" ");
    }

    public static void main(String[] args) {

        m_Coloring_Problem mcp = new m_Coloring_Problem();
        int[][] graph = {
                            {0,1,1,1},
                            {1,0,1,0},
                            {1,1,0,1},
                            {1,0,1,0},
                        };
        int m = 3;
        int size = graph.length;
        int[] solution = new int[size];
        mcp.solveMColoringProblem(graph,m,solution,size,0);


    }

}
