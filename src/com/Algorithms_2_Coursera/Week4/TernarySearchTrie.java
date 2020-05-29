package com.Algorithms_2_Coursera.Week4;

import java.util.LinkedList;
import java.util.Queue;

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
        Node node =  get(root, str, 0);
        if (node == null) {
            return null;
        }
        return node.value;
    }

    private Node get (Node node, String str, int d) {
        if (node == null) {
            return null;
        }
        if (node.c > str.charAt(d)) {
            return get(node.left, str, d);
        } else if (node.c < str.charAt(d)) {
            return get(node.right, str, d);
        }
        if (str.length() > d+1) {
            return get(node.middle, str, d+1);
        }
        return node;
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

    public Iterable<String> keys() {
        Queue<String> q = new LinkedList<>();
        return keys(root, "", q);
    }

    private Iterable<String> keys(Node node, String str, Queue<String> q) {
        if (node.value != null) {
            q.add(str + node.c);
        }
        if (node.left != null) {
            keys(node.left, str, q);
        }
        if (node.right != null) {
            keys(node.right, str, q);
        }
        if (node.middle != null) {
            keys(node.middle, str+node.c, q);
        }
        return q;
    }

    public Iterable<String> keysWithPrefix(String s) {
        Queue<String> q = new LinkedList<>();
        Node node = get(root, s, 0);
        if (node == null) {
            return q;
        }
        if (node.middle == null) {
            q.add(s);
            return q;
        }
        return keys(node.middle, s, q);
    }

    public String longestPrefixOf(String s) {
        return longestPrefixOf(root, s, 0, "");
    }

    private String longestPrefixOf(Node node, String str, int d, String longestPrefix) {
        if (node == null) {
            return longestPrefix;
        }
        if (node.c > str.charAt(d)) {
            return longestPrefixOf(node.left, str, d, longestPrefix);
        } else if (node.c < str.charAt(d)) {
            return longestPrefixOf(node.right, str, d, longestPrefix);
        }
        if (node.value != null) {
            longestPrefix = str.substring(0, d+1);
        }
        if (str.length() > d+1) {
            return longestPrefixOf(node.middle, str, d+1, longestPrefix);
        }
        return longestPrefix;
    }

    public static void main(String[] args) {

        TernarySearchTrie tst = new TernarySearchTrie();
        tst.put("anuj", 3);
        tst.put("palak", 1);
        tst.put("payal", "qwe");
        tst.put("rt",4);
        tst.put("pa", 2);
        System.out.println(tst.get("anuj"));
        System.out.println(tst.get("palak"));
        System.out.println(tst.get("payal"));
        System.out.println(tst.get("anuja"));
        System.out.println(tst.get("an"));
        System.out.println(tst.get("krish"));
        System.out.println(tst.get("paya"));
//        tst.delete("payal");
        System.out.println(tst.get("payal"));
        System.out.println(tst.get("palak"));
        System.out.println(tst.keys());
        System.out.println(tst.keysWithPrefix("pal"));
        System.out.println(tst.longestPrefixOf("p"));

    }

}
