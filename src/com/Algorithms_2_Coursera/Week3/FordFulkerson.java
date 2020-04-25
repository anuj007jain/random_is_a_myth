package com.Algorithms_2_Coursera.Week3;

import edu.princeton.cs.algs4.Bag;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class FordFulkerson {

    private boolean[] marked;
    private FlowEdge[] edgeTo;
    private double flow;

    public FordFulkerson(int source, int sink, FlowNetwork network) {

        flow = 0;
        while (hasAugmentingPath(source, sink, network)) {
            int w = sink;
            double bottleneck = Double.POSITIVE_INFINITY;
            while (w != source) {
                bottleneck = Math.min(bottleneck, edgeTo[w].residualCapacityTo(w));
                w = edgeTo[w].other(w);
            }
            w = sink;
            while (w != source) {
                edgeTo[w].addResidualFlowTo(w, bottleneck);
                w = edgeTo[w].other(w);
            }
            flow += bottleneck;
        }
    }

    private boolean hasAugmentingPath(int source, int sink, FlowNetwork network) {
        marked = new boolean[network.V];
        edgeTo = new FlowEdge[network.V];

        Queue<Integer> queue = new LinkedList();
        ((LinkedList<Integer>) queue).addFirst(source);
        marked[source] = true;
        while (!queue.isEmpty()) {
            int v = ((LinkedList<Integer>) queue).removeFirst();
            for (FlowEdge e : network.adj[v]) {
                int to = e.other(v);
                if (e.residualCapacityTo(to) > 0 && !marked[to]) {
                    edgeTo[to] = e;
                    marked[to] = true;
                    ((LinkedList<Integer>) queue).addLast(to);
                }
            }
        }
        return marked[sink];
    }

    public double flow() {
        return flow;
    }

    public Iterable<Integer> minCut() {
        Iterable<Integer> cut = new LinkedList<>();
        for (int v = 0 ; v < marked.length ; v++) {
            if (marked[v]) {
                ((LinkedList<Integer>) cut).add(v);
            }
        }
        return cut;
    }

    public static class FlowEdge {

        private final int v;
        private final int w;
        private final double capacity;
        private double flow;

        public FlowEdge(int v, int w, double capacity) {
            this.v = v;
            this.w = w;
            this.capacity = capacity;
            this.flow = 0;
        }

        public int from() {
            return v;
        }

        public int to() {
            return w;
        }

        public int other(int v) {
            if (this.v == v) {
                return w;
            } else if (this.w == v) {
                return this.v;
            }
            throw new RuntimeException("Illegal endpoint");
        }

        public double capacity() {
            return capacity;
        }

        public double flow() {
            return flow;
        }

        public double residualCapacityTo(int v) {
            if (v == this.v) {
                return flow;
            } else if (v == this.w) {
                return capacity - flow;
            }
            throw new IllegalArgumentException();
        }

        public void addResidualFlowTo(int v, double delta) {
            if (v == this.v) {
                flow -= delta;
            } else if (v == this.w){
                flow += delta;
            } else {
                throw new IllegalArgumentException();
            }

        }
    }

    public static class FlowNetwork {

        private final int V;
        private Bag<FlowEdge> adj[];

        public FlowNetwork (int V) {
            this.V = V;
            adj = (Bag<FlowEdge>[]) new Bag[V];
            for (int i = 0 ; i < V ; i++) {
                adj[i] = new Bag<>();
            }
        }

        public void addEdge(FlowEdge e) {
            int from = e.from();
            int to = e.to();
            adj[from].add(e);
            adj[to].add(e);
        }

        public Iterable<FlowEdge> adj(int v) {
            return adj[v];
        }

    }

    public static void main(String[] args) {
        FlowNetwork fn = new FlowNetwork(6);
        fn.addEdge(new FlowEdge(0, 1, 12));
        fn.addEdge(new FlowEdge(0, 2, 12));
        fn.addEdge(new FlowEdge(1, 3, 12));
        fn.addEdge(new FlowEdge(2, 1, 1));
        fn.addEdge(new FlowEdge(2, 4, 11));
        fn.addEdge(new FlowEdge(3, 5, 19));
        fn.addEdge(new FlowEdge(4, 3, 7));
        fn.addEdge(new FlowEdge(4, 5, 4));

        FordFulkerson ff = new FordFulkerson(0, 5, fn);
        System.out.println(ff.flow);
        System.out.println(ff.minCut());
    }

}
