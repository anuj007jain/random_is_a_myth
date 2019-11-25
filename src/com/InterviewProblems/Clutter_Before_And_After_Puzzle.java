package com.InterviewProblems;

import java.util.*;

public class Clutter_Before_And_After_Puzzle {

    public static List<String> generate_phrases(List<String> phrases) {

        List<String> solution = new ArrayList<>();
        Map<String, List<String>> lastWordToPreviousWords = new HashMap<>();

        for (String phrase : phrases) {
            String lastWord = phrase.substring(phrase.lastIndexOf(" ")+1);
            lastWordToPreviousWords.putIfAbsent(lastWord, new ArrayList<>());
            lastWordToPreviousWords.get(lastWord).add(phrase.substring(0, phrase.lastIndexOf(" ")));
        }

        for (String phrase : phrases) {
            String firstWord = phrase.substring(0, phrase.indexOf(" "));
            if(lastWordToPreviousWords.get(firstWord) != null) {
                for (String previousWords : lastWordToPreviousWords.get(firstWord)) {
                    solution.add(previousWords + " " + phrase);
                }
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        Clutter_Before_And_After_Puzzle cbaap = new Clutter_Before_And_After_Puzzle();
        cbaap.generate_phrases(Arrays.asList("mission statement",
                "a quick bite to eat", "a chip off the old block",
                "chocolate bar", "mission impossible", "a man on a mission",
                "block party", "eat my words", "bar of soap"));
    }

}
