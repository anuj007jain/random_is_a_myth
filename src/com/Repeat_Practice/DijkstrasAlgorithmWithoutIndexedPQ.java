package com.Repeat_Practice;

import com.Algorithms_2_Coursera.Week2.ShortestPaths.DirectedWeightedEdge;
import com.Algorithms_2_Coursera.Week2.ShortestPaths.DirectedWeightedGraph;

import java.util.ArrayList;
import java.util.List;

public class DijkstrasAlgorithmWithoutIndexedPQ {

    MinPQ minPQ;
    int[] edgeFrom;
    double[] pathLen;

    public DijkstrasAlgorithmWithoutIndexedPQ(DirectedWeightedGraph G) {
        minPQ = new MinPQ(G.V());
        edgeFrom = new int[G.V()];
        pathLen = new double[G.V()];

        for (int i = 1 ; i < G.V() ; i++) {
            pathLen[i] = Double.POSITIVE_INFINITY;
        }

        minPQ.insert(0, 0);

        while (minPQ.size > 0) {
            HeapObject v = minPQ.delMin();
            visit(G, v);
        }
    }

    private void visit(DirectedWeightedGraph G, HeapObject ho) {
        for (DirectedWeightedEdge edge : G.adj(ho.vertex)) {
            int v = edge.from();
            int w = edge.to();
            if (pathLen[w] > pathLen[v] + edge.weight()) {
                pathLen[w] = pathLen[v] + edge.weight();
                edgeFrom[w] = v;
                minPQ.decreaseKey(w, pathLen[w]);
            }
        }
    }

    private class HeapObject implements Comparable{
        Integer vertex;
        Double distanceFromSource;

        public HeapObject(Integer vertex, Double distanceFromSource) {
            this.vertex = vertex;
            this.distanceFromSource = distanceFromSource;
        }

        @Override
        public int compareTo(Object o) {
            HeapObject other = (HeapObject)o;
            return this.distanceFromSource.compareTo(other.distanceFromSource);
        }
    }

    private class MinPQ {

        HeapObject[] heap;
        int size;
        List<Integer> verticesInHeap;
        int[] qp;

        public MinPQ(int vertices) {
            this.heap = new HeapObject[vertices + 1];
            size = 0;
            verticesInHeap = new ArrayList();
            qp = new int[vertices + 1];
        }

        public void insert (int vertex, double distanceFromSource) {
            heap[++size] = new HeapObject(vertex, distanceFromSource);
            qp[vertex] = size;
            swim(size);
            verticesInHeap.add(vertex);
        }

        private void swim (int size) {
            while (size / 2 > 0 && heap[size/2].compareTo(heap[size]) > 0) {
                swap(size/2, size);
                size = size/2;
            }
        }

        private void swap (int i, int j) {
            qp[heap[i].vertex] = j;
            qp[heap[j].vertex] = i;

            HeapObject temp = heap[i];
            heap[i] = heap[j];
            heap[j] = temp;
        }

        public HeapObject delMin() {
            if (size == 0) {
                return null;
            }
            HeapObject min = heap[1];
            verticesInHeap.remove(Integer.valueOf(min.vertex));

            if (size == 1) {
                size = 0;
                qp[min.vertex] = -1;
                return min;
            }
            qp[min.vertex] = -1;
            qp[heap[size].vertex] = 1;
            heap[1] = heap[size--];
            sink(1);
            return min;
        }

        private void sink(int i) {
            while (2*i <= size) {
                int smallerChildIndex = 2*i;
                if (2*i > size && heap[smallerChildIndex].compareTo(heap[2*i+1]) > 0) {
                    smallerChildIndex = 2*i+1;
                }
                if (heap[smallerChildIndex].compareTo(heap[i]) > 0) {
                    break;
                }
                swap(smallerChildIndex, i);
                i = smallerChildIndex;
            }
        }

        public void decreaseKey(int v, double distanceFromSource) {
            if (verticesInHeap.contains(v)) {
                sink(qp[v]);
            }
            else {
                insert(v, distanceFromSource);
            }
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

        DijkstrasAlgorithmWithoutIndexedPQ da = new DijkstrasAlgorithmWithoutIndexedPQ(G);
        int x = 0;

    }

}
