package com.Algorithms_Coursera.Week3.MergeSort;
import edu.princeton.cs.algs4.Insertion;

import java.util.ArrayList;

/**
 * Created by anuj.jain02 on 30/3/17.
 */
public class BruteCollinearPoints {

    private final LineSegment[] segments;
    private final int numberOfSegments;


    public BruteCollinearPoints(final Point[] points){

        checkDuplicatedEntries(points);

        Insertion.sort(points);

        ArrayList<LineSegment> foundSegments = new ArrayList<>();
        numberOfSegments = 0;

        for(int i = 0 ; i < points.length ; i++){
            for(int j = i+1 ; j < points.length ; j++){
                for(int k = j+1 ; k < points.length ; k++){
                    for(int l = k+1 ; l < points.length ; l++){
                        if(points[i].slopeTo(points[j]) == points[i].slopeTo(points[k]) &&  points[i].slopeTo(points[j]) == points[i].slopeTo(points[l])){
                            foundSegments.add(new LineSegment(points[i], points[l]));
                        }
                    }
                }
            }
        }
        segments = foundSegments.toArray(new LineSegment[foundSegments.size()]);
    }

    public int numberOfSegments(){
        return numberOfSegments;
    }

    public LineSegment[] segments(){
        return segments;
    }

    private void checkDuplicatedEntries(Point[] points) {
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                if (points[i].compareTo(points[j]) == 0) {
                    throw new IllegalArgumentException("Duplicated entries in given points.");
                }
            }
        }
    }

    public static void main(String[] args) {
        Point[] points = {
                new Point(10000,0),
                new Point(0,10000),
                new Point(3000,7000),
                new Point(7000,3000),
                new Point(20000,21000),
                new Point(3000,4000),
                new Point(14000,15000),
                new Point(6000,7000)
        };

        BruteCollinearPoints bruteCollinearPoints = new BruteCollinearPoints(points);
    }

}