package com.Algorithms_Coursera.Week1;

import java.util.Random;

public class Percolation {
    private int[] id;
    private int[] sz;
    int N;
    int[][] percolationMatrix;
    int openSites;

    private Percolation(int n) {
        percolationMatrix = new int[n][n];
        id = new int[n * n + 2];
        sz = new int[n * n + 2];
        openSites = 0;

        int i;
        for(i = 0; i <= n * n + 1; ++i) {
            id[i] = i;
            sz[i] = 1;
        }

        for(i = 0; i < n; ++i) {
            union(0, i + 1);
            union(n * n + 1, n * n - i);
        }

        N = n;
    }

    private void open(int row, int col) {
        if(percolationMatrix[row - 1][col - 1] != 1) {
            percolationMatrix[row - 1][col - 1] = 1;
            ++openSites;
            if(row > 1 && isOpen(row - 2, col - 1)) {
                union((row - 2) * N + col, (row - 1) * N + col);
            }

            if(row < N && isOpen(row, col - 1)) {
                union(row * N + col, (row - 1) * N + col);
            }

            if(col > 1 && isOpen(row - 1, col - 2)) {
                union((row - 1) * N + (col - 1), (row - 1) * N + col);
            }

            if(col < N && isOpen(row - 1, col)) {
                union((row - 1) * N + col + 1, (row - 1) * N + col);
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

    private boolean isOpen(int row, int col) {
        return percolationMatrix[row][col] == 1;
    }

    private boolean isClosed(int row, int col) {
        return percolationMatrix[row][col] == 0;
    }

    private int numberOfOpenSites() {
        return openSites;
    }

    private boolean percolates() {
        return connected(0, N * N + 1);
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

    private void printPercolationMatrix() {
        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < N; ++j) {
                System.out.print(percolationMatrix[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println();
    }

    private void printRoots() {
        for(int i = 0; i <= N * N + 1; ++i) {
            System.out.print(id[i] + " ");
        }

        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        short n = 1000;
        float finalAnswer = 0.0F;
        Percolation percolation = new Percolation(n);

        for(int i = 0; i < 100; ++i) {
            while(!percolation.percolates()) {
                Random answer = new Random();
                byte low = 1;
                int high = n + 1;
                int x = answer.nextInt(high - low) + low;
                int y = answer.nextInt(high - low) + low;
                percolation.open(x, y);
            }

            float var10 = (float)percolation.numberOfOpenSites() / (float)(n * n);
            finalAnswer += var10;
        }

        System.out.println(finalAnswer / 100.0F);
    }
}
