package com.LeetCode;

//https://leetcode.com/problems/validate-binary-search-tree/
public class LC_0098_Validate_Binary_Search_Tree {



     public static class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;

         TreeNode(int x) {
             val = x;
         }
     }

    public boolean isValidBST(TreeNode node, double minValue, double maxValue) {

        if(node == null) {
            return true;
        }

        if(node.val <= minValue || node.val >= maxValue) {
            return false;
        }

        return isValidBST(node.left, minValue, node.val) && isValidBST(node.right, node.val, maxValue);

    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, -Double.MAX_VALUE, Double.MAX_VALUE);
    }

    public static void main(String[] args) {
        LC_0098_Validate_Binary_Search_Tree lc_098_vbst = new LC_0098_Validate_Binary_Search_Tree();
        TreeNode root = new TreeNode(0);
        System.out.println(lc_098_vbst.isValidBST(root));
    }

}
