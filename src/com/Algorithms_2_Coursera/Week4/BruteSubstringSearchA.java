package com.Algorithms_2_Coursera.Week4;

public class BruteSubstringSearchA {

    //complexity O(MN) when text = AAAAAAB pattern = AAB
    private static int substringSearch(String text, String pattern) {
        int N = text.length();
        int M = pattern.length();
        for (int i = 0 ; i <= N - M ; i++) {
            int j;
            for (j = 0 ; j < M ; j++) {
                if (text.charAt(i+j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == M) {
                return i;
            }
        }
        return N;
    }

    public static void main(String[] args) {
        BruteSubstringSearchA bssa = new BruteSubstringSearchA();
        String text = "abdsasbasdawqwe";
        String pattern = "awqw";
        System.out.println(bssa.substringSearch(text, pattern));
    }

}
