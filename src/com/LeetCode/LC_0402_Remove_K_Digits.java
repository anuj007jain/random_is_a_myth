package com.LeetCode;

import java.math.BigInteger;

public class LC_0402_Remove_K_Digits {

    public String removeKdigitsDP(String num, int k) {
        //DP table
        BigInteger[][] matrix = new BigInteger[num.length()+1][k+1];

        //base cases

        matrix[0][0] = BigInteger.ZERO;

        for(int i = 1 ; i <= num.length() ; i++) {
            matrix[i][0] = new BigInteger(num.substring(0,i));
        }

        for(int j = 1 ; j <= k ; j++) {
            matrix[0][j] = BigInteger.ZERO;
        }

        for(int i = 1 ; i <= num.length() ; i++) {
            for (int j = 1 ; j <= k ; j++) {
                BigInteger x = matrix[i-1][j].multiply(BigInteger.TEN).add(new BigInteger(num.substring(i-1,i)));
                matrix[i][j] = matrix[i-1][j-1].compareTo(x) < 0 ? matrix[i-1][j-1] : x;
            }
        }
        System.out.println(matrix[num.length()][k]);
        return String.valueOf(matrix[num.length()][k]);
    }

    public String removeKdigits(String num, int k) {

        String solution = num;
        for(int i = 0 ; i < k ; i++) {
            if(solution.length() == 0) {
                return "0";
            }
            if (solution.length() > 1 && Integer.parseInt(String.valueOf(solution.charAt(1))) == 0) {
                int j = 2;
                while (j < solution.length() && Integer.parseInt(String.valueOf(solution.charAt(j))) == 0) {
                    j++;
                }
                solution = solution.substring(j);
                if(solution.equals("")) {
                    return "0";
                }
                continue;
            }
            int delIndex = 0;
            boolean flag = true;
            for(int j = 1 ; j < solution.length() ; j++) {
                if(Integer.parseInt(String.valueOf(solution.charAt(j))) < Integer.parseInt(String.valueOf(solution.charAt(j-1)))) {
                    delIndex = j-1;
                    flag = false;
                    break;
                }
            }
            if(flag) {
                delIndex = solution.length()-1;
            }
            solution = solution.substring(0, delIndex).concat(solution.substring(delIndex+1));
            if(solution.equals("")) {
                return "0";
            }
        }
        System.out.println(solution);
        return solution;
    }

    public static void main(String[] args) {
        System.out.println(new LC_0402_Remove_K_Digits().removeKdigits("1234567890", 10));
    }

}
