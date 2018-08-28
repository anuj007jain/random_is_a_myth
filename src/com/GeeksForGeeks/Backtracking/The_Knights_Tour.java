package com.GeeksForGeeks.Backtracking;

/**
 * Created by anuj on 26/5/16.
 */

//http://www.geeksforgeeks.org/backtracking-set-1-the-knights-tour-problem/
public class The_Knights_Tour {

    public int[][] solution = new int[8][8];
    int flag=0;


    private void solveKT(int x, int y,int visited){

        if(visited == 64) {
            printBoard();
            return;
        }
        else{

            if(x<6 && y<7 && solution[x+2][y+1]==0) {
                if(flag>=1)
                    visited--;
                flag=0;
                visited++;
                solution[x+2][y+1]=visited;
                System.out.println(visited+" ");
                //printBoard();
                solveKT(x + 2, y + 1, visited);
            }
            if(x<6 && y>=1 && solution[x+2][y-1]==0) {
                if(flag>=1)
                    visited--;
                flag=0;
                visited++;
                solution[x+2][y-1]=visited;
                System.out.println(visited+" ");
                //printBoard();
                solveKT(x + 2, y - 1, visited);
            }
            if(x<7 && y<6 && solution[x+1][y+2]==0) {
                if(flag>=1)
                    visited--;
                flag=0;
                visited++;
                solution[x+1][y+2]=visited;
                System.out.println(visited+" ");
                //printBoard();
                solveKT(x + 1, y + 2, visited);
            }
            if(x<7 && y>=2 && solution[x+1][y-2]==0) {
                if(flag>=1)
                    visited--;
                flag=0;
                visited++;
                solution[x+1][y-2]=visited;
                System.out.println(visited+" ");
                //printBoard();
                solveKT(x + 1, y -2, visited);
            }
            if(x>=1 && y<6 && solution[x-1][y+2]==0) {
                if(flag>=1)
                    visited--;
                flag=0;
                visited++;
                solution[x-1][y+2]=visited;
                System.out.println(visited+" ");
                //printBoard();
                solveKT(x - 1, y + 2, visited);
            }
            if(x>=1 && y>=2 && solution[x-1][y-2]==0) {
                if(flag>=1)
                    visited--;
                flag=0;
                visited++;
                solution[x-1][y-2]=visited;
                System.out.println(visited+" ");
                //printBoard();
                solveKT(x - 1, y - 2, visited);
            }
            if(x>=2 && y<7 && solution[x-2][y+1]==0) {
                if(flag>=1)
                    visited--;
                flag=0;
                visited++;
                solution[x-2][y+1]=visited;
                System.out.println(visited+" ");
                //printBoard();
                solveKT(x - 2, y + 1, visited);
            }
            if(x>=2 && y>=1 && solution[x-2][y-1]==0) {
                if(flag>=1)
                    visited--;
                flag=0;
                visited++;
                solution[x-2][y-1]=visited;
                System.out.println(visited+" ");
                //printBoard();
                solveKT(x - 2, y - 1, visited);
            }
            //backtrack

            solution[x][y]=0 ;
            flag ++;
        }
    }

    public static void main(String[] args) {

        The_Knights_Tour tkt = new The_Knights_Tour();
        tkt.solution[0][0]=1;
        tkt.solveKT(0,0,1);

    }

    public void printBoard(){
        for(int i = 0 ; i <8 ; i++) {
            for (int j = 0; j < 8; j++)
                System.out.print(solution[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

}
