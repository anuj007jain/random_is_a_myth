package com.LeetCode;

public class LC_0036_Valid_Sudoku {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0 ; i < 9 ; i++) {
            for (int j = 0 ; j < 9 ; j++) {
                if (board[i][j] != '.' && (!checkRow(i, j, board[i][j], board) || !checkColumn(i, j, board[i][j], board)
                        || !checkBox(i, j, board[i][j], board))) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean checkColumn(int x, int y, char c, char[][] board) {
        for(int j = 0 ; j < 9 ; j++) {
            if (c == board[x][j] && j != y) {
                return false;
            }
        }
        return true;
    }

    public boolean checkRow(int x, int y, char c, char[][] board) {
        for(int i = 0 ; i < 9 ; i++) {
            if (c == board[i][y] && i != x) {
                return false;
            }
        }
        return true;
    }

    public boolean checkBox(int x, int y, char c, char[][] board) {
        for(int i = 3*(x/3) ; i < 3*(x/3 + 1) ; i++) {
            for(int j = 3*(y/3) ; j < 3*(y/3 + 1) ; j++) {
                if(c == board[i][j] && i != x && j != y) {
                    return false;
                }
            }
        }
        return true;
    }

}
