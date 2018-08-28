package com.Algorithms_2_Coursera.Week2.ShortestPaths;

/**
 * Created by anuj.jain02 on 20/6/18.
 */
public class DirectedWeightedEdge implements Comparable {

    private final int v;
    private final int w;
    private double weight;

    public DirectedWeightedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int from() {
        return v;
    }

    public int to() {
        return w;
    }

    public double weight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DirectedWeightedEdge that = (DirectedWeightedEdge) o;

        if (v != that.v) return false;
        if (w != that.w) return false;
        return Double.compare(that.weight, weight) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = v;
        result = 31 * result + w;
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "DirectedWeightedEdge{" +
                "v=" + v +
                ", w=" + w +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        DirectedWeightedEdge that = (DirectedWeightedEdge) o;
        if(this.weight() < that.weight()) return -1;
        if(this.weight() > that.weight()) return +1;
        return 0;
    }
}
