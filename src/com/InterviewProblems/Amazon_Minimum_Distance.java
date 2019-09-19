package com.InterviewProblems;

import java.util.*;

public class Amazon_Minimum_Distance {

    static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    static class Point {
        int row;
        int col;
        int dist;

        Point(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return row == point.row &&
                    col == point.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }

        @Override
        public String toString() {
            return "(" + row +
                    ", " + col +
                    ", " + dist +
                    ')';
        }
    }

    int minimumDistance(int numRows, int numColumns, List<List<Integer>> area)
    {
        boolean visited[][] = new boolean[numRows][numColumns];
        Point destination = new Point(0,0,0);
        boolean[][] grid = new boolean[numRows][numColumns];
        for (int i = 0 ; i < numRows ; i++) {
            List<Integer> row = area.get(i);
            for (int j = 0 ; j < numColumns ; j++) {
                if (row.get(j) == 0) {
                    grid[i][j] = false;
                } else if (row.get(j) == 1) {
                    grid[i][j] = true;
                } else {
                    grid[i][j] = true;
                    destination = new Point(i, j, 0);
                }
            }
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0,0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                visited[point.row][point.col] = true;
                //System.out.println(point);
                if (point.equals(destination)) {
                    return point.dist;
                }
                addNeighbouringPoints(grid, point, queue, visited);
            }
        }
        return -1;
    }

    private void addNeighbouringPoints(boolean[][] grid, Point point, Queue<Point> queue, boolean[][] visited) {
        for(int[] dir : dirs) {
            int row = point.row + dir[0];
            int col = point.col + dir[1];
            if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] && !visited[row][col]) {
                queue.add(new Point(row, col, point.dist+1));
            }
        }
    }

    public static void main(String[] args) {
        Amazon_Minimum_Distance amd = new Amazon_Minimum_Distance();
        List<List<Integer>> area = Arrays.asList(
                Arrays.asList( 1, 0, 0 ),
                Arrays.asList( 1, 0, 0 ),
                Arrays.asList( 1, 9, 1 ) );

        System.out.println(amd.minimumDistance(3,3, area));
    }
}
