package com.GeeksForGeeks.Backtracking;

/**
 * Created by anuj on 1/6/16.
 */

//http://www.geeksforgeeks.org/backtracking-set-7-hamiltonian-cycle/
public class Hamiltonian_Cycle {

    boolean flag = false;
    int[] visited = new int[5];

    private void findHamiltonianCycle(int[][] graph,int[] solution,int lastVertex,int  solved){

        if(solved == 0) { //first time
            solution[solved]=lastVertex;
            visited[solved]=1;
            solved++;
            findHamiltonianCycle(graph,solution,0,solved);
        }

        if(solved==solution.length){
            flag = true;
            return;
        }

        for(int i = 0 ; i < solution.length ; i++){
                if(graph[lastVertex][i] == 1 && visited[i]==0){
                    solution[solved]= i;
                    visited[i]=1;
                    findHamiltonianCycle(graph,solution,i,solved+1);
                }
        }
        if(!flag)
            solution[solved]=0;

        return;
    }

    private void printSolution(int[] solution){
        for(int i = 0 ; i<solution.length ; i++)
            System.out.print(solution[i]+" ");
    }


    public static void main(String[] args) {

        int v = 5;
        Hamiltonian_Cycle hc = new Hamiltonian_Cycle();
        int[] solution = new int[5];
        int[][] graph = {
                            {0, 1, 0, 1, 0},
                            {1, 0, 1, 1, 1},
                            {0, 1, 0, 0, 1},
                            {1, 1, 0, 0, 0},
                            {0, 1, 1, 0, 0}
                        };
        hc.findHamiltonianCycle(graph,solution,0,0);
        if(!hc.flag)
            System.out.print("No solution");
        else
            hc.printSolution(solution);

    }

}