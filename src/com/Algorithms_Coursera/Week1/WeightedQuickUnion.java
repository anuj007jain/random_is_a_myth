package com.Algorithms_Coursera.Week1;

public class WeightedQuickUnion {
    private int[] id;
    private int[] sz;

    private WeightedQuickUnion(int n) {
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
        WeightedQuickUnion weightedQuickUnion = new WeightedQuickUnion(n);
        weightedQuickUnion.union(4, 3);
        weightedQuickUnion.print();
        weightedQuickUnion.union(3, 8);
        weightedQuickUnion.print();
        weightedQuickUnion.union(6, 5);
        weightedQuickUnion.print();
        weightedQuickUnion.union(9, 4);
        weightedQuickUnion.print();
        weightedQuickUnion.union(2, 1);
        weightedQuickUnion.print();
        System.out.println(weightedQuickUnion.connected(8, 9));
        System.out.println(weightedQuickUnion.connected(5, 0));
        weightedQuickUnion.union(5, 0);
        weightedQuickUnion.print();
        weightedQuickUnion.union(7, 2);
        weightedQuickUnion.print();
        weightedQuickUnion.union(6, 1);
        weightedQuickUnion.print();
        weightedQuickUnion.union(7, 3);
        weightedQuickUnion.print();
        weightedQuickUnion.printSize();
    }
}
