package com.Algorithms_2_Coursera.Week1.DirectedGraphs;

import com.Algorithms_2_Coursera.Week1.UndirectedGraphs.Graph;
import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

/**
 * Created by anuj.jain02 on 18/2/18.
 */
public class Digraph {

    private Bag<Integer>[] adj;
    private final int V;

    public Digraph(int V) {
        this.V = V;
        adj = (Bag<Integer>[]) new Bag[V];
        for(int v = 0 ; v < V ; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public Digraph(In in, int v) {
        V = v;
    }

    public int V() {
        return V;
    }

    public int E() {
        int E = 0;
        for(int v = 0 ; v < V ; v++) {
            E += adj[v].size();
        }
        return E;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
    }

    public Iterable<Integer> adj(int v) {
        return adj[v];
    }

    public Digraph reverse() {
        Digraph reverse = new Digraph(V);
        for(int v = 0 ; v < V ; v++) {
            for(int w : adj(v)) {
                reverse.addEdge(w, v);
            }
        }
        return reverse;
    }

}
