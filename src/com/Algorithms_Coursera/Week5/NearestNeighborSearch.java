package com.Algorithms_Coursera.Week5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anuj.jain02 on 9/11/17.
 */

/**
 * Goal: Find closest point to query point.
 * Algorithm:
 ・Check distance from point in node to query point.
 ・Recursively search left/bottom (if it could contain a closer point).
 ・Recursively search right/top (if it could contain a closer point).
 ・Organize method so that it begins by searching for query point.
 */
public class NearestNeighborSearch {

    private static Point nearestNeighborSearch(List<Point> points, Point queryPoint) {
        TwoDBinarySearchTree binarySearchTree = new TwoDBinarySearchTree();
        points.forEach(binarySearchTree::put);
        return findNearestNeighbor(binarySearchTree.root, queryPoint);

    }

    private static Point findNearestNeighbor(TwoDBSTNode node, Point queryPoint) {

        if(node.getLevel()) {
            int cmp = node.getPoint().getX_coordinate().compareTo(queryPoint.getX_coordinate());
            if(cmp >= 0) {
                if(node.getLeft() != null) {
                    Point nearestNeighborInLeftSubTree = findNearestNeighbor(node.getLeft(), queryPoint);
                    if (closer(queryPoint, new Point(node.getPoint().getX_coordinate(), queryPoint.getY_coordinate()), nearestNeighborInLeftSubTree) && node.getRight() != null) {
                        Point nearestNeighborInRightSubTree = findNearestNeighbor(node.getRight(), queryPoint);
                        Point closerPoint = closer(queryPoint, nearestNeighborInLeftSubTree, nearestNeighborInRightSubTree) ?
                                nearestNeighborInLeftSubTree : nearestNeighborInRightSubTree; // find the closer point between the best point in left and right subtrees
                        return closer(queryPoint, node.getPoint(),closerPoint) ? node.getPoint() : closerPoint; // return the closer point between the best point till now and the node point
                    }
                    return nearestNeighborInLeftSubTree;
                }
            }
            else {
                if(node.getRight() != null) {
                    Point nearestNeighborInRightSubTree = findNearestNeighbor(node.getRight(), queryPoint);
                    if (closer(queryPoint, new Point(node.getPoint().getX_coordinate(), queryPoint.getY_coordinate()), nearestNeighborInRightSubTree) && node.getLeft() != null) {
                        Point nearestNeighborInLeftSubTree = findNearestNeighbor(node.getLeft(), queryPoint);
                        Point closerPoint = closer(queryPoint, nearestNeighborInRightSubTree, nearestNeighborInLeftSubTree) ?
                                nearestNeighborInRightSubTree : nearestNeighborInLeftSubTree;
                        return closer(queryPoint, node.getPoint(),closerPoint) ? node.getPoint() : closerPoint;
                    }
                    return nearestNeighborInRightSubTree;
                }
            }
        }
        else {
            int cmp = node.getPoint().getY_coordinate().compareTo(queryPoint.getY_coordinate());
            if(cmp >= 0) {
                if(node.getLeft() != null) {
                    Point nearestNeighborInLeftSubTree = findNearestNeighbor(node.getLeft(), queryPoint);
                    if (closer(queryPoint, new Point(queryPoint.getX_coordinate(), node.getPoint().getY_coordinate()), nearestNeighborInLeftSubTree) && node.getRight() != null) {
                        Point nearestNeighborInRightSubTree = findNearestNeighbor(node.getRight(), queryPoint);
                        Point closerPoint = closer(queryPoint, nearestNeighborInLeftSubTree, nearestNeighborInRightSubTree) ?
                                nearestNeighborInLeftSubTree : nearestNeighborInRightSubTree;
                        return closer(queryPoint, node.getPoint(),closerPoint) ? node.getPoint() : closerPoint;
                    }
                    return nearestNeighborInLeftSubTree;
                }
            }
            else {
                if(node.getRight() != null) {
                    Point nearestNeighborInRightSubTree = findNearestNeighbor(node.getRight(), queryPoint);
                    if (closer(queryPoint, new Point(queryPoint.getX_coordinate(), node.getPoint().getY_coordinate()), nearestNeighborInRightSubTree) && node.getLeft() != null) {
                        Point nearestNeighborInLeftSubTree = findNearestNeighbor(node.getLeft(), queryPoint);
                        Point closerPoint = closer(queryPoint, nearestNeighborInRightSubTree, nearestNeighborInLeftSubTree) ?
                                nearestNeighborInRightSubTree : nearestNeighborInLeftSubTree;
                        return closer(queryPoint, node.getPoint(),closerPoint) ? node.getPoint() : closerPoint;
                    }
                    return nearestNeighborInRightSubTree;
                }
            }
        }
        return node.getPoint();
    }

    private static boolean closer(Point queryPoint, Point contendingPoint1, Point contendingPoint2) {
        double distance1 = Math.sqrt(Math.pow(contendingPoint1.getX_coordinate() - queryPoint.getX_coordinate(), 2) +
                Math.pow(contendingPoint1.getY_coordinate() - queryPoint.getY_coordinate(), 2));
        double distance2 = Math.sqrt(Math.pow(contendingPoint2.getX_coordinate() - queryPoint.getX_coordinate(), 2) +
                Math.pow(contendingPoint2.getY_coordinate() - queryPoint.getY_coordinate(), 2));
        return distance1 < distance2;
    }

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(5,5)); //1
        points.add(new Point(8,4)); //2
        points.add(new Point(3,7)); //3
        points.add(new Point(2,1)); //4
        points.add(new Point(1,6)); //5
        points.add(new Point(4,8)); //6
        points.add(new Point(6,3)); //7
        points.add(new Point(10,10)); //8
        points.add(new Point(9,9)); //9
        points.add(new Point(7,2)); //10
        System.out.println(nearestNeighborSearch(points, new Point(11,3)));
    }

}
