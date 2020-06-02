package com.Algorithms_2_Coursera.Week4;

public class KMPSubstringSearch {

    final private static int R = 26;

    public static void main(String[] args) {
        KMPSubstringSearch kmpss = new KMPSubstringSearch();
        String text = "abasqweqsadeqdsaababasdqwsadababaqasdababacasdq";
        String pattern = "ababac";
        System.out.println(kmpss.substringSearch(text, pattern));
    }

    private int substringSearch(String text, String pattern) {
        int[][] dfa = createDFA(pattern);
        int state = 0;
        for (int i = 0 ; i < text.length() ; i++) {
            state = dfa[text.charAt(i) - 97][state];
            if (state == dfa[0].length) {
                return i - (state - 1);
            }
        }
        return text.length();

    }

    private int[][] createDFA(String pattern) {
        int[][] dfa = new int[R][pattern.length()];
        int X = 0;

        //handle base case
        for (int r = 0 ; r < R ; r++) {
            if (pattern.charAt(0) - 97 == r) {
                dfa[r][0] = 1;
            } else {
                dfa[r][0] = 0;
            }
        }

        for (int i = 1 ; i < pattern.length() ; i++) {
            for (int r = 0 ; r < R ; r++) {
                if (pattern.charAt(i) - 97 == r) {
                    dfa[r][i] = i + 1;
                } else {
                    dfa[r][i] = dfa[r][X];
                }
            }
            X = dfa[pattern.charAt(i) - 97][X];
        }
        return dfa;
    }

}
