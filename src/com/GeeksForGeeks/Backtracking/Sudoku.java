package com.GeeksForGeeks.Backtracking;

/**
 * Created by anuj on 29/5/16.
 */

//http://www.geeksforgeeks.org/backtracking-set-7-suduku/
public class Sudoku {

    boolean flag = false;


    private int[][] findFilledSudokuElements(int[][] sudoku){
        int[][] filledSudokuElements = new int[9][9];
        for(int i = 0 ; i < 9 ; i++)
            for(int j = 0 ; j < 9 ; j++)
                if(sudoku[i][j]!=0)
                    filledSudokuElements[i][j]=1;
        return filledSudokuElements;
    }

    private void SudokuSolver(int [][] sudoku,int[][] initialSudoku, int x, int y){

        //base condition
        if(x == 9){
            flag = true;
            return;
        }

        if(sudoku[x][y] != 0 && !flag) {
            if (y < 8)
                SudokuSolver(sudoku,initialSudoku, x, y+1);
            else
                SudokuSolver(sudoku,initialSudoku,x+1, 0);
        }

        for(int i = 1; i <= 9 && !flag; i++ ){

            if(isSafe(sudoku,x,y,i)){
                if(initialSudoku[x][y]==0)
                    sudoku[x][y] = i;
                if (y < 8)
                    SudokuSolver(sudoku,initialSudoku, x, y+1);
                else
                    SudokuSolver(sudoku, initialSudoku ,x+1, 0);
            }

        }
        //backtrack
        if(!flag && initialSudoku[x][y]==0)
            sudoku[x][y] = 0;
    }

    private boolean isSafe(int[][] sudoku, int x, int y, int value){

        //check row and column
        for(int i = 0; i < 9; i++)
            if(sudoku[x][i] == value || sudoku[i][y] == value)
                return false;

        //check inner box
        for(int i = (x/3)*3 ; i < (x/3)*3+3 ; i++)
            for(int j = (y/3)*3 ; j < (y/3)*3+3 ; j++)
                if(sudoku[i][j] == value)
                    return false;

        return true;

    }

    private void printSudoko(int[][] sudoku){

        for(int i = 0 ; i < 9 ; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(sudoku[i][j]+"     ");
            System.out.println();
        }

    }

    public static void main(String[] args) {

        Sudoku s = new Sudoku();
        int[][] sudoku = {
                            {0,0,5,0,2,0,0,0,0},
                            {3,7,0,4,6,0,8,0,0},
                            {0,1,8,0,9,0,4,6,0},
                            {6,0,3,0,0,0,0,7,0},
                            {7,0,0,6,1,5,0,0,3},
                            {0,8,0,0,0,0,6,0,4},
                            {0,3,7,0,4,0,5,9,0},
                            {0,0,6,0,5,8,0,3,2},
                            {0,0,0,0,3,0,7,0,0}
                           };

        int[][] sudoku2 = new int[9][9];

        int[][] initialsudoku = s.findFilledSudokuElements(sudoku);
        s.SudokuSolver(sudoku,initialsudoku,0,0);
        s.printSudoko(sudoku);



    }

}
