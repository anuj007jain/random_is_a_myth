package com.Algorithms_2_Coursera.Week2.MinimumSpanningTrees;

import edu.princeton.cs.algs4.Bag;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by anuj.jain02 on 8/3/18.
 */
public class WeightedEdgeGraph {

    private final int V;
    private final Bag<WeightedEdge>[] adj;

    public WeightedEdgeGraph(int V) {
        this.V = V;
        adj = (Bag<WeightedEdge>[]) new Bag[V];
        for(int i = 0 ; i < V ; i++) {
            adj[i] = new Bag<WeightedEdge>();
        }
    }

    public int V() {
        return V;
    }

    public void addEdge(WeightedEdge e) {
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }

    Iterable<WeightedEdge> adj(int v) {
        return adj[v];
    }

    Iterable<WeightedEdge> edges() {
        Set<WeightedEdge> edges = new HashSet<>();
        for(int v = 0 ; v < V ; v++) {
            for(WeightedEdge edge : this.adj(v)) {
                edges.add(edge);
            }
        }
        return edges;
    }

    public static void main(String[] args) {
        WeightedEdgeGraph graph = new WeightedEdgeGraph(3);
        graph.addEdge(new WeightedEdge(0,0,3.0));
        graph.addEdge(new WeightedEdge(0,0,3.0));
        graph.addEdge(new WeightedEdge(0,0,4.0));
        System.out.println(graph.edges());
    }
}
