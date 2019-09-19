package com.InterviewProblems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Peak6_Kangaroo_Words {

    public static int findKangarooScore(List<String> words, List<String> wordsToSynonyms, List<String> wordsToAntonyms) {

        Map<String, List<String>> synonymsMap = new HashMap<>();

        Map<String, List<String>> antonymsMap = new HashMap<>();

        for (String a : wordsToSynonyms) {
            String key = a.split(":")[0];
            String values = a.split(":")[1];
            synonymsMap.put(key, Arrays.asList(values.split(",")));
        }

        for (String a : wordsToAntonyms) {
            String key = a.split(":")[0];
            String values = a.split(":")[1];
            antonymsMap.put(key, Arrays.asList(values.split(",")));
        }

        int count = 0;

        for (String word : words) {
            List<String> synonyms = synonymsMap.get(word);
            for (int i = 0 ; i < synonyms.size() ; i++) {
                if (isSubSequence(synonyms.get(i).toCharArray(), word.toCharArray(), synonyms.get(i).length(), word.length())) {
                    count++;
                }
            }

            List<String> antonyms = antonymsMap.get(word);
            for (int i = 0 ; i < antonyms.size() ; i++) {
                if (isSubSequence(antonyms.get(i).toCharArray(), word.toCharArray(), antonyms.get(i).length(), word.length())) {
                    count--;
                }
            }
        }
        return count;
    }

    static boolean isSubSequence(char str1[], char str2[], int m, int n)
    {
        int j = 0;
        for (int i=0; i<n&&j<m; i++)
            if (str1[j] == str2[i])
                j++;

        return (j==m);
    }

    public static void main(String[] args) {
        Peak6_Kangaroo_Words pkw = new Peak6_Kangaroo_Words();
        pkw.findKangarooScore(Arrays.asList("curtail","scion","barren"),Arrays.asList("curtail:ASd"),Arrays.asList(""));
    }

}
