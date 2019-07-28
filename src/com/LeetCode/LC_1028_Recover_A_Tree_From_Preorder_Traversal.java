package com.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class LC_1028_Recover_A_Tree_From_Preorder_Traversal {

    public static void main(String[] args) {
        LC_1028_Recover_A_Tree_From_Preorder_Traversal lc_1028_ratfpt = new LC_1028_Recover_A_Tree_From_Preorder_Traversal();
        lc_1028_ratfpt.recoverFromPreorder("3");
    }

    public TreeNode recoverFromPreorder(String S) {
        Map<Integer, TreeNode> depthToNode = new HashMap<>();
        int i = 0;
        while (i < S.length() && Character.isDigit(S.charAt(i))) {
            i++;
        }
        TreeNode root = new TreeNode(Integer.parseInt(S.substring(0, i)));
        depthToNode.put(1, root);
        int depth = 1;
        while (i < S.length()) {
            //System.out.println(i);
            int count = 0;
            while (S.charAt(i) == '-') {
                count++;
                i++;
            }
            //System.out.println(count+" "+depth+" "+i);
            int j = i;
            while(i < S.length() && Character.isDigit(S.charAt(i))) {
                i++;
            }
            //case 1 : if the current node has no child, number of dashes will be less than the depth of current node
            if (count < depth) {
                // find out the parent of which this is the right child using count as depth
                TreeNode parent = depthToNode.get(count);
                parent.right = new TreeNode(Integer.parseInt(S.substring(j,i)));
                depth = count;
                depthToNode.put(++depth, parent.right);
            }
            //case 2 : if the current node has left child, number of dashes will be equal to the depth of the current node
            else if (count == depth) {
                TreeNode parent = depthToNode.get(count);
                //System.out.println("i: "+i);
                parent.left = new TreeNode(Integer.parseInt(S.substring(j,i)));
                depthToNode.put(++depth, parent.left);
            }
        }
        return root;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

}
