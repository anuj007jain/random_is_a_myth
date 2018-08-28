package com.Algorithms_Coursera.Week5;

/**
 * Created by anuj.jain02 on 13/11/17.
 */
public class OrthogonalRectangle {

    Point diagonalPoint1;
    Point diagonalPoint2;

    public OrthogonalRectangle(Point diagonalPoint1, Point diagonalPoint2) {
        this.diagonalPoint1 = diagonalPoint1;
        this.diagonalPoint2 = diagonalPoint2;
    }

    @Override
    public String toString() {
        return "OrthogonalRectangle{" +
                "diagonalPoint1=" + diagonalPoint1 +
                ", diagonalPoint2=" + diagonalPoint2 +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrthogonalRectangle rectangle = (OrthogonalRectangle) o;

        if (diagonalPoint1 != null ? !diagonalPoint1.equals(rectangle.diagonalPoint1) : rectangle.diagonalPoint1 != null)
            return false;
        return diagonalPoint2 != null ? diagonalPoint2.equals(rectangle.diagonalPoint2) : rectangle.diagonalPoint2 == null;

    }

    @Override
    public int hashCode() {
        int result = diagonalPoint1 != null ? diagonalPoint1.hashCode() : 0;
        result = 31 * result + (diagonalPoint2 != null ? diagonalPoint2.hashCode() : 0);
        return result;
    }
}
