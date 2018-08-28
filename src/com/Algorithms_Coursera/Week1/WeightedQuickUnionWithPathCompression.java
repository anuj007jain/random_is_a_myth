package com.Algorithms_Coursera.Week1;

public class WeightedQuickUnionWithPathCompression {
    private int[] id;
    private int[] sz;

    private WeightedQuickUnionWithPathCompression(int n) {
        id = new int[n];
        sz = new int[n];

        for(int i = 0; i < n; ++i) {
            id[i] = i;
            sz[i] = 1;
        }

    }

    private void union(int p, int q) {
        if(!connected(p, q)) {
            int rootp = findRoot(p);
            int rootq = findRoot(q);
            if(sz[rootp] < sz[rootq]) {
                id[rootp] = rootq;
                sz[rootq] += sz[rootp];
            } else {
                id[rootq] = rootp;
                sz[rootp] += sz[rootq];
            }

        }
    }

    private boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    private int findRoot(int p) {
        while(p != id[p]) {
            id[p] = id[id[p]]; //path compression
            p = id[p];
        }

        return p;
    }

    private void print() {
        for(int i = 0; i < id.length; ++i) {
            System.out.print(id[i] + " ");
        }

        System.out.println();
    }

    private void printSize() {
        for(int i = 0; i < sz.length; ++i) {
            System.out.print(sz[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        byte n = 10;
        WeightedQuickUnionWithPathCompression weightedQuickUnionWithPathCompression = new WeightedQuickUnionWithPathCompression(n);
        weightedQuickUnionWithPathCompression.union(4, 3);
        weightedQuickUnionWithPathCompression.print();
        weightedQuickUnionWithPathCompression.union(3, 8);
        weightedQuickUnionWithPathCompression.print();
        weightedQuickUnionWithPathCompression.union(6, 5);
        weightedQuickUnionWithPathCompression.print();
        weightedQuickUnionWithPathCompression.union(9, 4);
        weightedQuickUnionWithPathCompression.print();
        weightedQuickUnionWithPathCompression.union(2, 1);
        weightedQuickUnionWithPathCompression.print();
        System.out.println(weightedQuickUnionWithPathCompression.connected(8, 9));
        System.out.println(weightedQuickUnionWithPathCompression.connected(5, 0));
        weightedQuickUnionWithPathCompression.union(5, 0);
        weightedQuickUnionWithPathCompression.print();
        weightedQuickUnionWithPathCompression.union(7, 2);
        weightedQuickUnionWithPathCompression.print();
        weightedQuickUnionWithPathCompression.union(6, 1);
        weightedQuickUnionWithPathCompression.print();
        weightedQuickUnionWithPathCompression.union(7, 3);
        weightedQuickUnionWithPathCompression.print();
        weightedQuickUnionWithPathCompression.printSize();
    }
}
