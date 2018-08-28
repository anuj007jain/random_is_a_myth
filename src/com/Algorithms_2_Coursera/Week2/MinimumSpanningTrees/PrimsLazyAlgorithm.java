package com.Algorithms_2_Coursera.Week2.MinimumSpanningTrees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by anuj.jain02 on 1/6/18.
 */
public class PrimsLazyAlgorithm {

    MinPriorityQueue<WeightedEdge> priorityQueue;
    Queue<WeightedEdge> mst;
    Double weight;
    boolean[] marked;

    public PrimsLazyAlgorithm(WeightedEdgeGraph G) {

        priorityQueue = new MinPriorityQueue<>();
        mst = new LinkedList<>();
        weight = 0.0;
        marked = new boolean[G.V()];

        visit(G, 0);

        while (priorityQueue.size() != 0 || mst.size() != G.V() - 1) {
            WeightedEdge edge = priorityQueue.delMin();
            int v = edge.either();
            int w = edge.other(v);
            if(marked[v] && marked[w]) {
                continue; // this is because of lazy approach, some obsolete edges remain in the priority queue
            }
            mst.add(edge);
            if(!marked[v]) {
                visit(G,v);
            }
            else {
                visit(G,w);
            }
        }

        System.out.println(mst);
    }

    private void visit(WeightedEdgeGraph G, int v) {
        marked[v] = true;
        for(WeightedEdge edge : G.adj(v)) {
            if(!marked[edge.other(v)]) {
                priorityQueue.insert(edge);
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
        new PrimsLazyAlgorithm(G);
    }

}
