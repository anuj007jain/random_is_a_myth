package com.Algorithms_2_Coursera.Week4;

public class RWayTrie {

    static int R;
    static Node root;

    public RWayTrie() {
        R = 26;
        root = new Node();
    }

    public void put(String str, Object val) {
        put(root, str, val, 0);
    }

    private Node put(Node node, String str, Object val, int d) {
        if (node == null) {
            node = new Node();
        }
        if (str.length() > d) {
            int idx = str.charAt(d) - 97;
            node.next[idx] = put(node.next[idx], str, val, d+1);
        } else {
            node.value = val;
        }
        return node;
    }

    private Object get(String str) {
        return get(root, str, 0);
    }

    private Object get(Node node, String str, int d) {
        if (node == null) {
            return null;
        }
        if (str.length() == d) {
            return node.value;
        }
        int idx = str.charAt(d) - 97;
        return get(node.next[idx], str, d+1);
    }

    private boolean delete(String str) {
        return delete(root, str, 0);
    }

    private boolean delete(Node node, String str, int d) {
        if (node == null) {
            return false;
        }
        if (str.length() == d) {
            if (node.value == null) {
                return false;
            } else {
                node.value = null;
                if(isLeafNode(node)) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        int idx = str.charAt(d) - 97;
        boolean hasToBeDeleted = delete(node.next[idx], str, d+1);
        if (!hasToBeDeleted) {
            return false;
        }
        node.next[idx] = null;
        if (isLeafNode(node)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isLeafNode(Node node) {
        if (node.value != null)
        {
            return false;
        }
        for (int r = 0 ; r < R ; r++) {
            if (node.next[r] != null) {
                return false;
            }
        }
        return true;
    }

    private class Node {
        private Object value;
        private Node[] next = new Node[R];
    }

    public static void main(String[] args) {
        RWayTrie rwt = new RWayTrie();
        rwt.put("anuj", 1);
        rwt.put("palak", "2");
        System.out.println(rwt.get("anuj"));
        System.out.println(rwt.get("anuja"));
        System.out.println(rwt.get("anu"));
        System.out.println(rwt.get("palak"));
        rwt.put("an","qwe");
//        rwt.delete("anuja");
        rwt.delete("anuj");
        rwt.get("anuj");
        System.out.println(rwt.get("an"));
    }

}
