package com.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC_0054_Spiral_Matrix {

    public List<Integer> spiralOrder(int[][] matrix) {

        if(matrix == null || matrix.length == 0) {
            return new ArrayList<>();
        }

        int minRow = 0, maxRow = matrix.length - 1, minCol = 0, maxCol = matrix[0].length - 1;
        List<Integer> solution = new ArrayList<>();

        Map<String, String> currentToNextDirection = new HashMap<>();
        currentToNextDirection.put("RIGHT","DOWN");
        currentToNextDirection.put("DOWN","LEFT");
        currentToNextDirection.put("LEFT","UP");
        currentToNextDirection.put("UP","RIGHT");

        String currentDirection = "UP";
        while(solution.size() < matrix.length * matrix[0].length) {
            currentDirection = currentToNextDirection.get(currentDirection);
            if (currentDirection.equals("RIGHT")) {
                for (int col = minCol ; col <= maxCol ; col++) {
                    solution.add(matrix[minRow][col]);
                }
                minRow++;

            }
            else if (currentDirection.equals("DOWN")) {
                for (int row = minRow ; row <= maxRow ; row++) {
                    solution.add(matrix[row][maxCol]);
                }
                maxCol--;
            }
            else if (currentDirection.equals("LEFT")) {
                for (int col = maxCol ; col >= minCol ; col--) {
                    solution.add(matrix[maxRow][col]);
                }
                maxRow--;
            }
            else {
                for (int row = maxRow ; row >= minRow ; row--) {
                    solution.add(matrix[row][minCol]);
                }
                minCol++;
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        LC_0054_Spiral_Matrix lc_054_sm = new LC_0054_Spiral_Matrix();
        System.out.println(lc_054_sm.spiralOrder(matrix));
    }

}
