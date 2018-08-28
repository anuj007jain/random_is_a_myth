package com.Algorithms_2_Coursera.Week2.MinimumSpanningTrees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by anuj.jain02 on 1/6/18.
 */
public class PrimsEagerAlgorithm {

    IndexMinPQ<WeightedEdge> indexMinPQ;
    Queue<WeightedEdge> mst;
    double weight;
    boolean[] marked;

    public PrimsEagerAlgorithm(WeightedEdgeGraph G) {
        indexMinPQ = new IndexMinPQ<>(G.V());
        mst = new LinkedList<>();
        weight = 0;
        marked = new boolean[G.V()];
        visit(G, 0);
        while (!indexMinPQ.isEmpty() && mst.size() != G.V()-1) {
            int w = indexMinPQ.getMin();
            mst.add(indexMinPQ.get(w));
            visit(G, indexMinPQ.delMin());
        }
        System.out.println(mst);
    }

    private void visit(WeightedEdgeGraph G, int v) {
        marked[v] = true;
        for(WeightedEdge edge : G.adj(v)) {
            int w = edge.other(v);
            if(marked[w]) {
                continue;
            }
            if(!indexMinPQ.contains(w)) {
                indexMinPQ.insert(w, edge);
            } else {
                if(indexMinPQ.get(w).compareTo(edge) < 0) {
                    continue;
                } else {
                    indexMinPQ.decreaseKey(w, edge);
                }
            }
        }
    }

    public static void main(String[] args) {

        WeightedEdgeGraph G = new WeightedEdgeGraph(8);
        G.addEdge(new WeightedEdge(0,2,0.26));
        G.addEdge(new WeightedEdge(0,4,0.38));
        G.addEdge(new WeightedEdge(0,6,0.58));
        G.addEdge(new WeightedEdge(0,7,0.16));
        G.addEdge(new WeightedEdge(1,2,0.36));
        G.addEdge(new WeightedEdge(1,3,0.29));
        G.addEdge(new WeightedEdge(1,5,0.32));
        G.addEdge(new WeightedEdge(1,7,0.19));
        G.addEdge(new WeightedEdge(6,2,0.40));
        G.addEdge(new WeightedEdge(2,3,0.17));
        G.addEdge(new WeightedEdge(7,2,0.34));
        G.addEdge(new WeightedEdge(6,3,0.52));
        G.addEdge(new WeightedEdge(4,5,0.35));
        G.addEdge(new WeightedEdge(4,6,0.93));
        G.addEdge(new WeightedEdge(7,4,0.37));
        G.addEdge(new WeightedEdge(5,7,0.28));
        new PrimsEagerAlgorithm(G);
    }

}