package com.Algorithms_2_Coursera.Week2.ShortestPaths;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BellmanFord {

    private int[] pathFrom;
    private double[] pathLen;
    private boolean negativeCyclePresent;
    private Stack<Integer> negativeCycle;

    public boolean isNegativeCyclePresent() {
        return negativeCyclePresent;
    }

    public Iterable<Integer> getNegativeCycle() {
        return negativeCycle;
    }

    public BellmanFord(DirectedWeightedGraph G) {

        negativeCyclePresent = false;
        pathFrom = new int[G.V()];
        pathLen = new double[G.V()];
        negativeCycle = new Stack<>();

        for (int i = 1 ; i < G.V() ; i++) {
            pathLen[i] = Double.POSITIVE_INFINITY;
        }

        boolean[] updatedVerticesInPrevPass = new boolean[G.V()];
        for (int pass = 0 ; pass < G.V() ; pass++) {
            boolean[] updatedVerticesInThisPass = new boolean[G.V()];
            if (pass == 0) {
                for (int v = 0 ; v < G.V() ; v++) {
                    updatedVerticesInPrevPass[v] = true;
                }
            }
            boolean anyVertexUpdated = false;
            for (int v = 0 ; v < G.V() ; v++) {
                if (updatedVerticesInPrevPass[v]) {
                    anyVertexUpdated = true;
                    break;
                }
            }
            if (!anyVertexUpdated) {
                break;
            }
            //System.out.println(pass);
            for (int v = 0 ; v < G.V() ; v++) {
                if (!updatedVerticesInPrevPass[v]) {
                    continue;
                }
                for (DirectedWeightedEdge edge : G.adj(v)) {
                    if (relaxEdge(edge)) {
                        updatedVerticesInThisPass[edge.to()] = true;
                    }
                }
            }
            if (pass == G.V() - 1 && anyVertexUpdated) {
                boolean negativeCycleFound = false;
                negativeCyclePresent = true;
                for (int v = 0 ; v < G.V() && !negativeCycleFound; v++) {
                    int w = pathFrom[v];
                    Set<Integer> set = new HashSet<>();
                    while (w != 0) {
                        if (set.contains(w)) {
                            negativeCycle.add(w);
                            int k = pathFrom[w];
                            while (k != w) {
                                negativeCycle.add(k);
                                k = pathFrom[k];
                            }
                            negativeCycleFound = true;
                            break;
                        } else {
                            set.add(w);
                            w = pathFrom[w];
                        }
                    }
                }
            }
            updatedVerticesInPrevPass = updatedVerticesInThisPass;
        }
    }

    private boolean relaxEdge(DirectedWeightedEdge edge) {
        int from = edge.from();
        int to = edge.to();
        double weight = edge.weight();
        if (pathLen[to] > pathLen[from] + weight) {
            pathLen[to] = pathLen[from] + weight;
            pathFrom[to] = from;
            return true;
        }
        return false;
    }

    private void printPathLen() {
        System.out.println("Shortest Path Lengths: ");
        for (int v = 0 ; v < pathLen.length ; v++) {
            System.out.println(v + ": "+pathLen[v]);
        }
    }

    private void printPaths() {
        System.out.println();
        System.out.println("Shortest Paths: ");
        for (int v = 0 ; v < pathLen.length ; v++) {
            Stack<Integer> verticesInPath = new Stack<>();
            verticesInPath.push(v);
            int w = pathFrom[v];
            while (w != 0) {
                verticesInPath.push(w);
                w = pathFrom[w];
            }
            verticesInPath.push(0);
            while (!verticesInPath.empty()) {
                if (verticesInPath.size() != 1) {
                    System.out.print(verticesInPath.pop() + "->");
                } else {
                    System.out.print(verticesInPath.pop());
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        DirectedWeightedGraph G1 = new DirectedWeightedGraph(8);
        G1.addEdge(new DirectedWeightedEdge(0, 1, 5.0));
        G1.addEdge(new DirectedWeightedEdge(0, 4, 9.0));
        G1.addEdge(new DirectedWeightedEdge(0, 7, 8.0));
        G1.addEdge(new DirectedWeightedEdge(1, 2, 12.0));
        G1.addEdge(new DirectedWeightedEdge(1, 3, 15.0));
        G1.addEdge(new DirectedWeightedEdge(1, 7, 4.0));
        G1.addEdge(new DirectedWeightedEdge(2, 3, 3.0));
        G1.addEdge(new DirectedWeightedEdge(2, 6, 11.0));
        G1.addEdge(new DirectedWeightedEdge(3, 6, 9.0));
        G1.addEdge(new DirectedWeightedEdge(4, 5, 4.0));
        G1.addEdge(new DirectedWeightedEdge(4, 6, 20.0));
        G1.addEdge(new DirectedWeightedEdge(4, 7, 5.0));
        G1.addEdge(new DirectedWeightedEdge(5, 2, 1.0));
        G1.addEdge(new DirectedWeightedEdge(5, 6, 13.0));
        G1.addEdge(new DirectedWeightedEdge(7, 5, 6.0));
        G1.addEdge(new DirectedWeightedEdge(7, 2, 7.0));

        BellmanFord bf = new BellmanFord(G1);
        bf.printPathLen();
        bf.printPaths();
        System.out.println(bf.isNegativeCyclePresent());
        System.out.println(bf.getNegativeCycle());
    }

}
