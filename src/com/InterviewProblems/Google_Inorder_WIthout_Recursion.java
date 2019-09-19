package com.InterviewProblems;

public class Google_Inorder_WIthout_Recursion {

    static class Node {
        int val;
        Node left;
        Node right;
        Node parent;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node parent) {
            this.val = val;
            this.parent = parent;
        }
    }

    public void inorderWithoutRecursion(Node root) {

        Node node = root;
        int source = 0;
        while(true) {
            //reached node from parent;
            if (source == 0) {
                if (node.left != null) {
                    node = node.left;
                    continue;
                } else {
                    System.out.println(node.val);
                    if (node.right != null) {
                        node = node.right;
                        continue;
                    } else {
                        if (node.parent == null) {
                            return;
                        }
                        if (node.parent.left != null && node.parent.left.equals(node)) {
                            source = 1;
                        } else {
                            source = 2;
                        }
                        node = node.parent;
                        continue;
                    }
                }
            } if (source == 1) {
                System.out.println(node.val);
                if (node.right != null) {
                    source = 0;
                    node = node.right;
                    continue;
                } else {
                    if (node.parent == null) {
                        return;
                    }
                    if (node.parent.left != null && node.parent.left.equals(node)) {
                        source = 1;
                    } else {
                        source = 2;
                    }
                    node = node.parent;
                    continue;
                }
            } else {
                if (node.parent == null) {
                    return;
                }
                if (node.parent.left != null && node.parent.left.equals(node)) {
                    source = 1;
                } else {
                    source = 2;
                }
                node = node.parent;
                continue;
            }
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2, root);
        root.right = new Node(3, root);
        root.left.left = new Node(4, root.left);
        root.left.right = new Node(5, root.left);
        root.right.right = new Node(6, root.right);

        /*
                    1
                   / \
                  2   3
                 / \   \
                4   5   6

                Expected Output : 4 2 5 1 3 6
         */

        Google_Inorder_WIthout_Recursion giwr = new Google_Inorder_WIthout_Recursion();
        giwr.inorderWithoutRecursion(root);
    }

}
