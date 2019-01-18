package com.LeetCode;

//https://leetcode.com/problems/game-of-life/
public class LC_289_Game_Of_Life {

    public void gameOfLife(int[][] board) {

        int m = board.length, n = board[0].length;

        for (int i = 0 ; i < m ; i++) {
            for (int j = 0 ;j < n ; j++) {
                int nearbyLives = calculateNearbyLives(board, m, n, i, j);

                if(board[i][j] == 1 && (nearbyLives == 2 || nearbyLives == 3)) {
                    board[i][j] = 3;
                } else  if (board[i][j] == 0 && nearbyLives == 3) {
                    board[i][j] = 2;
                }
            }
        }

        output(board);

    }

    private void output(int[][] board) {
        for (int i = 0 ; i < board.length ; i++) {
            for (int j = 0 ; j < board[0].length ; j++) {
                System.out.print(board[i][j] >> 1);
            }
            System.out.println();
        }
    }

    private int calculateNearbyLives(int[][] board, int m, int n, int x, int y) {

        int nearbyLives = 0;
        for (int i = Math.max(x-1, 0) ; i <= Math.min(x+1, m-1) ; i++) {
            for (int j = Math.max(y-1, 0) ; j <= Math.min(y+1, n-1) ; j++) {
                nearbyLives += board[i][j] & 1;
            }
        }
        nearbyLives -= board[x][y] & 1;
        return nearbyLives;

    }

    public static void main(String[] args) {

        LC_289_Game_Of_Life lc_289_gol = new LC_289_Game_Of_Life();
        int[][] input = new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        lc_289_gol.gameOfLife(input);

    }

}
