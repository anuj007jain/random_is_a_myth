package com.Algorithms_2_Coursera.Week3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class KeyIndexedCounting {

    public static void main(String[] args) {
        KeyIndexedCounting kic = new KeyIndexedCounting();
        String[] geneString = new String[]{"G", "A", "C", "T", "T", "A"};
        kic.sort(geneString);
    }

    private void sort(String[] arr) {
        int N = arr.length;
        int R = 4; //gene string
        int[] count = new int[R+1];
        Map<String, Integer> map = getMap();

        for (int i = 0 ; i < N ; i++) {
            count[map.get(arr[i])]++;
        }
        // 0 2 1 1 2

        for (int i = 1 ; i <= R ; i++) {
            count[i] += count[i-1];
        }
        // 0 2 3 4 6

        String[] aux = new String[N];
        for (int i = 0 ; i < N ; i++) {
            aux[count[map.get(arr[i])-1]++] = arr[i];
        }

        for (int i = 0 ; i < N ; i++) {
            arr[i] = aux[i];
        }
        System.out.println(Arrays.toString(arr));
    }

    private Map<String, Integer> getMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("C", 2);
        map.put("G", 3);
        map.put("T", 4);
        return map;
    }

}
