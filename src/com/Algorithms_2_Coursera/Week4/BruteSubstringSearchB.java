package com.Algorithms_2_Coursera.Week4;

public class BruteSubstringSearchB {

    private int substringSearch(String text, String pattern) {

        int N = text.length();
        int M = pattern.length();
        int i, j;

        for (i = 0, j = 0 ; i < N && j < M; i++) {
            if (text.charAt(i) == pattern.charAt(j)) {
                j++;
            } else {
                i -= j; //explicit backup
                j = 0;
            }
        }
        if (j == M) {
            return i-j;
        }
        return N;
    }

    public static void main(String[] args) {
        BruteSubstringSearchB bssb = new BruteSubstringSearchB();
        String text = "abdsasbasdawqwe";
        String pattern = "awqw";
        System.out.println(bssb.substringSearch(text, pattern));
    }

}
