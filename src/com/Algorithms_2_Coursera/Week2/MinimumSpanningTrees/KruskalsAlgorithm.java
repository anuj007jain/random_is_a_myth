package com.Algorithms_2_Coursera.Week2.MinimumSpanningTrees;

import com.Algorithms_Coursera.Week1.QuickUnion;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by anuj.jain02 on 30/4/18.
 */
public class KruskalsAlgorithm {

    private MinPriorityQueue<WeightedEdge> priorityQueue;
    private Queue<WeightedEdge> mst;
    private double weight;

    public KruskalsAlgorithm(WeightedEdgeGraph G) {

        priorityQueue = new MinPriorityQueue<>();
        mst = new LinkedList<>();
        weight = 0;
        for(WeightedEdge edge : G.edges()) {
            priorityQueue.insert(edge);
        }
        Iterator iterator = priorityQueue.iterator();
        QuickUnion quickUnion = new QuickUnion(G.V());
        while (iterator.hasNext() && mst.size() != G.V()-1) {
            WeightedEdge edge = (WeightedEdge) iterator.next();
            int v = edge.either();
            int w = edge.other(v);
            if(!quickUnion.connected(v, w)) { // adding them will not create a cycle since they are in different components
                mst.add(edge);
                quickUnion.union(v, w);
                weight += edge.weight();
            }
        }

        System.out.println("Mst edges: "+mst.toString());
        System.out.println("Mst weight: "+weight);
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
        new KruskalsAlgorithm(G);
    }

}
