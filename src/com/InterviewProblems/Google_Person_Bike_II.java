package com.InterviewProblems;

import org.omg.PortableServer.POA;

import java.util.*;

public class Google_Person_Bike_II {

    static final int[][] dirs = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};

    static class Node {
        int bikeIndex;
        Point currentPoint;
        int distToBike;

        public Node(int bikeIndex, Point currentPoint, int distToBike) {
            this.bikeIndex = bikeIndex;
            this.currentPoint = currentPoint;
            this.distToBike = distToBike;
        }
    }

    static class Point {
        int row;
        int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
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
            return "Point{" +
                    "row=" + row +
                    ", col=" + col +
                    '}';
        }
    }

    public static void main(String[] args) {
        List<Point> persons = new ArrayList<>();
        persons.add(new Point(1,1));
        persons.add(new Point(0,3));
        persons.add(new Point(4,3));

        List<Point> bikes = new ArrayList<>();
        bikes.add(new Point(4,4));
        bikes.add(new Point(0,5));
        bikes.add(new Point(4,0));

        System.out.println(findMyBike(new int[5][6], persons, bikes, new Point(0,1), new boolean[5][6], new ArrayList<Integer>()));
    }

    private static Point findMyBike(int[][] grid, List<Point> persons, List<Point> bikes, Point myPosition,
                                    boolean[][] visited, List<Integer> bikesTaken) {
        Queue<Node> queue = new LinkedList<>();
        for (int i = 0 ; i < bikes.size() ; i++) {
            queue.add(new Node(i, bikes.get(i), 0));
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0 ; i < size ; i++) {
                Node node = queue.poll();
                int row = node.currentPoint.row;
                int col = node.currentPoint.col;
                if (!visited[row][col]) {
                    if (!bikesTaken.contains(node.bikeIndex)) {
                        visited[row][col] = true;
                        Point currentPoint = new Point(row, col);
                        if (currentPoint.equals(myPosition)) {
                            return bikes.get(node.bikeIndex);
                        }
                        if (persons.contains(currentPoint)) {
                            bikesTaken.add(node.bikeIndex);
                            continue;
                        }
                        for (int[] dir : dirs) {
                            int newRow = row + dir[0];
                            int newCol = col + dir[1];
                            if(newRow >= 0 && newRow < grid.length && newCol >=0 && newCol < grid[0].length) {
                                queue.add(new Node(node.bikeIndex, new Point(newRow, newCol), node.distToBike+1));
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

}
