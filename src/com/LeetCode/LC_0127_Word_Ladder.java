package com.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC_0127_Word_Ladder {

    private static int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int wordLength = beginWord.length();
        Set<Character>[] characterDictionary = (HashSet<Character>[]) new HashSet[wordLength];
        for (int i = 0 ; i < wordLength ; i++) {
            characterDictionary[i] = new HashSet<>();
            for (String word : wordList) {
                characterDictionary[i].add(word.charAt(i));
            }
        }
        return ladderLengthInternal(new StringBuilder(beginWord), endWord, characterDictionary, wordList, 0,
                Integer.MAX_VALUE, new ArrayList<>());
    }

    private static int ladderLengthInternal(StringBuilder currentWord, String endWord, Set<Character>[] characterDictionary,
                                            List<String> wordList, Integer count, Integer minCount,
                                            List<String> transformations) {
        if (currentWord.toString().equals(endWord)) {
            return count;
        }
        StringBuilder currentWordStr = new StringBuilder(currentWord);
        for (int i = 0 ; i < currentWord.length() ; i++) {
            for (Character c : characterDictionary[i]) {
                if (c == currentWord.charAt(i)) {
                    continue;
                }
                currentWordStr.setCharAt(i, c);
                if (wordList.contains(currentWordStr.toString()) && !transformations.contains(currentWordStr.toString())) {
                    transformations.add(currentWordStr.toString());
                    int newCount = ladderLengthInternal(currentWordStr, endWord, characterDictionary, wordList,
                            count + 1, minCount, transformations);
                    //backtrack
                    transformations.remove(currentWordStr.toString());
                    if (minCount > newCount) {
                        minCount = newCount;
                    }
                }
            }
        }
        return minCount;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dog");
        wordList.add("dot");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }
}