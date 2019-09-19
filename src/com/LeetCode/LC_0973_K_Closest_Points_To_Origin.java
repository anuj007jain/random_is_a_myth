package com.LeetCode;

import java.util.Collections;
import java.util.Objects;
import java.util.PriorityQueue;

public class LC_0973_K_Closest_Points_To_Origin {

    public int[][] kClosest(int[][] points, int K) {

        class PQNode implements Comparable{
            int dist;
            int[] point;

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                PQNode pqNode = (PQNode) o;
                return dist == pqNode.dist;
            }

            @Override
            public int hashCode() {
                return Objects.hash(dist);
            }

            public PQNode(int dist, int[] point) {
                this.dist = dist;
                this.point = point;
            }

            @Override
            public int compareTo(Object o) {
                if (this.dist < ((PQNode)o).dist) {
                    return -1;
                } else if (this.dist > ((PQNode)o).dist) {
                    return +1;
                }
                return 0;
            }
        }

        PriorityQueue<PQNode> pq = new PriorityQueue<>(K, Collections.reverseOrder());

        for (int[] point : points) {
            int dist = point[0] * point[0] + point[1] * point[1];
            if (pq.size() < K) {
                pq.add(new PQNode(dist, point));
            } else {
                if (pq.peek().dist > dist) {
                    pq.poll();
                    pq.add(new PQNode(dist, point));
                }
            }
        }

        int[][] solution = new int[K][2];
        int k = 0;
        while (!pq.isEmpty()) {
            solution[k++] = pq.poll().point;
        }
        return solution;
    }

    public static void main(String[] args) {
        LC_0973_K_Closest_Points_To_Origin lc_0973_kcpto = new LC_0973_K_Closest_Points_To_Origin();
        System.out.println(lc_0973_kcpto.kClosest(new int[][]{{3,3},{5,-1},{-2,4}}, 2));
    }

}
