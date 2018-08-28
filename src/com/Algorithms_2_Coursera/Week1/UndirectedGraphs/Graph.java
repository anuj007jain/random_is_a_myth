package com.Algorithms_2_Coursera.Week1.UndirectedGraphs;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

import java.util.Arrays;

/**
 * Created by anuj.jain02 on 14/2/18.
 */
public class Graph {

    private final int V;
    private Bag<Integer>[] adj;

    public Graph(int V) {
        this.V = V;
        adj = (Bag<Integer>[])new Bag[V];
        for (int v = 0 ; v < V ; v++) {
            adj[v] = new Bag<Integer>();
        }
    }

    public Graph(In in) {
        V = 0;
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
    }

    public Iterable<Integer> adj (int v) {
        return adj[v];
    }

    public int V() {
        return V;
    }

    public int E() {
        int E = 0;
        for(int v = 0 ; v < V ; v++) {
            E += adj[v].size();
        }
        return E/2;
    }

    @Override
    public String toString() {
        return "Graph{" +
                "V=" + V +
                ", adj=" + Arrays.toString(adj) +
                '}';
    }

    public static int degree(Graph G, int v) {
        int degree = 0;
        for(int w : G.adj(v)) {
            degree++;
        }
        return degree;
    }

    public static int maxDegree(Graph G) {
        int maxDegree = 0;
        for(int v = 0 ; v < G.V() ; v++) {
            int degree = degree(G, v);
            if(maxDegree < degree) {
                maxDegree = degree;
            }
        }
        return maxDegree;
    }

    public static double averageDegree(Graph G) {
        return 2.0 * G.E() / G.V();
    }

    public static int selfLoops(Graph G) {
        int selfLoops = 0;
        for(int v = 0 ; v < G.V() ; v++) {
            for(int w : G.adj(v)) {
                if(v == w) {
                    selfLoops++;
                }
            }
        }
        return selfLoops/2;
    }

    public static void main(String[] args) {
        In in = new In(args[0]);
        Graph G = new Graph(in);
        for(int v = 0 ; v < G.V() ; v++) {
            for(int w : G.adj(v)) {
                System.out.println(v+"-"+w);
            }
        }
    }
}
