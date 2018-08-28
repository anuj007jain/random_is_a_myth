package com.Algorithms_2_Coursera.Week1.UndirectedGraphs;

import java.util.Iterator;
import java.util.Stack;

/**
 * Created by anuj.jain02 on 15/2/18.
 */

/**
 * Depth First Search :
 * Data Structures :
 *  1. boolean[] marked to mark visited vertices
 *  2. int[] edgeTo to keep tree of paths
 *      edgeTo[w] =  v means that edge v-w taken to visit w the first time
 */
public class DepthFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private static int s;

    public DepthFirstPaths(Graph G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        dfs(G, s);
    }

    public boolean hasPathTo(int v) {
        return marked[v];
    }

    public Iterable<Integer> pathTo(int v) {
        if(!hasPathTo(v)) {
            return null;
        }
        Stack<Integer> stack = new Stack<>();
        stack.push(v);
        while (edgeTo[v] != s) {
            stack.push(edgeTo[v]);
            v = edgeTo[v];
        }
        stack.push(edgeTo[v]);
        return stack;
    }

    private void dfs(Graph G, int v) {
        for(int w : G.adj(v)) {
            if(!marked[w]) {
                marked[w] = true;
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public static void main(String[] args) {
        Graph G = new Graph(13);
        s = 0;
        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(0,6);
        G.addEdge(0,5);
        G.addEdge(5,3);
        G.addEdge(4,3);
        G.addEdge(4,5);
        G.addEdge(7,8);
        G.addEdge(9,10);
        G.addEdge(12,9);
        G.addEdge(12,11);
        G.addEdge(11,9);
        DepthFirstPaths dfp = new DepthFirstPaths(G, s);
        Iterator<Integer> iterator = dfp.pathTo(3).iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+"->");
        }
    }

}
