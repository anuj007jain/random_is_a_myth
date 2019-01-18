package com.InterviewProblems;

import java.util.*;

public class Indeed_Smart_Sale {

    public static int deleteProducts(List<Integer> ids, int m) {

        Map<Integer, Integer> map = new HashMap<>();

        for (Integer id : ids) {
            if (map.get(id) == null) {
                map.put(id, 1);
            } else {
                map.put(id, map.get(id) + 1);
            }
        }

        Set<Map.Entry<Integer, Integer>> set = map.entrySet();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(set);
        Collections.sort(list, Comparator.comparing(o -> (o.getValue())));
        for (Map.Entry<Integer, Integer> entry : list) {
            if (m >= entry.getValue()) {
                map.remove(entry.getKey());
                m -= entry.getValue();
            } else {
                break;
            }
        }
        System.out.println(map.size());
        return map.size();
    }

    public static void main(String[] args) {
        Indeed_Smart_Sale iss = new Indeed_Smart_Sale();
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(1);
        ids.add(2);
        ids.add(2);
        iss.deleteProducts(ids, 3);
    }
}
