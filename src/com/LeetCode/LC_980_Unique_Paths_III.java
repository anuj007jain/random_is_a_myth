package com.LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LC_980_Unique_Paths_III {

    public static int count = 0;

    public static void main(String[] args) {
        LC_980_Unique_Paths_III lc_980_unique_paths_iii = new LC_980_Unique_Paths_III();
        int[][] grid = new int[3][4];
        grid[0][0] = 1;
        grid[2][2] = 2;
        grid[2][3] = -1;
        lc_980_unique_paths_iii.uniquePathsIII(grid);
        System.out.println(count);
    }


    public int uniquePathsIII(int[][] grid) {
        Map<PointType, Point> terminalPoints = findTerminalPoints(grid);
        uniquePathsIIIInternal(terminalPoints.get(PointType.START), terminalPoints.get(PointType.END), grid
                , new boolean[grid.length][grid[0].length]);
        return 0;
    }

    private void uniquePathsIIIInternal(Point current, Point end, int[][] grid, boolean[][] visited) {

        visited[current.getX()][current.getY()] = true;

        //base condition
        if (current.equals(end)) {
            for(int i = 0 ; i < grid.length ; i++) {
                for (int j = 0 ; j < grid[0].length ; j++) {
                    if(!visited[i][j] && grid[i][j] != -1) {
                        return;
                    }
                }
            }
            count++;
            return;
        }

        Point next = go(current, Direction.TOP);
        if (valid(next, grid, visited)) {
            uniquePathsIIIInternal(next, end, grid, visited);
            visited[next.getX()][next.getY()] = false;
        }
        next = go(current, Direction.DOWN);
        if (valid(next, grid, visited)) {
            uniquePathsIIIInternal(next, end, grid, visited);
            visited[next.getX()][next.getY()] = false;
        }
        next = go(current, Direction.LEFT);
        if (valid(next, grid, visited)) {
            uniquePathsIIIInternal(next, end, grid, visited);
            visited[next.getX()][next.getY()] = false;
        }
        next = go(current, Direction.RIGHT);
        if (valid(next, grid, visited)) {
            uniquePathsIIIInternal(next, end, grid, visited);
            visited[next.getX()][next.getY()] = false;
        }
    }

    private boolean valid(Point next, int[][] grid, boolean[][] visited) {
        if (next.getX() < 0 || next.getX() >= grid.length) {
            return false;
        }
        if (next.getY() < 0 || next.getY() >= grid[0].length) {
            return false;
        }
        if (grid[next.getX()][next.getY()] == -1) {
            return false;
        }
        if (visited[next.getX()][next.getY()]) {
            return false;
        }
        return true;
    }

    private Point go(Point current, Direction dir) {
        if (Direction.LEFT == dir) {
            return new Point(current.getX(), current.getY() - 1);
        }
        if (Direction.RIGHT == dir) {
            return new Point(current.getX(), current.getY() + 1);
        }
        if (Direction.TOP == dir) {
            return new Point(current.getX() - 1, current.getY());
        }
        if (Direction.DOWN == dir) {
            return new Point(current.getX() + 1, current.getY());
        }
        return null;
    }


    enum PointType {
        START
        , END
    }

    enum Direction {
        TOP, DOWN, LEFT, RIGHT
    }


    public Map<PointType, Point> findTerminalPoints(int[][] grid) {
        Map<PointType, Point> terminalPoints = new HashMap<>();
        for (int i = 0 ; i < grid.length ; i++) {
            for (int j = 0 ; j < grid[i].length ; j++) {
                if (grid[i][j] == 1) {
                    terminalPoints.put(PointType.START, new Point(i, j));
                    if (terminalPoints.size() == 2) {
                        return terminalPoints;
                    }
                }
                else if (grid[i][j] == 2) {
                    terminalPoints.put(PointType.END, new Point(i, j));
                    if (terminalPoints.size() == 2) {
                        return terminalPoints;
                    }
                }
            }
        }
        return null; // should never happen in a valid grid
    }

    class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX(){
            return this.x;
        }

        public int getY() {
            return this.y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY() {
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
