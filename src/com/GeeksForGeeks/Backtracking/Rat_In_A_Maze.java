package com.GeeksForGeeks.Backtracking;

/**
 * Created by anuj on 26/5/16.
 */

//http://www.geeksforgeeks.org/backttracking-set-2-rat-in-a-maze/
public class Rat_In_A_Maze {

    int[][] solution = new int[4][4];
    int flag=0;

    private void findSolution(int[][] maze, int x, int y){

        if(x == maze.length-1 && y == maze[0].length-1) {
            solution[x][y]=1;
            flag=1;
            return;
        }

        else{
            if(x<maze.length-1 && maze[x+1][y] == 1 && flag==0) {
                solution[x+1][y] = 1;
                findSolution(maze, x + 1, y);
            }
            if( y<maze[0].length-1 && maze[x][y+1] == 1 && flag==0) {
                solution[x][y+1] = 1;
                findSolution(maze, x, y + 1);
            }
            //backtrack
            if(flag == 1)
                return;
            solution[x][y]=0;
            return;
        }

    }

    public static void main(String[] args) {

        Rat_In_A_Maze riam = new Rat_In_A_Maze();
        int[][] maze = {{1,1,0,0},
                        {0,1,1,1},
                        {0,1,1,1},
                        {1,1,0,1}};
        riam.solution[0][0] = 1;
        riam.findSolution(maze,0,0);
        riam.printSolution();

    }

    public void printSolution(){
        for(int i = 0 ; i < 4 ; i++) {
            for (int j = 0; j < 4; j++)
                System.out.print(solution[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

}
