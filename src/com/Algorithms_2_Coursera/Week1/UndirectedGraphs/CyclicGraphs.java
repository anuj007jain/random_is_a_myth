package com.Algorithms_2_Coursera.Week1.UndirectedGraphs;

/**
 * Created by anuj.jain02 on 18/2/18.
 */
public class CyclicGraphs {

    static boolean[] marked;
    static boolean cycle;
    static int[] edgeTo;

    public CyclicGraphs(Graph G) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        cycle = false;
        System.out.println(hasCycle(G));
    }

    public static boolean hasCycle(Graph G) {

        for(int v = 0 ; v < G.V() ; v++) {
            marked = new boolean[G.V()];
            checkCycleForVertex(G, v, v, 0);
        }
        return cycle;
    }

    private static void checkCycleForVertex(Graph G, int source, int v, int cycleLength) {

        if(cycle) return;

        if(source == v && cycleLength > 2) {
            while (edgeTo[source] != v) {
                System.out.print(source + "->");
                source = edgeTo[source];
            }
            System.out.println(source);
            System.out.println("Found cycle source: "+source+" length: "+cycleLength);
            cycle = true;
        }
        for(int w : G.adj(v)) {
                if(!marked[w]) {
                    marked[w] = true;
                    edgeTo[w] = v;
                    checkCycleForVertex(G, source, w, cycleLength+1);
                }
        }
    }

    public static void main(String[] args) {

        Graph G = new Graph(10);
        G.addEdge(0,1);
        G.addEdge(1,3);
        G.addEdge(0,2);
        G.addEdge(0,6);
        G.addEdge(0,5);
        G.addEdge(5,4);
        G.addEdge(5,8);
        G.addEdge(8,6);
        new CyclicGraphs(G);

    }

}
