package com.Algorithms_Coursera.Week5;

/**
 * Created by anuj.jain02 on 9/11/17.
 */
public class Point {
    private Integer x_coordinate;
    private Integer y_coordinate;

    public Point(Integer x_coordinate, Integer y_coordinate) {
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
    }

    public Integer getX_coordinate() {
        return x_coordinate;
    }

    public Point setX_coordinate(Integer x_coordinate) {
        this.x_coordinate = x_coordinate;
        return this;
    }

    public Integer getY_coordinate() {
        return y_coordinate;
    }

    public Point setY_coordinate(Integer y_coordinate) {
        this.y_coordinate = y_coordinate;
        return this;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x_coordinate=" + x_coordinate +
                ", y_coordinate=" + y_coordinate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (x_coordinate != null ? !x_coordinate.equals(point.x_coordinate) : point.x_coordinate != null) return false;
        return y_coordinate != null ? y_coordinate.equals(point.y_coordinate) : point.y_coordinate == null;

    }

    @Override
    public int hashCode() {
        int result = x_coordinate != null ? x_coordinate.hashCode() : 0;
        result = 31 * result + (y_coordinate != null ? y_coordinate.hashCode() : 0);
        return result;
    }
}
