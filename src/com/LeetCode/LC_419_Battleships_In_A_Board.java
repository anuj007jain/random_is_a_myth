package com.LeetCode;

public class LC_419_Battleships_In_A_Board {

    public int countBattleships(char[][] board) {
        int battleships = 0;
        for (int i = 0 ; i < board.length ; i++) {
            boolean leftEmpty = true;
            for (int j = 0 ; j < board[0].length ; j++) {
                if (board[i][j] == 'X') {
                    if (!leftEmpty) {
                        continue;
                    }
                    leftEmpty = false;
                    if (i > 0 && board[i-1][j] == 'X') {
                        continue;
                    }
                    battleships++;
                } else {
                    leftEmpty = true;
                }
            }
        }
        return battleships;
    }

    public static void main(String[] args) {
        LC_419_Battleships_In_A_Board lc_419_biab = new LC_419_Battleships_In_A_Board();
        char[][] board = {{'X','.','.','X'},{'.','.','.','X'},{'.','.','.','X'}};
        System.out.println(lc_419_biab.countBattleships(board));
    }
}
