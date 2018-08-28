package com.Algorithms_Coursera.Week5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anuj.jain02 on 12/11/17.
 */
public class IntervalBinarySearchTree<Key extends Comparable<Key>> {

    IntervalBSTNode root = null;

    class IntervalBSTNode {

        private Key startPoint;
        private Key endPoint;
        private IntervalBSTNode left;
        private IntervalBSTNode right;
        private Key maxKeyInSubTree;

        public IntervalBSTNode(Key startPoint, Key endPoint, Key maxKeyInSubTree) {
            this.startPoint = startPoint;
            this.endPoint = endPoint;
            this.maxKeyInSubTree = maxKeyInSubTree;
        }

        public Key getStartPoint() {
            return startPoint;
        }

        public IntervalBSTNode setStartPoint(Key startPoint) {
            this.startPoint = startPoint;
            return this;
        }

        public Key getEndPoint() {
            return endPoint;
        }

        public IntervalBSTNode setEndPoint(Key endPoint) {
            this.endPoint = endPoint;
            return this;
        }

        @Override
        public String toString() {
            return "IntervalBSTNode{" +
                    "startPoint=" + startPoint +
                    ", endPoint=" + endPoint +
                    '}';
        }
    }

    public void put(Key startPoint, Key endPoint) {
        root = put(startPoint, endPoint, root);
    }

    private IntervalBSTNode put(Key startPoint, Key endPoint, IntervalBSTNode node) {

        if(node == null) {
            return new IntervalBSTNode(startPoint, endPoint, endPoint);
        }

        int cmp = startPoint.compareTo(node.startPoint);
        if(cmp < 0) {
            node.left = put(startPoint, endPoint, node.left);
        }
        else if (cmp > 0) {
            node.right = put(startPoint, endPoint, node.right);
        }
        else {
            throw new RuntimeException("Same starting points not allowed for now!");
        }
        node.maxKeyInSubTree = findMaxKeyInSubTree(node);
        return node;
    }

    public IntervalBSTNode singleIntervalRangedSearch(Key startPoint, Key endPoint) {
        return singleIntervalRangedSearch(startPoint, endPoint, root);
    }

    private IntervalBSTNode singleIntervalRangedSearch(Key startPoint, Key endPoint, IntervalBSTNode node) {

        if(node == null){
            return null;
        }

        if(intersecting(startPoint, endPoint, node)) {
            return node;
        }

        if(node.left != null && node.left.maxKeyInSubTree.compareTo(startPoint) > 0) {
            return singleIntervalRangedSearch(startPoint, endPoint, node.left);
        }
        else {
            return singleIntervalRangedSearch(startPoint, endPoint, node.right);
        }
    }

    public List<IntervalBSTNode> allIntervalRangedSearch(Key startPoint, Key endPoint) {
        List<IntervalBSTNode> allFoundIntervals = new ArrayList<>();
        allIntervalRangedSearch(startPoint, endPoint, root, allFoundIntervals);
        return allFoundIntervals;
    }

    private void allIntervalRangedSearch(Key startPoint, Key endPoint, IntervalBSTNode node, List<IntervalBSTNode> allFoundIntervals) {

        if(intersecting(startPoint, endPoint, node)) {
            allFoundIntervals.add(node);
        }

        if(node.left != null && node.left.maxKeyInSubTree.compareTo(startPoint) > 0) { // check left only if left node exists and
            // the max key in left subtree is greater than start point
            allIntervalRangedSearch(startPoint, endPoint, node.left, allFoundIntervals);
        }
        if(node.right != null && node.startPoint.compareTo(endPoint) < 0) { // check right only if right node exists and
            // the node's start point is less than the endpoint
            allIntervalRangedSearch(startPoint, endPoint, node.right, allFoundIntervals);
        }
    }

    public void delete(Key startPoint, Key endPoint) {
        root = delete(startPoint, endPoint, root);
    }

    private IntervalBSTNode delete(Key startPoint, Key endPoint, IntervalBSTNode node) {
        if(node == null) {
            return null;
        }
        int cmp = startPoint.compareTo(node.startPoint);
        if(cmp < 0) {
            node.left = delete(startPoint, endPoint, node.left);
        }
        else if (cmp > 0) {
            node.right = delete(startPoint, endPoint, node.right);
        }
        else {
            if (node.left == null) {
                return node.right;
            }
            if (node.right == null) {
                return node.left;
            }
            IntervalBSTNode T = min(node.right);
            T.right = deleteMin(node.right);
            T.left = node.left;
            node = T;

            node.maxKeyInSubTree = findMaxKeyInSubTree(node);
        }
        return node;
    }

    private Key findMaxKeyInSubTree(IntervalBSTNode node) {
        if (node.left != null && node.right != null) {
            Key maxKeyInChildren = node.left.maxKeyInSubTree.compareTo(node.right.maxKeyInSubTree) > 0 ?
                    node.left.maxKeyInSubTree : node.right.maxKeyInSubTree;
            return node.maxKeyInSubTree.compareTo(maxKeyInChildren) > 0 ?
                    node.maxKeyInSubTree : maxKeyInChildren;
        }
        else if (node.left != null) {
            return node.maxKeyInSubTree.compareTo(node.left.maxKeyInSubTree) > 0 ?
                    node.maxKeyInSubTree : node.left.maxKeyInSubTree;
        }
        else if (node.right != null) {
            return node.maxKeyInSubTree.compareTo(node.right.maxKeyInSubTree) > 0 ?
                    node.maxKeyInSubTree : node.right.maxKeyInSubTree;
        }
        return node.maxKeyInSubTree;
    }

    private IntervalBSTNode deleteMin(IntervalBSTNode node) {
        if (node.left == null) {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.maxKeyInSubTree = findMaxKeyInSubTree(node);
        return node;
    }

    private IntervalBSTNode min(IntervalBSTNode node) {
        if(node.left == null){
            return node;
        }
        return min(node.left);
    }

    private boolean intersecting(Key startPoint, Key endPoint, IntervalBSTNode node) {
        return startPoint.compareTo(node.startPoint) > 0 && startPoint.compareTo(node.endPoint) < 0 ||
               endPoint.compareTo(node.startPoint) > 0 && endPoint.compareTo(node.endPoint) < 0;
    }

}
