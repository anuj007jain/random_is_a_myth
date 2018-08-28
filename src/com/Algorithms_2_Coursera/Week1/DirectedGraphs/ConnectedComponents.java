package com.Algorithms_2_Coursera.Week1.DirectedGraphs;

import java.util.Stack;

/**
 * Created by anuj.jain02 on 26/2/18.
 */

/**
 *  Kosaraju-Sharir Algorithm : Finding strong components (all vertices can reach each other) in a Digraph
 *  Reverse graph : String components in G are same as in Gr (G reverse)
 *  Idea :
 *  1. Compute topological order (reverse postorder) in Gr (G reverse).
 *  2. Run DFS in G, visiting unmarked vertices in reverse postorder of Gr.
 */
public class ConnectedComponents {

    static boolean[] marked;
    static int[] id;
    static int count = 0;

    public ConnectedComponents(Digraph G) {

        marked = new boolean[G.V()];
        id = new int[G.V()];
        Digraph reverse = G.reverse();
        Stack<Integer> stack = new TopologicalSort(reverse).stack;
        while (!stack.empty()) {
            int v = stack.pop();
            if(!marked[v]) {
                dfs(G, v);
                count++;
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        id[v] = count;
        for(int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public static void main(String[] args) {

        Digraph G = new Digraph(13);
        G.addEdge(0,1);
        G.addEdge(0,5);
        G.addEdge(2,0);
        G.addEdge(2,3);
        G.addEdge(3,2);
        G.addEdge(3,5);
        G.addEdge(4,2);
        G.addEdge(4,3);
        G.addEdge(5,4);
        G.addEdge(6,0);
        G.addEdge(6,4);
        G.addEdge(6,8);
        G.addEdge(6,9);
        G.addEdge(7,6);
        G.addEdge(7,9);
        G.addEdge(8,6);
        G.addEdge(9,10);
        G.addEdge(9,11);
        G.addEdge(10,12);
        G.addEdge(11,4);
        G.addEdge(11,12);
        G.addEdge(12,9);
        ConnectedComponents cc = new ConnectedComponents(G);

    }

}
