package com.Algorithms_2_Coursera.Week1.DirectedGraphs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by anuj.jain02 on 18/2/18.
 */
public class DirectedBFS {

    private boolean[] marked;
    private int[] edgeTo;
    private int[] distanceFromSource;
    private final int V;

    public DirectedBFS(Digraph G, int s) {
        this.V = G.V();
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        distanceFromSource = new int[G.V()];
        bfs(G,s);
    }

    private void bfs(Digraph G, int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        marked[s] = true;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for(int w : G.adj(v)) {
                if(!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    distanceFromSource[w] = distanceFromSource[v] + 1;
                    queue.add(w);
                }
            }
        }
    }

    public static void main(String[] args) {
        Digraph G = new Digraph(6);
        G.addEdge(0,2);
        G.addEdge(0,1);
        G.addEdge(1,2);
        G.addEdge(2,4);
        G.addEdge(4,3);
        G.addEdge(3,2);
        G.addEdge(3,5);
        G.addEdge(5,0);
        DirectedBFS bfs = new DirectedBFS(G, 0);
        int x = 0;

    }

}
