package com.LeetCode;

public class LC_338_Counting_Bits {

    public int[] countBits(int num) {

        int[] solution = new int[num+1];

        //base case
        int nextPerfectSquareOf2 = 2;
        solution[0] = 0;

        for (int i = 1 ; i <= num ; i++) {
            if (i == nextPerfectSquareOf2) {
                solution[i] = 1;
                nextPerfectSquareOf2 *= 2;
            } else {
                int previousPerfectSquareOf2 = nextPerfectSquareOf2/2;
                solution[i] = 1 + solution[i-previousPerfectSquareOf2];
            }
        }
        return solution;
    }

    public static void main(String[] args) {
        LC_338_Counting_Bits lc_338_cb = new LC_338_Counting_Bits();
        lc_338_cb.countBits(4);
    }

}
