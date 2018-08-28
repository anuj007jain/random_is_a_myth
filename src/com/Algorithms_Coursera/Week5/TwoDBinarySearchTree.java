package com.Algorithms_Coursera.Week5;

/**
 * Created by anuj.jain02 on 9/11/17.
 */
public class TwoDBinarySearchTree {

    TwoDBSTNode root = null;
    private static final boolean EVEN = true;

    public void put(Point point) {
        root = put(point, root, EVEN);
    }

    private TwoDBSTNode put(Point point, TwoDBSTNode node, Boolean level) {
        if(node == null){
            return new TwoDBSTNode(point, level, 1);
        }
        if(node.getLevel()){
            int cmp = point.getX_coordinate().compareTo(node.getPoint().getX_coordinate());
            if(cmp <= 0) {
                node.setLeft(put(point, node.getLeft(), !level));
            }
            else {
                node.setRight(put(point, node.getRight(), !level));
            }
        }
        else {
            int cmp = point.getY_coordinate().compareTo(node.getPoint().getY_coordinate());
            if(cmp <= 0) {
                node.setLeft(put(point, node.getLeft(), !level));
            }
            else {
                node.setRight(put(point, node.getRight(), !level));
            }
        }
        node.setCount(size(node.getLeft()) + size(node.getRight()) + 1);
        return node;
    }

    private int size (TwoDBSTNode node) {
        if(node == null) {
            return 0;
        }
        return node.getCount();
    }

}
