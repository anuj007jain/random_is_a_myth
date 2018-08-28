package com.Algorithms_Coursera.Week3.MergeSort;

import java.util.*;

/**
 * Created by anuj.jain02 on 30/3/17.
 */
public class FastCollinearPoints {

    private final LineSegment[] segments;
    private final int numberOfSegments;

    private final Map<Double, ArrayList<ArrayList<Point>>> slopeToPoints = new HashMap<>();
    private Point[] copy;

    public FastCollinearPoints(Point[] points){

        ArrayList<LineSegment> foundSegments = new ArrayList<>();
        numberOfSegments = 0;

        copy = new Point[points.length];
        for(int i = 0 ; i < points.length ; i++){
            copy[i] = points[i];
        }

        Arrays.sort(points);

        for(int i = 0 ; i < points.length ; i++){
            Point p = points[i];
            Arrays.sort(copy,p.slopeOrder());
            int start = 1;
            int count = 0;
            for(int j = 2 ; j < copy.length ; j++){
                /*if(copy[j-1].slopeTo(p) == copy[j].slopeTo(p) && copy[j].slopeTo(p) == copy[j+1].slopeTo(p) && !existed(copy[j+1].slopeTo(p),p)){
                    foundSegments.add(new LineSegment(p, compare(copy[j-1],copy[j],copy[j+1])));
                    addToMap(copy[j+1].slopeTo(p),p,copy[j-1],copy[j],copy[j+1]);
                    j+=3;
                }*/
                if(p.slopeTo(copy[start]) == p.slopeTo(copy[j])){
                    count++;
                }
                else{
                    if(count >= 2 && !existed(copy[start].slopeTo(copy[start+1]),p)){
                        foundSegments.add(new LineSegment(p, compare(start,count)));
                        addToMap(copy[start].slopeTo(copy[start+1]),p,start,count);
                    }
                    count = 0;
                    start++;
                }
            }
        }
        segments = foundSegments.toArray(new LineSegment[foundSegments.size()]);
    }

    private void addToMap(double slope, Point p, int start, int count) {
        if (slopeToPoints.get(slope) == null){
            slopeToPoints.put(slope, new ArrayList<ArrayList<Point>>());
        }
        ArrayList<Point> temp = new ArrayList();
        temp.add(p);
        for(int i = 0; i <= count ; i++){
            temp.add(copy[start+i]);
        }
        slopeToPoints.get(slope).add(temp);
    }

    private boolean existed(double slope, Point p) {
        if(slopeToPoints.containsKey(slope)){
            for(ArrayList<Point> pointsArray : slopeToPoints.get(slope)){
                if (pointsArray.contains(p)){
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    private Point compare(int start, int count) {

        Point max = copy[start];
        for(int i = 1; i <= count ; i++){
            if(copy[start+i].compareTo(max) > 0){
                max = copy[start+i];
            }
        }
        return max;
    }

    public int numberOfSegments(){
        return numberOfSegments;
    }

    public LineSegment[] segments(){
        return segments;
    }

    public static void main(String[] args) {
        Point[] points = {
                new Point(10000,0),
                new Point(0,10000),
                new Point(3000,0),
                new Point(7000,3000),
                new Point(20000,0),
                new Point(7000,0),
                new Point(14000,0),
                new Point(6000,7000)
        };

        FastCollinearPoints fastCollinearPoints = new FastCollinearPoints(points);
    }

}
