package com.InterviewProblems;

import java.util.*;

public class Twitter_Simple_Text_Queries {

    public static void textQueries(List<String> sentences, List<String> queries) {

        Map<Set<String>, String> map = new HashMap<>();
        for (int i = 0 ; i < queries.size() ; i++) {
            StringBuilder str = new StringBuilder();
            String query = queries.get(i);
            Set<String> set1 = new HashSet<>(Arrays.asList(query.split(" ")));
            if (map.get(set1) != null) {
                System.out.println(map.get(set1));
                continue;
            }
            boolean flag = false;
            for (int j = 0 ; j < sentences.size() ; j++) {
                String sentence = sentences.get(j);
                Set<String> set2 = new HashSet<>(Arrays.asList(sentence.split(" ")));
                set2.retainAll(set1);
                if (set2.size() == set1.size()) {
                    flag = true;
                    System.out.print(j+" ");
                    str.append(j+" ");
                }
            }
            if (!flag) {
                System.out.println(-1);
                str.append(-1);
            } else {
                System.out.println();
            }
            map.put(set1, str.toString());
        }
    }

    public static void main(String[] args) {
        Twitter_Simple_Text_Queries tstq = new Twitter_Simple_Text_Queries();
        List<String> sentences = new ArrayList<>();
        sentences.add("jim likes mary");
        sentences.add("kate likes tom");
        sentences.add("tom does not like jim");
        List<String> queries = new ArrayList<>();
        queries.add("jim tom");
        queries.add("likes");
        queries.add("likes likes");
        tstq.textQueries(sentences, queries);
    }

}
