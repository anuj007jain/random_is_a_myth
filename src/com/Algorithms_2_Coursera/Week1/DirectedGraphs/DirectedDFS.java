package com.Algorithms_2_Coursera.Week1.DirectedGraphs;

import com.Algorithms_2_Coursera.Week1.UndirectedGraphs.Graph;

/**
 * Created by anuj.jain02 on 18/2/18.
 */
public class DirectedDFS {

    private boolean[] marked;
    private int[] edgeTo;
    private final int s;

    public DirectedDFS(Digraph G, int s) {
        this.s = s;
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G, s);
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if(!marked[w]) {
                dfs(G, w);
                edgeTo[w] = v;
            }
        }
    }

}
