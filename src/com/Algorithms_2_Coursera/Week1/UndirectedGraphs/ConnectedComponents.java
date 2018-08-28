package com.Algorithms_2_Coursera.Week1.UndirectedGraphs;

/**
 * Created by anuj.jain02 on 17/2/18.
 */
public class ConnectedComponents {

    private boolean[] marked;
    private int[] id;
    private int count;

    public ConnectedComponents (Graph G) {

        marked = new boolean[G.V()];
        id = new int[G.V()];
        count = 0;

        for(int v = 0 ; v < G.V() ; v++) {
            if(!marked[v]) {
                dfs(G, v);
                count++;
            }
        }

    }

    private void dfs(Graph G, int v) {
        marked[v] = true;
        id[v] = count;
        for(int w : G.adj(v)) {
            if(!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public int count() {
        return count;
    }

    public int id(int v) {
        return id[v];
    }

    public static void main(String[] args) {
        Graph G = new Graph(13);
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
        ConnectedComponents cc = new ConnectedComponents(G);
        int x = 9;
    }

}
