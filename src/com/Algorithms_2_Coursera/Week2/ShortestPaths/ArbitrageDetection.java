package com.Algorithms_2_Coursera.Week2.ShortestPaths;

import java.util.HashMap;
import java.util.Map;

public class ArbitrageDetection {

    public ArbitrageDetection(DirectedWeightedGraph G) {

        convertToArbitrageGraph(G);
        BellmanFord bf = new BellmanFord(G);
        System.out.println(bf.isNegativeCyclePresent());
        System.out.println(bf.getNegativeCycle());
    }

    private void convertToArbitrageGraph(DirectedWeightedGraph G) {

        for (int v = 0 ; v < G.V() ; v++) {
            for (DirectedWeightedEdge edge : G.adj(v)) {
                edge.setWeight(-Math.log(edge.weight()));
            }
        }
    }

    public static void main(String[] args) {
        Map<Integer, String> vertexToCurrencyMap = new HashMap<>();
        vertexToCurrencyMap.put(0, "USD");
        vertexToCurrencyMap.put(1, "EUR");
        vertexToCurrencyMap.put(2, "GBP");
        vertexToCurrencyMap.put(3, "CHF");
        vertexToCurrencyMap.put(4, "CAD");

        DirectedWeightedGraph G = new DirectedWeightedGraph(5);
        //G.addEdge(new DirectedWeightedEdge(0, 0, 1));
        G.addEdge(new DirectedWeightedEdge(0, 1, 0.741));
        G.addEdge(new DirectedWeightedEdge(0, 2, 0.657));
        G.addEdge(new DirectedWeightedEdge(0, 3, 1.061));
        G.addEdge(new DirectedWeightedEdge(0, 4, 1.011));
        G.addEdge(new DirectedWeightedEdge(1, 0, 1.350));
        //G.addEdge(new DirectedWeightedEdge(1, 1, 0));
        G.addEdge(new DirectedWeightedEdge(1, 2, 0.888));
        G.addEdge(new DirectedWeightedEdge(1, 3, 1.433));
        G.addEdge(new DirectedWeightedEdge(1, 4, 1.366));
        G.addEdge(new DirectedWeightedEdge(2, 0, 1.521));
        G.addEdge(new DirectedWeightedEdge(2, 1, 1.126));
        //G.addEdge(new DirectedWeightedEdge(2, 2, 1));
        G.addEdge(new DirectedWeightedEdge(2, 3, 1.614));
        G.addEdge(new DirectedWeightedEdge(2, 4, 1.538));
        G.addEdge(new DirectedWeightedEdge(3, 0, 0.943));
        G.addEdge(new DirectedWeightedEdge(3, 1, 0.698));
        G.addEdge(new DirectedWeightedEdge(3, 2, 0.620));
        //G.addEdge(new DirectedWeightedEdge(3, 3, 1));
        G.addEdge(new DirectedWeightedEdge(3, 4, 0.953));
        G.addEdge(new DirectedWeightedEdge(4, 0, 0.995));
        G.addEdge(new DirectedWeightedEdge(4, 1, 0.732));
        G.addEdge(new DirectedWeightedEdge(4, 2, 0.650));
        G.addEdge(new DirectedWeightedEdge(4, 3, 1.049));
        //G.addEdge(new DirectedWeightedEdge(4, 4, 1));

        ArbitrageDetection ad = new ArbitrageDetection(G);

    }

}
