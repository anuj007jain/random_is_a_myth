package com.Algorithms_Coursera.Week5;

/**
 * Created by anuj.jain02 on 9/11/17.
 */
public class Line {
    private Point p1;
    private Point p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getP1() {
        return p1;
    }

    public Line setP1(Point p1) {
        this.p1 = p1;
        return this;
    }

    public Point getP2() {
        return p2;
    }

    public Line setP2(Point p2) {
        this.p2 = p2;
        return this;
    }

    @Override
    public String toString() {
        return "Line{" +
                "p1=" + p1 +
                ", p2=" + p2 +
                '}';
    }
}
