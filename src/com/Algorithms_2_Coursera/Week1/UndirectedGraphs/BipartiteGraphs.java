package com.Algorithms_2_Coursera.Week1.UndirectedGraphs;

/**
 * Created by anuj.jain02 on 18/2/18.
 */
public class BipartiteGraphs {

    static boolean[] marked;
    static boolean[] color;
    static boolean failure;

    private static boolean isBipartite(Graph G) {
        marked = new boolean[G.V()];
        color = new boolean[G.V()];
        failure = false;
        for(int v = 0 ; v < G.V() ; v++) {
            dfs(G, v);
        }
        return !failure;
    }

    private static void dfs(Graph G, int v) {
        for(int w : G.adj(v)) {
            if(!marked[w]) {
                marked[w] = true;
                color[w] = !color[v];
                dfs(G, w);
            } else {
                if(color[w] == color[v]) {
                    failure = true;
                }
            }
        }
    }

    public static void main(String[] args) {

        /*Graph G = new Graph(8);
        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(0,6);
        G.addEdge(0,5);
        G.addEdge(3,1);
        G.addEdge(3,2);
        G.addEdge(2,4);
        G.addEdge(4,5);
        G.addEdge(6,4);
        G.addEdge(0,7);
        G.addEdge(2,7);
        System.out.println(isBipartite(G));*/

        Graph G = new Graph(10);
        G.addEdge(2,1);
        G.addEdge(3,2);
        G.addEdge(2,8);
        G.addEdge(9,5);
        G.addEdge(3,4);
        G.addEdge(4,6);
        G.addEdge(8,9);
        G.addEdge(4,5);
        G.addEdge(2,4);
        G.addEdge(5,7);
        System.out.println(isBipartite(G));
    }

}
