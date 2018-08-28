package com.Algorithms_Coursera.Week1;

public class QuickUnion {
    private int[] id;

    public QuickUnion(int n) {
        id = new int[n];

        for(int i = 0; i < n; id[i] = i++);

    }

    public void union(int p, int q) {
        int rootp = findRoot(p);
        int rootq = findRoot(q);
        id[rootp] = rootq;
    }

    private int findRoot(int p) {
        while(p != id[p]) {
            p = id[p];
        }
        return p;
    }

    public boolean connected(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    private void print() {
        for(int i = 0; i < id.length; ++i) {
            System.out.print(id[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        byte n = 10;
        QuickUnion quickUnion = new QuickUnion(n);
        quickUnion.union(4, 3);
        quickUnion.print();
        quickUnion.union(3, 8);
        quickUnion.print();
        quickUnion.union(6, 5);
        quickUnion.print();
        quickUnion.union(9, 4);
        quickUnion.print();
        quickUnion.union(2, 1);
        quickUnion.print();
        System.out.println(quickUnion.connected(8, 9));
        System.out.println(quickUnion.connected(5, 0));
        quickUnion.union(5, 0);
        quickUnion.print();
        quickUnion.union(7, 2);
        quickUnion.print();
        quickUnion.union(6, 1);
        quickUnion.print();
        quickUnion.union(7, 3);
        quickUnion.print();
    }
}
