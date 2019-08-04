package com.LeetCode;

//https://leetcode.com/problems/count-numbers-with-unique-digits/
public class LC_0357_Count_Numbers_With_Unique_Digits {

    /**
     * Logic : break problems into subproblems.
     * eg. n = 3
     * consider 3 digit numbers initially (ie exclude 0 for hundred's position)
     * then consider 2 digit numbers and so on till n = 1
     * add n = 10 for 1 digit numbers (initial case)
     * @param n
     * @return
     */
    public int countNumbersWithUniqueDigits(int n) {

        // for n == 0
        if(n == 0) {
            return 1;
        }

        // for n = 1
        int solution = 10;

        while(n > 1) {
            int internalSolution = 9;
            for (int i = 1 ; i < n ; i++) {
                internalSolution *= 9-(i-1);
            }
            solution += internalSolution;
            n--;
        }
        return solution;
    }

    public static void main(String[] args) {
        LC_0357_Count_Numbers_With_Unique_Digits lc_357_cnwud = new LC_0357_Count_Numbers_With_Unique_Digits();
        System.out.println(lc_357_cnwud.countNumbersWithUniqueDigits(5));
    }
}
