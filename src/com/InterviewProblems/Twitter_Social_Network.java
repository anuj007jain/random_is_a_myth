package com.InterviewProblems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Twitter_Social_Network {

    public static int countGroups (List<String> related) {
        int[] id = new int[related.size()];
        int[] sz = new int[related.size()];

        for (int i = 0; i < related.size(); ++i) {
            id[i] = i;
            sz[i] = 1;
        }

        for (int i = 0 ; i < related.size() ; i++) {
            String relate = related.get(i);
            for (int j = 0 ; j < related.size() ; j++) {
                if (relate.charAt(j) == '1') {
                    union(id, sz, i, j);
                }
            }
        }

        Set<Integer> set = new HashSet<>();

        for (int i = 0 ; i < id.length ; i++) {
            set.add(id[i]);
        }
        return set.size();
    }

    private static void union(int[] id, int[] sz, int p, int q) {
        if(!connected(id, p, q)) {
            int rootp = findRoot(id, p);
            int rootq = findRoot(id, q);
            if(sz[rootp] < sz[rootq]) {
                id[rootp] = rootq;
                sz[rootq] += sz[rootp];
            } else {
                id[rootq] = rootp;
                sz[rootp] += sz[rootq];
            }

        }
    }

    private static boolean connected(int[]id, int p, int q) {
        return findRoot(id, p) == findRoot(id, q);
    }

    private static int findRoot(int[] id, int p) {
        while(p != id[p]) {
            id[p] = id[id[p]]; //path compression
            p = id[p];
        }

        return p;
    }

    /*public static int countGroups (List<String> related) {
        boolean[][] relatedGraph = new boolean[related.size()][related.size()];
        for (int i = 0 ; i < related.size() ; i++) {
            String relate = related.get(i);
            for (int j = 0 ; j < related.size() ; j++) {
                relatedGraph[i][j] = relate.charAt(j) == '1' ? true : false;
            }
        }

        boolean[][] visited = new boolean[related.size()][related.size()];

        int count = 0;

        for (int i = 0 ; i < related.size() ; i++) {
            for (int j = 0 ; j < related.size() ;j++) {
                if (!visited[i][j] && relatedGraph[i][j]) {
                    dfs(visited, relatedGraph, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private static void dfs(boolean[][] visited, boolean[][] relatedGraph, int i, int j) {
        visited[i][j] = true;
        if (i+1 < visited.length && !visited[i+1][j] && relatedGraph[i+1][j]) {
            dfs(visited, relatedGraph, i+1, j);
        }
        if (j+1 < visited.length && !visited[i][j+1] && relatedGraph[i][j+1]) {
            dfs(visited, relatedGraph, i, j+1);
        }
    }*/

    public static void main(String[] args) {
        Twitter_Social_Network tsn = new Twitter_Social_Network();
        System.out.println(tsn.countGroups(Arrays.asList("10000","01000","00100","00010","00001")));
        System.out.println(tsn.countGroups(Arrays.asList("1100","1110","0110","0001")));
        System.out.println(tsn.countGroups(Arrays.asList("110","110","001")));

    }

}
