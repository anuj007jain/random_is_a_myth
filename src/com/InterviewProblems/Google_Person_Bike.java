package com.InterviewProblems;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class Google_Person_Bike {

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

    int distToBike(int[][] grid, Point bikePos, Point personPos) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(personPos);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point point = queue.poll();
                System.out.println(point);
                if (point.equals(bikePos)) {
                    return point.dist;
                }
                addNeighbouringPoints(grid, point, queue);
            }
        }
        return -1;
    }

    private void addNeighbouringPoints(int[][] grid, Point point, Queue<Point> queue) {
        for(int[] dir : dirs) {
            int row = point.row + dir[0];
            int col = point.col + dir[1];
            if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length) {
                queue.add(new Point(row, col, point.dist+1));
            }
        }
    }

    public static void main(String[] args) {
        Google_Person_Bike gpb = new Google_Person_Bike();
        System.out.println(gpb.distToBike(new int[3][4], new Point(1,2,0), new Point(2,0,0)));
    }
}
