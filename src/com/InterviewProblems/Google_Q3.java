package com.InterviewProblems;

import java.util.Arrays;

public class Google_Q3 {

    private int[] papa_solution(int D, int[] A) {
        int[][] matrix = new int[D][A.length];

        //base condition for depth 1 at row 0
        for (int j = 0 ; j < A.length ; j++) {
            matrix[0][j] = A[j];
        }

        for (int i = 1 ; i < D ; i++) {
            for (int j = 0 ; j < A.length ; j++) {
                if (matrix[i-1][j] == -1) {
                    matrix[i][j] = -1;
                } else {
                    matrix[i][j] = matrix[0][matrix[i-1][j]];
                }
            }
        }
        return matrix[D-1];
    }

    public int[] kids_solution(int D, int[] A) {

        int[] solution = new int[A.length];

        for(int element = 0 ; element < A.length ; element++) {
            int parent = element;
            for (int i = 0 ; i < D ; i++) {
                parent = A[parent];
                if(parent == -1) {
                    solution[element] = -1;
                    break;
                }
            }
            if(solution[element] == 0) {
                solution[element] = parent;
            }
        }
        return solution;

    }

    public static void main(String[] args) {

        Google_Q3 gq3 = new Google_Q3();
        System.out.println(Arrays.toString(gq3.kids_solution(4, new int[]{-1, 0, 3, 6, 1, 4, 7, 0})));
        System.out.println(Arrays.toString(gq3.papa_solution(4, new int[]{-1, 0, 3, 6, 1, 4, 7, 0})));

    }

}
