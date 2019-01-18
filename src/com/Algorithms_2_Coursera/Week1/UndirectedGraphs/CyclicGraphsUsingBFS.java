/*
package com.Algorithms_2_Coursera.Week1.UndirectedGraphs;

import edu.princeton.cs.algs4.Queue;

public class CyclicGraphsUsingBFS {

    boolean marked[];
    Queue queue;

    public CyclicGraphsUsingBFS(Graph G) {
        queue = new Queue();
        marked = new boolean[G.V()];
        hasCycle(G, 0);

    }

    private boolean hasCycle(Graph G, int v) {
        queue.enqueue(v);
        marked[v] = true;
        for(int w : G.adj(v)) {
            if(!marked[w]){}
        }
    }

    public static void main(String[] args) {
        Graph G = new Graph(10);
        new CyclicGraphsUsingBFS(G);
    }

}
*/
