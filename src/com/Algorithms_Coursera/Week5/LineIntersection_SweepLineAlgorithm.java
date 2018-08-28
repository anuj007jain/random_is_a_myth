package com.Algorithms_Coursera.Week5;

import com.Algorithms_Coursera.Week4.SymbolTables.BinarySearchTree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by anuj.jain02 on 1/11/17.
 */

/**
 * Sweep Line Algorithm :
 * x-coordinates defines events.
 * horizontal segments (left endpoints) : insert y coordinate into BST
 * horizontal segments (right endpoints) : remove y coordinate from BST
 * vertical segments : range search for interval of y-endpoints.
 */
public class LineIntersection_SweepLineAlgorithm {

    static class Event {
        private Integer x_coordinate;
        private Line line;

        public Event(Integer x_coordinate, Line line) {
            this.x_coordinate = x_coordinate;
            this.line = line;
        }

        @Override
        public String toString() {
            return "Event{" +
                    "x_coordinate=" + x_coordinate +
                    ", line=" + line +
                    '}';
        }
    }

    public static void main(String[] args) {

        Line line1 = new Line(new Point(3,2), new Point(1,2));
        Line line2 = new Line(new Point(3,1), new Point(5,1));
        Line line3 = new Line(new Point(0,3), new Point(3,3));
        Line line4 = new Line(new Point(2,5), new Point(2,1));
        //Line line5 = new Line(new Point(4,0), new Point(4,7));
        //Line line6 = new Line(new Point(1,4), new Point(7,4));

        List<Line> lines = new ArrayList<>();
        lines.add(line1);
        lines.add(line2);
        lines.add(line3);
        lines.add(line4);
        //lines.add(line5);
        //lines.add(line6);

        findNumberOfIntersections(lines).forEach(System.out::println);

    }

    private static List<Point> findNumberOfIntersections(List<Line> lines) {

        List<Point> intersectingPoints = new ArrayList<>();

        //Event : all x coordinates are events for Sweep Line Algorithm
        List<Event> events = new ArrayList<>();

        for(Line line : lines) {
            if(horizontal(line)) { // if horizontal line, x coordinate is common, hence making single event
                events.add(new Event(line.getP1().getX_coordinate(), line));
            }
            events.add(new Event(line.getP2().getX_coordinate(), line));
        }
        //sorting events using the x coordinates
        events.sort(new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return o1.x_coordinate.compareTo(o2.x_coordinate);
            }
        });

        //Binary Search Tree to hold the y-coordinates of the horizontal lines currently cutting the vertical scanning line.
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        for(Event event : events) {
            if(horizontal(event.line)) {
                if(leftEndpoint(event.line, event.x_coordinate)) { // horizontal segments (left endpoints) : insert y coordinate into BST
                    binarySearchTree.putUsingRecursion(event.line.getP1().getY_coordinate(), null);
                } else {
                    binarySearchTree.delete(event.line.getP1().getY_coordinate()); // horizontal segments (right endpoints) : remove y coordinate from BST
                }
            } else { //vertical segments : range search for interval of y-endpoints
                if(event.line.getP1().getY_coordinate() < event.line.getP2().getY_coordinate()){
                    List<Integer> y_coordinates = binarySearchTree.rangeSearch(event.line.getP1().getY_coordinate(), event.line.getP2().getY_coordinate());
                    for(Integer y_coordinate : y_coordinates) {
                        intersectingPoints.add(new Point(event.x_coordinate, y_coordinate));
                    }
                } else {
                    List<Integer> y_coordinates = binarySearchTree.rangeSearch(event.line.getP2().getY_coordinate(), event.line.getP1().getY_coordinate());
                    for(Integer y_coordinate : y_coordinates) {
                        intersectingPoints.add(new Point(event.x_coordinate, y_coordinate));
                    }
                }
            }
        }
        return intersectingPoints;
    }

    private static boolean leftEndpoint(Line line, Integer x_coordinate) {
        return line.getP1().getX_coordinate() < line.getP2().getX_coordinate() ? line.getP1().getX_coordinate() == x_coordinate ? true : false : line.getP2().getX_coordinate() == x_coordinate ? true : false;
    }

    private static boolean horizontal(Line line) {
        return line.getP1().getY_coordinate() == line.getP2().getY_coordinate();
    }

}
