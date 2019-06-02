package com.Algorithms_2_Coursera.Week2.ShortestPaths;

import com.Algorithms_2_Coursera.Week1.DirectedGraphs.TopologicalSort;

public class AcyclicShortestPaths {

    DirectedWeightedEdge edgeTo[];
    double distTo[];

    public AcyclicShortestPaths(DirectedWeightedGraph G) {
        edgeTo = new DirectedWeightedEdge[G.V()];
        distTo = new double[G.V()];
        for (int v = 0 ; v < G.V() ; v++) {
            distTo[v] = Double.POSITIVE_INFINITY;
        }
        TopologicalSort topologicalSort = new TopologicalSort(G);
        int s = topologicalSort.stack.peek();
        distTo[s] = 0;
        while (!topologicalSort.stack.empty()) {
            int v = topologicalSort.stack.pop();
            for (DirectedWeightedEdge e : G.adj(v)) {
                relax(e);
            }
        }
    }

    private void relax(DirectedWeightedEdge e) {
        int v = e.from();
        int w = e.to();
        if(distTo[w] > distTo[v] + e.weight()) {
            distTo[w] = distTo[v] + e.weight();
            edgeTo[w] = e;
        }
    }

    public static void main(String[] args) {
        DirectedWeightedGraph G = new DirectedWeightedGraph(8);
        G.addEdge(new DirectedWeightedEdge(0, 1, 5.0));
        G.addEdge(new DirectedWeightedEdge(0, 4, 9.0));
        G.addEdge(new DirectedWeightedEdge(0, 7, 8.0));
        G.addEdge(new DirectedWeightedEdge(1, 2, 12.0));
        G.addEdge(new DirectedWeightedEdge(1, 3, 15.0));
        G.addEdge(new DirectedWeightedEdge(1, 7, 4.0));
        G.addEdge(new DirectedWeightedEdge(2, 3, 3.0));
        G.addEdge(new DirectedWeightedEdge(2, 6, 11.0));
        G.addEdge(new DirectedWeightedEdge(3, 6, 9.0));
        G.addEdge(new DirectedWeightedEdge(4, 5, 4.0));
        G.addEdge(new DirectedWeightedEdge(4, 6, 20.0));
        G.addEdge(new DirectedWeightedEdge(4, 7, 5.0));
        G.addEdge(new DirectedWeightedEdge(5, 2, 1.0));
        G.addEdge(new DirectedWeightedEdge(5, 6, 13.0));
        G.addEdge(new DirectedWeightedEdge(7, 2, 7.0));
        G.addEdge(new DirectedWeightedEdge(7, 5, 6.0));
        AcyclicShortestPaths acp = new AcyclicShortestPaths(G);
        int x = 5;
    }

}
