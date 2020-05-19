package com.Algorithms_2_Coursera.Week3;

import java.util.Arrays;

public class MSDRadixSort {

    private static void sort (String[] strings) {

        sortInternal(strings, 0, strings.length - 1, 0);

    }

    private static void sortInternal(String[] strings, int lo, int hi, int d) {

        int R = 26;
        int[] count = new int[R+2]; // +1 for -1 (unequal strings) and +1 for standard Radix sort

        if (lo < hi) {
            for (int i = lo ; i <= hi ; i++) {
                count[charAt(strings[i], d)]++;
            }
            for (int i = 1 ; i < R+2 ; i++) {
                count[i] += count[i-1];
            }
            String[] aux = new String[hi - lo + 1];

            for (int i = lo ; i <= hi ; i++) {
                aux[count[charAt(strings[i], d) - 1]++] = strings[i];
            }

            for (int i = lo ; i <= hi ; i++) {
                strings[i] = aux[i-lo];
            }

            for (int r = 0 ; r < R ; r++) {
                sortInternal(strings, lo + count[r], lo + count[r+1] - 1, d+1);
            }
        }
    }

    private static int charAt(String string, int d) {
        if (d < string.length()) {
            return string.charAt(d) - 63;
        }
        return 1;
    }

    public static void main(String[] args) {
        MSDRadixSort msdrs = new MSDRadixSort();
        String[] strings = new String[]{"TANUJ", "TPALAK", "MRIGANK", "AYUSHI", "AYUSH", "SONALI", "TANUJA", "TAN", "ANUJ", "PALAKU"};
        msdrs.sort(strings);
        System.out.println(Arrays.toString(strings));
    }

}
