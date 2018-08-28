package com.Algorithms_2_Coursera.Week1.UndirectedGraphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by anuj.jain02 on 17/2/18.
 */
public class BreadthFirstPaths {

    private int[] edgeTo;
    private int[] distanceFromSource;
    private boolean[] marked;
    private static int s;

    public BreadthFirstPaths(Graph G, int s) {
        edgeTo = new int[G.V()];
        distanceFromSource = new int[G.V()];
        marked = new boolean[G.V()];
        bfs(G, s);
    }

    private void bfs(Graph G, int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        marked[s] = true;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for(int w : G.adj(v)) {
                if(!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    distanceFromSource[w] = distanceFromSource[v]+1;
                    queue.add(w);
                }
            }
        }
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

    private boolean hasPathTo(int v) {
        return marked[v];
    }

    public static void main(String[] args) {
        Graph G = new Graph(6);
        s = 0;
        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(0,5);
        G.addEdge(2,3);
        G.addEdge(2,1);
        G.addEdge(5,3);
        G.addEdge(4,3);
        G.addEdge(4,2);
        BreadthFirstPaths bfp = new BreadthFirstPaths(G, s);
        for(Integer i : bfp.pathTo(3)) {
            System.out.print(i+"->");
        }
    }

}
