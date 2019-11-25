package com.InterviewProblems;

import java.util.*;

public class Robplox_The_Social_Network {

    public static void socialGraphs(List<Integer> counts) {
        TreeMap<Integer, List<Integer>> map = new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer, List<Integer>> map2 = new TreeMap<>();
        for (int i = 0 ; i < counts.size() ; i++) {
            List<Integer> list = map.getOrDefault(counts.get(i), new ArrayList<>());
            list.add(i);
            map.put(counts.get(i), list);
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Integer key = entry.getKey();
            List<Integer> list = entry.getValue();
            int i = 0;
            while (i < list.size()) {
                List<Integer> list2 = new ArrayList<>();
                for (int j = 0 ; j < key ; j++) {
                    list2.add(list.get(i++));
                }
                map2.put(list2.get(0), list2);
            }
        }
        for (Map.Entry<Integer, List<Integer>> entry : map2.entrySet()) {
            Integer key = entry.getKey();
            List<Integer> list = entry.getValue();
            for (Integer p : list) {
                System.out.print(p+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Robplox_The_Social_Network rtsn = new Robplox_The_Social_Network();
        rtsn.socialGraphs(Arrays.asList(3,3,3,3,3,1,3,3,3,3));
    }

}
