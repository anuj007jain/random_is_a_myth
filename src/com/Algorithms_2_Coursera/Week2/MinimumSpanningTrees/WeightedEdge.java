package com.Algorithms_2_Coursera.Week2.MinimumSpanningTrees;

/**
 * Created by anuj.jain02 on 8/3/18.
 */
public class WeightedEdge implements Comparable<WeightedEdge>{

    private final int v;
    private final int w;
    private final double weight;

    public WeightedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    public int either() {
        return v;
    }

    int other(int v) {
        return this.v == v ? w : this.v;
    }

    @Override
    public int compareTo(WeightedEdge that) {
        if(weight < that.weight) {
            return -1;
        }
        if(weight > that.weight) {
            return +1;
        }
        return 0;
    }

    public double weight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeightedEdge edge = (WeightedEdge) o;

        if (v != edge.v) return false;
        if (w != edge.w) return false;
        return Double.compare(edge.weight, weight) == 0;

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
    public String
    toString() {
        return "WeightedEdge{" +
                "v=" + v +
                ", w=" + w +
                ", weight=" + weight +
                '}';
    }
}
