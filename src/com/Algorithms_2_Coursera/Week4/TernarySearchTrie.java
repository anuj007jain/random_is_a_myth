package com.Algorithms_2_Coursera.Week4;

public class TernarySearchTrie {

    private Node root;

    private class Node {
        private Character c;
        private Object value;
        private Node left, middle, right;

        public Node(Character c) {
            this.c = c;
        }
    }

    private void put (String str, Object value) {
        root = put(root, str, value, 0);
    }

    private Node put (Node node, String str, Object value, int d) {
        if (node == null) {
            node = new Node(str.charAt(d));
        }
        if (str.length() > d+1) {
            if (node.c > str.charAt(d)) {
                node.left = put(node.left, str, value, d);
            } else if (node.c < str.charAt(d)) {
                node.right = put(node.right, str, value, d);
            } else {
                node.middle = put(node.middle, str, value, d + 1);
            }
        } else {
            node.value = value;
        }
        return node;

    }

    private Object get (String str) {
        return get(root, str, 0);
    }

    private Object get (Node node, String str, int d) {
        if (node == null) {
            return null;
        }
        if (str.length() > d+1) {
            if (node.c > str.charAt(d)) {
                return get(node.left, str, d);
            } else if (node.c < str.charAt(d)) {
                return get(node.right, str, d);
            } else {
                return get(node.middle, str, d+1);
            }
        }
        return node.value;
    }

    private void delete (String str) {
        delete(root, str, 0);
    }

    private boolean delete(Node node, String str, int d) {
        if (node == null) {
            return false;
        }
        if (str.length() > d+1) {
            if (node.c > str.charAt(d)) {
                if (delete(node.left, str, d)) {
                    node.left = null;
                    if (isLeafNode(node)) {
                        return true;
                    }
                }
                return false;
            } else if (node.c < str.charAt(d)) {
                if (delete(node.right, str, d)) {
                    node.right = null;
                    if (isLeafNode(node)) {
                        return true;
                    }
                }
                return false;
            } else {
                if(delete(node.middle, str, d+1)) {
                    node.middle = null;
                    if (isLeafNode(node)) {
                        return true;
                    }
                }
                return false;
            }
        } else {
            if (node.value == null) {
                return false;
            } else {
                node.value = null;
                if (isLeafNode(node)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
    }

    private boolean isLeafNode(Node node) {
        if (node.left == null && node.right == null && node.middle == null) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {

        TernarySearchTrie tst = new TernarySearchTrie();
        tst.put("anuj", 3);
        tst.put("palak", 1);
        tst.put("payal", "qwe");
//        System.out.println(tst.get("anuj"));
//        System.out.println(tst.get("palak"));
//        System.out.println(tst.get("payal"));
//        System.out.println(tst.get("anuja"));
//        System.out.println(tst.get("an"));
//        System.out.println(tst.get("krish"));
//        System.out.println(tst.get("paya"));
        tst.delete("payal");
        System.out.println(tst.get("payal"));
        System.out.println(tst.get("palak"));

    }

}
