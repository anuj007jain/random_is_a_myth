package com.Algorithms_2_Coursera.Week2.ShortestPaths;

import com.Algorithms_2_Coursera.Week2.MinimumSpanningTrees.IndexMinPQ;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by anuj.jain02 on 20/6/18.
 */
public class DijkstrasAlgorithm<Key extends Comparable> {

    IndexMinPQ<DirectedWeightedEdge> indexMinPQ;
    DirectedWeightedEdge[] edgeto;
    Queue<Integer> shortestPathTree;
    double[] distTo;

    public DijkstrasAlgorithm(DirectedWeightedGraph G) {

        indexMinPQ = new IndexMinPQ<>(G.V());
        edgeto = new DirectedWeightedEdge[G.V()];
        shortestPathTree = new LinkedList<>();
        distTo = new double[G.V()];
        for(int v = 1 ; v < G.V() ; v++) {
            distTo[v] = Double.MAX_VALUE;
        }
        visit(G, 0);

        while (!indexMinPQ.isEmpty()&& shortestPathTree.size() != G.V()) {
            int w = indexMinPQ.delMin();
            shortestPathTree.add(w);
            visit(G, w);
        }


    }

    private void visit(DirectedWeightedGraph G, int v) {
        for(DirectedWeightedEdge edge : G.adj(v)) {
            relaxEdge(edge);
        }
    }

    public void relaxEdge(DirectedWeightedEdge edge) {
        int v = edge.from(), w = edge.to();
        if(distTo[w] > distTo[v] + edge.weight()) {
            if(!indexMinPQ.contains(w)) {
                indexMinPQ.insert(w, edge);
            } else {
                indexMinPQ.decreaseKey(w, edge);
            }
            distTo[w] = distTo[v] + edge.weight();
            edgeto[w] = edge;
        }
    }

    public static void main(String[] args) {
        DirectedWeightedGraph G = new DirectedWeightedGraph(8);

        G.addEdge(new DirectedWeightedEdge(0, 1, 5.0));
        G.addEdge(new DirectedWeightedEdge(0, 4, 9.0));
        G.addEdge(new DirectedWeightedEdge(0, 7, 8.0));

        G.addEdge(new DirectedWeightedEdge(1, 2, 12.0));
        G.addEdge(new DirectedWeightedEdge(1, 3, 15.0));
        G.addEdge(new DirectedWeightedEdge(1, 7, 4.0));

        G.addEdge(new DirectedWeightedEdge(2, 3, 3.0));
        G.addEdge(new DirectedWeightedEdge(2, 6, 11.0));

        G.addEdge(new DirectedWeightedEdge(3, 6, 9.0));

        G.addEdge(new DirectedWeightedEdge(4, 5, 4.0));
        G.addEdge(new DirectedWeightedEdge(4, 6, 20.0));
        G.addEdge(new DirectedWeightedEdge(4, 7, 5.0));

        G.addEdge(new DirectedWeightedEdge(5, 2, 1.0));
        G.addEdge(new DirectedWeightedEdge(5, 6, 13.0));

        G.addEdge(new DirectedWeightedEdge(7, 5, 6.0));
        G.addEdge(new DirectedWeightedEdge(7, 2, 7.0));

        DijkstrasAlgorithm da = new DijkstrasAlgorithm<>(G);


    }
}
