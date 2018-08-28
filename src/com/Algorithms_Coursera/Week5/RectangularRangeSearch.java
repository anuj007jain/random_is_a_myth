package com.Algorithms_Coursera.Week5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anuj.jain02 on 9/11/17.
 */

/**
 * Goal : find all points in a query axis-aligned rectangle.
 * 1. Check if point in node lies in the given rectangle.
 * 2. Recursively search left / bottom (if any could fall in rectangle).
 * 3. Recursively search right / top (if any could fall in rectangle).
 */
public class RectangularRangeSearch {


    public static void rectangularRangedSearch(List<Point> points, Point diagPoint1, Point diagPoint2) {
        TwoDBinarySearchTree bst = new TwoDBinarySearchTree() ;
        points.forEach(bst::put);
        doRangedSearch(bst.root, diagPoint1, diagPoint2);
    }

    private static void doRangedSearch(TwoDBSTNode node, Point diagPoint1, Point diagPoint2) {

        if(node == null) {
            return;
        }
        if(node.getLevel()){
            Integer smaller_X_coordinate;
            Integer larger_X_coordinate;
            if(diagPoint1.getX_coordinate() <= diagPoint2.getX_coordinate()) {
                smaller_X_coordinate = diagPoint1.getX_coordinate();
                larger_X_coordinate = diagPoint2.getX_coordinate();
            } else {
                smaller_X_coordinate = diagPoint2.getX_coordinate();
                larger_X_coordinate = diagPoint1.getX_coordinate();
            }

            int cmp1 = node.getPoint().getX_coordinate().compareTo(smaller_X_coordinate);
            int cmp2 = node.getPoint().getX_coordinate().compareTo(larger_X_coordinate);

            if(cmp1 >= 0 && cmp2 <=0) {
                Integer smaller_Y_coordinate;
                Integer larger_Y_coordinate;
                if(diagPoint1.getY_coordinate() <= diagPoint2.getY_coordinate()) {
                    smaller_Y_coordinate = diagPoint1.getY_coordinate();
                    larger_Y_coordinate = diagPoint2.getY_coordinate();
                } else {
                    smaller_Y_coordinate = diagPoint2.getY_coordinate();
                    larger_Y_coordinate = diagPoint1.getY_coordinate();
                }

                int cmp3 = node.getPoint().getY_coordinate().compareTo(smaller_Y_coordinate);
                int cmp4 = node.getPoint().getY_coordinate().compareTo(larger_Y_coordinate);

                if (cmp3 >= 0 && cmp4 <= 0){
                    System.out.println(node.getPoint());
                }
                doRangedSearch(node.getLeft(), diagPoint1, diagPoint2);
                doRangedSearch(node.getRight(), diagPoint1, diagPoint2);
            }

            else if (cmp2 >= 0) {
                doRangedSearch(node.getLeft(), diagPoint1, diagPoint2);
            }

            else if (cmp1 <= 0) {
                doRangedSearch(node.getRight(), diagPoint1, diagPoint2);
            }
        }
        else {
            Integer smaller_Y_coordinate;
            Integer larger_Y_coordinate;
            if(diagPoint1.getY_coordinate() <= diagPoint2.getY_coordinate()) {
                smaller_Y_coordinate = diagPoint1.getY_coordinate();
                larger_Y_coordinate = diagPoint2.getY_coordinate();
            } else {
                smaller_Y_coordinate = diagPoint2.getY_coordinate();
                larger_Y_coordinate = diagPoint1.getY_coordinate();
            }

            int cmp1 = node.getPoint().getY_coordinate().compareTo(smaller_Y_coordinate);
            int cmp2 = node.getPoint().getY_coordinate().compareTo(larger_Y_coordinate);

            if(cmp1 >= 0 && cmp2 <=0) {
                Integer smaller_X_coordinate;
                Integer larger_X_coordinate;
                if(diagPoint1.getX_coordinate() <= diagPoint2.getX_coordinate()) {
                    smaller_X_coordinate = diagPoint1.getX_coordinate();
                    larger_X_coordinate = diagPoint2.getX_coordinate();
                } else {
                    smaller_X_coordinate = diagPoint2.getX_coordinate();
                    larger_X_coordinate = diagPoint1.getX_coordinate();
                }

                int cmp3 = node.getPoint().getX_coordinate().compareTo(smaller_X_coordinate);
                int cmp4 = node.getPoint().getX_coordinate().compareTo(larger_X_coordinate);

                if (cmp3 >= 0 && cmp4 <= 0){
                    System.out.println(node.getPoint());
                }
                doRangedSearch(node.getLeft(), diagPoint1, diagPoint2);
                doRangedSearch(node.getRight(), diagPoint1, diagPoint2);
            }

            else if (cmp2 >= 0) {
                doRangedSearch(node.getLeft(), diagPoint1, diagPoint2);
            }

            else if (cmp1 <= 0) {
                doRangedSearch(node.getRight(), diagPoint1, diagPoint2);
            }
        }
    }

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(3,2));
        points.add(new Point(4,7));
        points.add(new Point(4,2));
        points.add(new Point(8,9));
        points.add(new Point(3,4));
        rectangularRangedSearch(points, new Point(4,9), new Point(1,1));
    }



}
