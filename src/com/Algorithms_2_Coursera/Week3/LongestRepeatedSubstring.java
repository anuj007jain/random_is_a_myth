package com.Algorithms_2_Coursera.Week3;

public class LongestRepeatedSubstring {

    public String lrs (String s) {
        String lrs = "";
        String[] suffixes = new String[s.length()];
        for (int i = 0 ; i < s.length() ; i++) {
            suffixes[i] = s.substring(i);
        }
        sort(suffixes);
        for (int i = 0 ; i < suffixes.length - 1 ; i++) {
            String lcp = lcp(suffixes[i], suffixes[i+1]);
            if (lcp.length() > lrs.length()) {
                lrs = lcp;
            }
        }
        return lrs;
    }

    private String lcp(String a, String b) {
        int i = 0;
        while (a.length() > i && b.length() > i && a.charAt(i) == b.charAt(i)) {
            i++;
        }
        return a.substring(0, i);
    }

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
            if (charAt(strings[i], d) < pivot) {
                swap(strings, i++, lt++);
            }
            else if (charAt(strings[i], d) > pivot) {
                swap(strings, i, gt--);
            } else {
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
            return string.charAt(d) - 97;
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "aacaagtttacaagc";
        LongestRepeatedSubstring lrs = new LongestRepeatedSubstring();
        System.out.println(lrs.lrs(s));
    }

}
