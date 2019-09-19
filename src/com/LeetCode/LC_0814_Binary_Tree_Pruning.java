package com.LeetCode;

public class LC_0814_Binary_Tree_Pruning {

    public TreeNode pruneTree(TreeNode root) {
        if (pruneNodeInternal(root)) {
            return null;
        }
        return root;
    }

    class TreeNode {
        TreeNode left;
        TreeNode right;
        int val;
    }

    boolean pruneNodeInternal(TreeNode node) {
        boolean leftPruned = false, rightPruned = false;
        if (node.left != null) {
            if (pruneNodeInternal((node.left))) {
                node.left = null;
                leftPruned = true;
            }
        } else {
            leftPruned = true;
        }
        if (node.right != null) {
            if (pruneNodeInternal((node.right))) {
                node.right = null;
                rightPruned = true;
            }
        } else {
            rightPruned = true;
        }
        if (leftPruned && rightPruned && node.val == 0) {
            return true;
        }
        return false;
    }

}
