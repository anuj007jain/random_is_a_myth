package com.Algorithms_2_Coursera.Week1.DirectedGraphs;

import com.Algorithms_2_Coursera.Week2.ShortestPaths.DirectedWeightedEdge;
import com.Algorithms_2_Coursera.Week2.ShortestPaths.DirectedWeightedGraph;

import java.util.Stack;

/**
 * Created by anuj.jain02 on 18/2/18.
 */

public class TopologicalSort {

    boolean[] marked;
    public Stack<Integer> stack = new Stack<>();

    public TopologicalSort(Digraph G) {
        marked = new boolean[G.V()];
        for(int v = 0 ; v < G.V() ; v++) {
            if(!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        for(int w : G.adj(v)) {
            if(!marked[w]) {
                dfs(G, w);
            }
        }
        //System.out.println(v);
        stack.push(v); // the vertex has been completely visited and hence can be pushed on to stack
    }

    public TopologicalSort(DirectedWeightedGraph G) {
        marked = new boolean[G.V()];
        for (int v = 0 ; v < G.V() ; v++) {
            if(!marked[v]) {
                visit(G, v);
            }
        }
    }

    private void visit(DirectedWeightedGraph G, int v) {
        marked[v] = true;
        for (DirectedWeightedEdge e: G.adj(v)) {
            int w = e.to();
            if(!marked[w]) {
                visit(G, w);
            }
        }
        stack.push(v);
    }

    public Iterable<Integer> order() {
        return stack;
    }

    public static void main(String[] args) {
        Digraph G = new Digraph(7);
        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(0,5);
        G.addEdge(1,4);
        G.addEdge(3,2);
        G.addEdge(3,4);
        G.addEdge(3,5);
        G.addEdge(3,6);
        G.addEdge(5,2);
        G.addEdge(6,0);
        TopologicalSort sort = new TopologicalSort(G);

        for (int v : sort.order()) {
            System.out.print(v+" ");
        }

        //weights don't matter for topological sorting
        DirectedWeightedGraph G2 = new DirectedWeightedGraph(7);
        G2.addEdge(new DirectedWeightedEdge(0, 1, 0));
        G2.addEdge(new DirectedWeightedEdge(0, 2, 0));
        G2.addEdge(new DirectedWeightedEdge(0, 5, 0));
        G2.addEdge(new DirectedWeightedEdge(1, 4, 0));
        G2.addEdge(new DirectedWeightedEdge(3, 2, 0));
        G2.addEdge(new DirectedWeightedEdge(3, 4, 0));
        G2.addEdge(new DirectedWeightedEdge(3, 5, 0));
        G2.addEdge(new DirectedWeightedEdge(3, 6, 0));
        G2.addEdge(new DirectedWeightedEdge(5, 2, 0));
        G2.addEdge(new DirectedWeightedEdge(6, 0, 0));

        System.out.println();

        sort = new TopologicalSort(G2);

        for (int v : sort.order()) {
            System.out.print(v+" ");
        }
    }
}
