package com.InterviewProblems;

import java.util.ArrayList;
import java.util.List;

public class Twitter_No_Pairs_Allowed {

    public static List<Integer> minimalOperations(List<String> words) {

        List<Integer> solution = new ArrayList<>();
        for(String word : words) {
            int count = 0;
            for(int i = 1 ; i < word.length() ; i++) {
                if (word.charAt(i) == word.charAt(i-1)) {
                    count++;
                    i++;
                }
            }
            solution.add(count);
        }
        return solution;
    }

    public static void main(String[] args) {
        Twitter_No_Pairs_Allowed tnpa = new Twitter_No_Pairs_Allowed();
        List<String> words = new ArrayList<>();
        words.add("ab");
        words.add("aab");
        words.add("abb");
        words.add("abab");
        words.add("abaaaba");
        System.out.println(tnpa.minimalOperations(words));
    }

}
