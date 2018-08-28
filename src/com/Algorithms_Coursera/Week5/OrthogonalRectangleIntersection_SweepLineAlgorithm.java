package com.Algorithms_Coursera.Week5;

import java.util.*;

/**
 * Created by anuj.jain02 on 13/11/17.
 */
public class OrthogonalRectangleIntersection_SweepLineAlgorithm {

    static class IntersectingRectangles {
        private OrthogonalRectangle rectangle1;
        private OrthogonalRectangle rectangle2;

        public IntersectingRectangles(OrthogonalRectangle rectangle1, OrthogonalRectangle rectangle2) {
            this.rectangle1 = rectangle1;
            this.rectangle2 = rectangle2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            IntersectingRectangles that = (IntersectingRectangles) o;

            if (rectangle1 != null ? !rectangle1.equals(that.rectangle1) : that.rectangle1 != null) return false;
            return rectangle2 != null ? rectangle2.equals(that.rectangle2) : that.rectangle2 == null;

        }

        @Override
        public int hashCode() {
            int result = rectangle1 != null ? rectangle1.hashCode() : 0;
            result = 31 * result + (rectangle2 != null ? rectangle2.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return "IntersectingRectangles{" +
                    "rectangle1=" + rectangle1 +
                    ", rectangle2=" + rectangle2 +
                    '}';
        }
    }

    static class Event {
        private Integer x_coordinate;
        private OrthogonalRectangle rectangle;

        public Event(Integer x_coordinate, OrthogonalRectangle rectangle) {
            this.x_coordinate = x_coordinate;
            this.rectangle = rectangle;
        }
    }

    private Set<IntersectingRectangles> findOrthogonalRectangleIntersectionPoints(List<OrthogonalRectangle> rectangles) {

        Set<IntersectingRectangles> intersectingRectangles = new HashSet<>();
        IntervalBinarySearchTree bst = new IntervalBinarySearchTree();
        List<Event> events = new ArrayList<>();
        for (OrthogonalRectangle rectangle : rectangles) {
            events.add(new Event(rectangle.diagonalPoint1.getX_coordinate(), rectangle));
            events.add(new Event(rectangle.diagonalPoint2.getX_coordinate(), rectangle));
        }

        events.sort(new Comparator<Event>() {
            @Override
            public int compare(Event o1, Event o2) {
                return o1.x_coordinate.compareTo(o2.x_coordinate);
            }
        });
        for (Event event : events) {
            Integer smallerY_coordinate;
            Integer biggerY_coordinate;
            if(event.rectangle.diagonalPoint1.getY_coordinate() < event.rectangle.diagonalPoint2.getY_coordinate()){
                smallerY_coordinate = event.rectangle.diagonalPoint1.getY_coordinate();
                biggerY_coordinate = event.rectangle.diagonalPoint2.getY_coordinate();
            } else {
                smallerY_coordinate = event.rectangle.diagonalPoint2.getY_coordinate();
                biggerY_coordinate = event.rectangle.diagonalPoint1.getY_coordinate();
            }
            if (rectangleStarting(event.rectangle, event.x_coordinate)) {
                //find rectangles intersected by this rectangle
                List<IntervalBinarySearchTree.IntervalBSTNode> nodes = bst.allIntervalRangedSearch(smallerY_coordinate, biggerY_coordinate);
                for(IntervalBinarySearchTree.IntervalBSTNode node: nodes) {
                    intersectingRectangles.add(new IntersectingRectangles(event.rectangle, findRectangle(node.getStartPoint(), node.getEndPoint(), rectangles)));
                }
                //add this rectangle's y coordinate interval to bst
                bst.put(smallerY_coordinate, biggerY_coordinate);
            }
            else {
                bst.delete(smallerY_coordinate, biggerY_coordinate);
            }
        }
        return intersectingRectangles;
    }

    private OrthogonalRectangle findRectangle(Comparable startPoint, Comparable endPoint, List<OrthogonalRectangle> rectangles) {
        for(OrthogonalRectangle rectangle : rectangles) {
            if(rectangle.diagonalPoint1.getY_coordinate() == startPoint && rectangle.diagonalPoint2.getY_coordinate() == endPoint ||
                    rectangle.diagonalPoint1.getY_coordinate() == endPoint && rectangle.diagonalPoint2.getY_coordinate() == startPoint) {
                return rectangle;
            }
        }
        return null;
    }

    private boolean rectangleStarting(OrthogonalRectangle rectangle, Integer x_coordinate) {
        return x_coordinate == (rectangle.diagonalPoint1.getX_coordinate() < rectangle.diagonalPoint2.getX_coordinate() ?
                rectangle.diagonalPoint1.getX_coordinate() : rectangle.diagonalPoint2.getX_coordinate()) ? true : false;
    }


    public static void main(String[] args) {

        OrthogonalRectangleIntersection_SweepLineAlgorithm orisla = new OrthogonalRectangleIntersection_SweepLineAlgorithm();
        OrthogonalRectangle rectangle1 = new OrthogonalRectangle(new Point(1,1), new Point(3,3));
        OrthogonalRectangle rectangle2 = new OrthogonalRectangle(new Point(2,2), new Point(4,5));
        OrthogonalRectangle rectangle3 = new OrthogonalRectangle(new Point(0,0), new Point(6,6));
        OrthogonalRectangle rectangle4 = new OrthogonalRectangle(new Point(7,7), new Point(8,8));
        OrthogonalRectangle rectangle5 = new OrthogonalRectangle(new Point(-3,-2), new Point(-1,-1));
        List<OrthogonalRectangle> rectangles = new ArrayList<>();
        rectangles.add(rectangle1);
        rectangles.add(rectangle2);
        rectangles.add(rectangle3);
        rectangles.add(rectangle4);
        rectangles.add(rectangle5);
        orisla.findOrthogonalRectangleIntersectionPoints(rectangles).forEach(System.out::println);

    }

}
