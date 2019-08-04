package com.LeetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_0310_Minimum_Height_Trees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> solution = new ArrayList<>();
            solution.add(0);
            return solution;
        }
        List<Integer>[] edgeTo = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0 ; i < n ; i++) {
            edgeTo[i] = new ArrayList<>();
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0 ; i < edges.length ; i++) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            edgeTo[v1].add(v2);
            edgeTo[v2].add(v1);
        }
        for (int i = 0 ; i < n ; i++) {
            if (edgeTo[i].size() == 1) {
                queue.add(i);
            }
        }
        while(n > 2) {
            int size = queue.size();
            for (int i = 0 ; i < size ; i++) {
                int leafNode = queue.poll();
                n--;
                for (int w : edgeTo[leafNode]) {
                    edgeTo[w].remove(new Integer(leafNode));
                    if (edgeTo[w].size() == 1) {
                        queue.add(w);
                    }
                }
            }
        }
        List<Integer> solution = new ArrayList<>();
        int size = queue.size();
        for (int i = 0; i < size ; i++) {
            solution.add(queue.poll());
        }
        return solution;
    }

    public static void main(String[] args) {
        LC_0310_Minimum_Height_Trees lc_310_mht = new LC_0310_Minimum_Height_Trees();
        int[][] edges1 = {{1,0},{1,2},{1,3}};
        int[][] edges2 = {{3,0},{3,2},{1,3},{4,3},{5,4}};
        System.out.println(lc_310_mht.findMinHeightTrees(6, edges2));
    }
}