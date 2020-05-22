package com.Algorithms_2_Coursera.Week3;

import java.util.Arrays;

public class ThreeWayRadixQuickSort {

    private void sort(String[] strings) {
        sort(strings, 0, strings.length - 1, 0);
    }

    private void sort(String[] strings, int lo, int hi, int d) {
        if (lo >= hi) {
            return;
        }
        int pivot = charAt(strings[lo], d);
        int i = lo + 1;
        int lt = lo;
        int gt = hi;
        while (i <= gt) {
            if (pivot > charAt(strings[i], d)) {
                swap(strings, lt++, i++);
            }
            else if (pivot < charAt(strings[i], d)) {
                swap(strings, i, gt--);
            }
            else {
                i++;
            }
        }
        sort(strings, lo, lt-1, d);
        if (pivot >= 0) {
            sort(strings, lt, gt, d+1);
        }
        sort(strings, gt+1, hi, d);
    }

    private void swap(String[] strings, int i, int j) {
        String temp = strings[i];
        strings[i] = strings[j];
        strings[j] = temp;
    }

    private int charAt(String string, int d) {
        if (d < string.length()) {
            return string.charAt(d) - 65;
        }
        return -1;
    }

    public static void main(String[] args) {
        ThreeWayRadixQuickSort twrqs = new ThreeWayRadixQuickSort();
        String[] strings = new String[]{"TANUJ", "TPALAK", "MRIGANK", "AYUSHI", "AYUSH", "SONALI", "TANUJA", "TAN", "ANUJ", "PALAKU"};
        twrqs.sort(strings);
        System.out.println(Arrays.toString(strings));
    }

}
