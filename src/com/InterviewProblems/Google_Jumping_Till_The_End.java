package com.InterviewProblems;

import javafx.util.Pair;

/**
 * You are given  an integer array A of size N. You can jump from index J to index K, such that K > J, in the following
 * way:
 * during odd-numbered jumps (ie jumps 1,3,5 and so on), you jump to the smallest index K such that A[J] < A[K] and
 * A[K] - A[J] is minimal among all possible K's.
 * during even-numbered jumps (ie jumps 2,4,6 and so on), you jump to the smallest index K such that A[J] > A[K] and
 * A[j] - A[K] is minimal among all possible K's.
 *
 * It may be that, for some index J, there is no legal jump. In this case, the jumping stops.
 *
 * Write a function :
 *      class  Solution { public int solution (int[] A); }
 * that, given an integer array A of length N, returns an integer denoting the number of starting points from which you
 * can reach (maybe by jumping more than once) the end of the array A (index N-1).
 *
 * For eg. A = [10,13,12,14,15] the function should return 2.
 * Explanation:
 *
 * for J = 0
 * 1st jump : 10->12
 * 2nd jump : no legal jump as all elements > 12
 *
 * for J = 1
 * 1st jump : 13->14
 * 2nd jump : no legal jump as all elements > 14
 *
 * for J = 2
 * 1st jump : 12->14
 * 2nd jump : no legal jump as all elements > 14
 *
 * for J = 3
 * 1st jump : 14->15 (last element)
 *
 * for J = 4
 * already at last element
 *
 * Therefore, answer is 2 (J = 3,4)
 */
public class Google_Jumping_Till_The_End {

    public int solution(int[] A) {

        boolean[][] dp = new boolean[2][A.length];
        dp[0][A.length - 1] = true;
        dp[1][A.length - 1] = true;

        BST bst = new BST();
        for(int i = A.length - 2 ; i >= 0 ; i--) {
            bst.insert(new BSTNode(A[i+1], i+1));
            Pair<Integer, Integer> pair = bst.search(A[i]);

            //if next jump is odd-numbered, we'll use the just greater value (max)
            if(pair.getValue() == null) {
                dp[0][i] = false;
            } else {
                dp[0][i] = dp[1][pair.getValue()];
            }

            //if next jump is even-numbered, we'll use the just smaller value (min)
            if(pair.getKey() == null) {
                dp[1][i] = false;
            } else {
                dp[1][i] = dp[0][pair.getKey()];
            }

        }

        int sol = 0;
        for(int i = 0 ; i < A.length ; i++) {
            if (dp[0][i]) {
                sol++;
            }
        }
        return sol;
    }


    class BSTNode {

        int value;
        int idx;
        BSTNode left;
        BSTNode right;

        public BSTNode(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }

    class BST {

        BSTNode root;

        public void insert(BSTNode node) {

            if (root == null) {
                root = node;
                return;
            }

            BSTNode curr = root;
            BSTNode prev = root;
            while (curr != null) {
                prev = curr;
                if (curr.value > node.value) {
                    curr = curr.left;
                } else {
                    curr = curr.right;
                }
            }
            if(prev.value > node.value) {
                prev.left = node;
            } else {
                prev.right = node;
            }
        }

        public Pair<Integer, Integer> search(int value) {

            if(root == null) {
                return null;
            }

            Integer min = null;
            Integer max = null;

            BSTNode trav = root;
            boolean maxFound = false;
            boolean minFound = false;

            while (true) {
                if (trav == null) {
                    return new Pair<>(min, max);
                }
                if(trav.value > value) {
                    if (minFound) {
                        max = trav.idx;
                        return new Pair<>(min, max);
                    }
                    max = trav.idx;
                    trav = trav.left;
                    maxFound = true;
                } else {
                    if (maxFound) {
                        min = trav.idx;
                        return new Pair<>(min, max);
                    }
                    min = trav.idx;
                    trav = trav.right;
                    minFound = true;
                }
            }
        }
    }

    public static void main(String[] args) {

        Google_Jumping_Till_The_End gjtte = new Google_Jumping_Till_The_End();
        int[] A1 = {10,13,12,14,15};
        int[] A2 = {10,12,11,14,13};
        System.out.println(gjtte.solution(A1));
        System.out.println(gjtte.solution(A2));
    }


}
