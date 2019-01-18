package com.InterviewProblems;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.Stack;

/*
    1 1 1   1 1 1
    1 0 0   1 0 0
    1 0 0   1 0 1

 */
public class Twitter_Image_Matching {

    public Set<Point> dfs(Point s, int[][] grid, boolean[][] visited) {

        Set<Point> connectedPoints = new HashSet<>();

        Stack<Point> stack = new Stack();
        stack.push(s);
        visited[s.x_coordinate][s.y_coordinate] = true;
        while (!stack.empty()) {
            Point poppedPoint = stack.pop();
            connectedPoints.add(poppedPoint);
            int x = poppedPoint.x_coordinate;
            int y = poppedPoint.y_coordinate;
            if(x != grid.length-1 && !visited[x+1][y] && grid[x+1][y] == 1) {
                stack.push(new Point(x+1, y));
                visited[x+1][y] = true;
            }
            if(y != grid[0].length-1 && !visited[x][y+1] && grid[x][y+1] == 1) {
                stack.push(new Point(x, y+1));
                visited[x][y+1] = true;
            }
        }
        return connectedPoints;
    }

    public int matchingRegions(int[][] grid1, int[][] grid2) {

        Set<Set<Point>> connnectedComponents1 = new HashSet<>();
        boolean[][] visited = new boolean[grid1.length][grid1[0].length];
        for(int x = 0 ; x < grid1.length ; x++) {
            for(int y = 0 ; y < grid1[0].length ; y++) {
                if(grid1[x][y] == 1 && !visited[x][y]) {
                    connnectedComponents1.add(dfs(new Point(x, y), grid1, visited));
                }
            }
        }

        Set<Set<Point>> connnectedComponents2 = new HashSet<>();
        visited = new boolean[grid2.length][grid2[0].length];
        for(int x = 0 ; x < grid2.length ; x++) {
            for(int y = 0 ; y < grid2[0].length ; y++) {
                if(grid2[x][y] == 1 && !visited[x][y]) {
                    connnectedComponents2.add(dfs(new Point(x, y), grid2, visited));
                }
            }
        }

        System.out.println(connnectedComponents1);
        System.out.println(connnectedComponents2);

        connnectedComponents1.retainAll(connnectedComponents2);

        System.out.println(connnectedComponents1.size());

        return 1;

    }

    public static void main(String[] args) {

        int[][] grid1 = new int[][]{{1,1,1},{1,0,1},{1,0,0}};
        int[][] grid2 = new int[][]{{1,1,1},{1,0,0},{1,0,1}};
        new Twitter_Image_Matching().matchingRegions(grid1, grid2);

    }

    class Point {

        Integer x_coordinate;
        Integer y_coordinate;

        public Point(Integer x_coordinate, Integer y_coordinate) {
            this.x_coordinate = x_coordinate;
            this.y_coordinate = y_coordinate;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return Objects.equals(x_coordinate, point.x_coordinate) &&
                    Objects.equals(y_coordinate, point.y_coordinate);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x_coordinate, y_coordinate);
        }

        @Override
        public String toString() {
            return "("+x_coordinate +
                    y_coordinate +")";
        }
    }
}

