package com.InterviewProblems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*

    4*6 matrix
    g = guard
    w = wall
    guard can watch left, right, up, down, but not through walls

    Input :
    4 6
    0 0 g
    0 1 w
    1 1 g
    2 2 w
    2 3 g

    g w . - . .
    - g - - - -
    - - w g - -
    - - . - . .

 */

public class Poshmark_Museum_Security {

    public static void main(String args[] ) throws Exception {

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String mn = br.readLine();
        Integer m = Integer.parseInt(mn.split(" ")[0]);
        Integer n = Integer.parseInt(mn.split(" ")[1]);

        List<Point> guards = new ArrayList<>();
        boolean[][] walls = new boolean[m][n];
        boolean[][] guardedRooms = new boolean[m][n];

        for(int i = 0 ; i < 5 ; i++) {
            String input = br.readLine();
            if (input == null) {
                break;
            } else {
                String[] inputParameters = input.split(" ");
                if (inputParameters[2].equals("g")) {
                    guards.add(new Point(Integer.parseInt(inputParameters[0]), Integer.parseInt(inputParameters[1])));
                }
                else if(inputParameters[2].equals("w")) {
                    walls[Integer.parseInt(inputParameters[0])][Integer.parseInt(inputParameters[1])] = true;
                    guardedRooms[Integer.parseInt(inputParameters[0])][Integer.parseInt(inputParameters[1])] = true;
                }
            }
        }

        for(Point guard : guards) {
            int x = guard.x_coordinate;
            int y = guard.y_coordinate;
            guardedRooms[x][y] = true;
            //UP
            int k = x-1;
            while(k >= 0) {
                if(walls[k][y]) {
                    break;
                }
                if(guardedRooms[k][y]) {
                    k--;
                    continue;
                }
                guardedRooms[k--][y] = true;
            }
            //DOWN
            k = x+1;
            while(k < m) {
                if(walls[k][y]) {
                    break;
                }
                if(guardedRooms[k][y]) {
                    k++;
                    continue;
                }
                guardedRooms[k++][y] = true;
            }
            //LEFT
            k = y-1;
            while(k >= 0) {
                if(walls[x][k]) {
                    break;
                }
                if(guardedRooms[x][k]) {
                    k--;
                    continue;
                }
                guardedRooms[x][k--] = true;
            }
            //RIGHT
            k = y+1;
            while(k < n) {
                if(walls[x][k]) {
                    break;
                }
                if(guardedRooms[x][k]) {
                    k++;
                    continue;
                }
                guardedRooms[x][k++] = true;
            }
        }

        boolean flag = true;
        for(int x = 0 ; x < m ; x++) {
            for(int y = 0 ; y < n ; y++) {
                if(!guardedRooms[x][y]) {
                    if(flag) {
                        System.out.println("false");
                        System.out.println(x+" "+y);
                        flag = false;
                    } else {
                        System.out.println(x+" "+y);
                    }
                }
            }
        }
        if(flag) {
            System.out.println("true");
        }
    }

    static class Point {

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
