package com.GeeksForGeeks.Tree;

public class Trie {

    public Trie() {
        root = new TrieNode();
    }

    static TrieNode root;
    static final int ALPHABET_SIZE = 26;

    static class TrieNode {
        boolean isEndOfWord;
        TrieNode[] children;

        public TrieNode() {
            isEndOfWord = false;
            children = new TrieNode[ALPHABET_SIZE];
            for (int i = 0 ; i < ALPHABET_SIZE ; i++) {
                children[i] = null;
            }
        }
    }

    static void insert(String word) {
        TrieNode trav = root;
        for (int level = 0 ; level < word.length() ; level++) {
            int index = word.charAt(level) - 'a';
            if (trav.children[index] == null) {
                trav.children[index] = new TrieNode();
            }
            trav = trav.children[index];
        }
        trav.isEndOfWord = true;
    }

    static boolean search(String word) {
        TrieNode trav = root;
        for (int level = 0 ; level < word.length() ; level++) {
            int index = word.charAt(level) - 'a';
            if (trav.children[index] == null) {
                return false;
            }
            trav = trav.children[index];
        }
        if (trav != null && trav.isEndOfWord) {
            return true;
        }
        return false;
    }

    boolean delete(String word) {
        return deleteInternal(root, word, 0, null, 0);
    }

    private boolean deleteInternal(TrieNode node, String word, int level, TrieNode parent, int parentIndex) {

        if (node == null) {
            return false;
        }

        if (word.length() == level) {
            if (node.isEndOfWord) {
                node.isEndOfWord = false;
                if (leafNode(node)) {
                    if (parent != null) {
                        parent.children[parentIndex] = null;
                    }
                }
                return true;
            }
            return false;
        }

        int index = word.charAt(level) - 'a';
        if (node.children[index] == null) {
            return false;
        }
        deleteInternal(node.children[index], word, level+1, node, index);

        if (leafNode(node) && !node.isEndOfWord) {
            if (parent != null) {
                parent.children[parentIndex] = null;
                return true;
            }
        }
        return true;

    }

    private boolean leafNode(TrieNode node) {
        for (int i = 0 ; i < ALPHABET_SIZE ; i++) {
            if (node.children[i] != null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[])
    {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        String output[] = {"Not present in trie", "Present in trie"};

        Trie trie = new Trie();
        // Construct trie
        int i;
        for (i = 0; i < keys.length ; i++)
            trie.insert(keys[i]);

        trie.delete("the");

        // Search for different keys
        if(trie.search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if(trie.search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if(trie.search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);

        if(trie.search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);


    }

}
