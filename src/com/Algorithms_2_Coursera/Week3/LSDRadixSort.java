package com.Algorithms_2_Coursera.Week3;

import java.util.Arrays;

public class LSDRadixSort {

    private static void sort(String[] strings) {

        int W = strings[0].length();
        int R = 27; // 26 + 1
        int N = strings.length;

        for (int i = W-1 ; i >= 0 ; i--) {
            int[] count = new int[R];
            for (int j = 0 ; j < N ; j++) {
                count[strings[j].charAt(i) - 64]++;
            }

            for (int j = 1 ; j < R ; j++) {
                count[j] += count[j-1];
            }

            String[] aux = new String[N];
            for (int j = 0 ; j < N ; j++) {
                aux[count[strings[j].charAt(i) - 65]++] = strings[j];
            }

            for (int j = 0 ; j < N ; j++) {
                strings[j] = aux[j];
            }
        }

    }

    public static void main(String[] args) {
        LSDRadixSort lsdrs = new LSDRadixSort();
        String[] strings = new String[]{"ABCD", "ABCW", "ASDQ", "WQSS", "WADS", "QWSA", "ZASD", "SAAA"};
        lsdrs.sort(strings);
        System.out.println(Arrays.toString(strings));
    }

}
