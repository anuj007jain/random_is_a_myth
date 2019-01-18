package com.InterviewProblems;

public class Lending_Home_Longest_Palindrome {

    private static String longestPalindrome (String input) {
        String strippedInput = stripInput(input);
        String solution1 = lps(strippedInput);
        StringBuilder sol = new StringBuilder();
        //String solution2 = lcs(strippedInput, new StringBuilder(strippedInput).reverse().toString());
        boolean flag = false;
        if(solution1 == null) {
            return null;
        }
        int j = 0;
        for (int i = 0 ; i < input.length() ; i++) {
            if (input.charAt(i) == solution1.charAt(j)) {
                flag = true;
                sol.append(input.charAt(i));
                j++;
            } else if (flag && input.charAt(i) == ' ') {
                sol.append(" ");
            } else {
                flag = false;
                sol = new StringBuilder();
            }
        }
        return sol.toString();
    }

    private static String lps(String str) {
        int size = str.length();   // get length of input string

        boolean matrix[][] = new boolean[size][size];

        //initial cases
        int maxLength = 1;
        for (int i = 0; i < size; ++i)
            matrix[i][i] = true;

        int start = 0;
        for (int i = 0; i < size - 1; ++i) {
            if (Character.toLowerCase(str.charAt(i)) == Character.toLowerCase(str.charAt(i + 1))) {
                matrix[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        for (int k = 3; k <= size; ++k) {
            for (int i = 0; i < size - k + 1; ++i)
            {
                int j = i + k - 1;
                if (matrix[i + 1][j - 1] && Character.toLowerCase(str.charAt(i)) ==
                        Character.toLowerCase(str.charAt(j))) {
                    matrix[i][j] = true;

                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }
        if(maxLength == 1) {
            return null;
        }
        return str.substring(start, start+maxLength);

    }

    /*private static String lcs(String str1, String str2) {
        StringBuilder solution = new StringBuilder();
        int[][] matrix = new int[str1.length()+1][str2.length()+1];
        //base conditions
        for (int i = 1 ; i < str1.length() + 1 ; i++) {
            for (int j = 1 ; j < str2.length() + 1 ; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    matrix[i][j] = matrix[i-1][j-1]+1;
                } else {
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
                }
            }
        }

        int i = str1.length();
        int j = str2.length();
        while (i > 0) {
            if (matrix[i][j] == matrix[i-1][j]) {
                i--;
            } else if (matrix[i][j] == matrix[i][j-1]) {
                j--;
            } else {
                solution.append(str1.charAt(i-1));
                i--;
                j--;
            }
        }
        return solution.toString();
    }*/

    /*private static void output(int[][] matrix) {
        for (int i = 0 ; i < matrix.length ; i++) {
            for (int j = 0 ; j < matrix[0].length ; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }*/

    private static String stripInput(String input) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] strings = input.split(" ");
        for (String string : strings) {
            stringBuilder.append(string);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Lending_Home_Longest_Palindrome lhlp = new Lending_Home_Longest_Palindrome();
        System.out.println(lhlp.longestPalindrome("Was it a cat I saw"));
    }

}
