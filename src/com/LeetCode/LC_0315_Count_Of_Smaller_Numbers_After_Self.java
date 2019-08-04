package com.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class LC_0315_Count_Of_Smaller_Numbers_After_Self {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> solution = new ArrayList<>();
        BST bst = new BST();
        for (int i = nums.length - 1 ; i >= 0 ; i--) {
            int value = bst.find(nums[i]);
            solution.add(0,value);
            bst.insert(nums[i]);
        }
        return solution;
    }

    class BSTNode {
        int key;
        int value; // number of elements in left subtree
        BSTNode left;
        BSTNode right;

        public BSTNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    class BST {
        BSTNode root;

        public void insert(int key) {
            BSTNode trav = root;
            if (trav == null) {
                root = new BSTNode(key, 0);
                return;
            }
            while(true) {
                if (trav.key > key) {
                    trav.value = trav.value + 1;
                    if (trav.left == null) {
                        trav.left = new BSTNode(key, 0);
                        return;
                    }
                    trav = trav.left;
                } else if (trav.key < key) {
                    if (trav.right == null) {
                        trav.right = new BSTNode(key, 0);
                        return;
                    }
                    trav = trav.right;
                } else {
                    trav.value = trav.value + 1;
                    return;
                }
            }
        }

        public int find(int key) {
            int value = 0;
            BSTNode trav = root;
            if (trav == null) {
                return value;
            }
            while(true) {
                if (trav.key < key) {
                    value += trav.value + 1;
                    if (trav.right == null) {
                        return value;
                    }
                    trav = trav.right;
                } else if (trav.key >= key) {
                    if (trav.left == null) {
                        return value;
                    }
                    trav = trav.left;
                }
            }
        }
    }

    public static void main(String[] args) {
        LC_0315_Count_Of_Smaller_Numbers_After_Self lc_315_cosnas = new LC_0315_Count_Of_Smaller_Numbers_After_Self();
        System.out.println(lc_315_cosnas.countSmaller(new int[]{26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41}));
        System.out.println(lc_315_cosnas.countSmaller(new int[]{2,0,1}));
    }

}
