package com.Algorithms_Coursera.Week5;

/**
 * Created by anuj.jain02 on 12/11/17.
 */
public class IntervalRangeSearch {

    public static void main(String[] args) {

        IntervalBinarySearchTree bst = new IntervalBinarySearchTree();
        bst.put(18,19);
        bst.put(5,8);
        bst.put(21,24);
        bst.put(4,8);
        bst.put(15,22);
        bst.put(3,10);
        bst.put(17,22);
        bst.put(16,19);
        bst.put(9,32);

        bst.delete(5,8);
        System.out.println(bst.singleIntervalRangedSearch(23,25));
        System.out.println(bst.singleIntervalRangedSearch(21,23));
        System.out.println(bst.allIntervalRangedSearch(6,20));
    }
}
