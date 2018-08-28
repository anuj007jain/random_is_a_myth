package com.Algorithms_Coursera.Week5;

/**
 * Created by anuj.jain02 on 9/11/17.
 */
public class TwoDBSTNode {

    private Point point;
    private TwoDBSTNode left;
    private TwoDBSTNode right;
    private Boolean level;
    private Integer count;

    public TwoDBSTNode(Point point, Boolean level, Integer count) {
        this.point = point;
        this.level = level;
        this.count = count;
    }

    public Point getPoint() {
        return point;
    }

    public TwoDBSTNode setPoint(Point point) {
        this.point = point;
        return this;
    }

    public TwoDBSTNode getLeft() {
        return left;
    }

    public TwoDBSTNode setLeft(TwoDBSTNode left) {
        this.left = left;
        return this;
    }

    public TwoDBSTNode getRight() {
        return right;
    }

    public TwoDBSTNode setRight(TwoDBSTNode right) {
        this.right = right;
        return this;
    }

    public Boolean getLevel() {
        return level;
    }

    public TwoDBSTNode setLevel(Boolean level) {
        this.level = level;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public TwoDBSTNode setCount(Integer count) {
        this.count = count;
        return this;
    }
}
