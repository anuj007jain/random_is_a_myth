package com.LeetCode;

public class LC_1038_Binary_Search_Tree_To_Greater_Sum_Tree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode bstToGst(TreeNode root) {
        bstToGstInternal(root, 0);
        return root;
    }

    int bstToGstInternal(TreeNode node, int val) {
        if (node.right != null) {
            val = bstToGstInternal(node.right, val);
        }
        node.val += val;
        val = node.val;
        if (node.left != null) {
            val = bstToGstInternal(node.left, val);
        }
        return val;
    }

    public static void main(String[] args) {
        LC_1038_Binary_Search_Tree_To_Greater_Sum_Tree lc_1038_bsttgst = new LC_1038_Binary_Search_Tree_To_Greater_Sum_Tree();
        TreeNode root  = new TreeNode(4);
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(3);
        root.right = new TreeNode(6);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        lc_1038_bsttgst.bstToGst(root);
    }

}
