package com.Algorithms_Coursera.Week1;

public class QuickFind {
    private int[] id;

    private QuickFind(int n) {
        id = new int[n];

        for(int i = 0; i < n; id[i] = i++) {
            ;
        }

    }

    private void union(int p, int q) {
        if(!connected(p, q)) {
            int idp = id[p];

            for(int i = 0; i < id.length; ++i) {
                if(id[i] == idp) {
                    id[i] = id[q];
                }
            }
        }

    }

    private void print() {
        for(int i = 0; i < id.length; ++i) {
            System.out.print(id[i] + " ");
        }

        System.out.println();
    }

    private boolean connected(int p, int q) {
        return id[p] == id[q];
    }

    public static void main(String[] args) {
        byte n = 10;
        QuickFind quickFind = new QuickFind(n);
        quickFind.print();
        quickFind.union(4, 3);
        quickFind.print();
        quickFind.union(3, 8);
        quickFind.print();
        quickFind.union(6, 5);
        quickFind.print();
        quickFind.union(9, 4);
        quickFind.print();
        quickFind.union(2, 1);
        quickFind.print();
        System.out.println(quickFind.connected(8, 9));
        System.out.println(quickFind.connected(5, 0));
        quickFind.union(5, 0);
        quickFind.print();
        quickFind.union(7, 2);
        quickFind.print();
        quickFind.union(6, 1);
        quickFind.print();
    }
}
