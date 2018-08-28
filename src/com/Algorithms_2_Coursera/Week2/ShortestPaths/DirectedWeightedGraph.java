package com.Algorithms_2_Coursera.Week2.ShortestPaths;

import edu.princeton.cs.algs4.Bag;

/**
 * Created by anuj.jain02 on 20/6/18.
 */
public class DirectedWeightedGraph {

    private final int V;
    private Bag<DirectedWeightedEdge>[] adj;

    public DirectedWeightedGraph(int V) {
        this.V = V;
        adj = (Bag<DirectedWeightedEdge>[]) new Bag[V];
        for(int v = 0 ; v < V ; v++) {
            adj[v] = new Bag<>();
        }
    }

    public void addEdge(DirectedWeightedEdge edge) {
        int v = edge.from();
        adj[v].add(edge);
    }

    public Iterable<DirectedWeightedEdge> adj(int v) {
        return adj[v];
    }

    public int V(){
        return V;
    }

}
