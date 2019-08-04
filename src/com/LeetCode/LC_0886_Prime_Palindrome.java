package com.LeetCode;

public class LC_0886_Prime_Palindrome {
    public int primePalindrome(int N) {
        if (8 <= N && N <= 11) return 11;
        for (int x = 1; x < 100000; x++) {
            String s = Integer.toString(x), r = new StringBuilder(s).reverse().toString().substring(1);
            int y = Integer.parseInt(s + r);
            if (y >= N && isPrime(y)) return y;
        }
        return -1;
    }

    public Boolean isPrime(int x) {
        if (x < 2 || x % 2 == 0) return x == 2;
        for (int i = 3; i * i <= x; i += 2)
            if (x % i == 0) return false;
        return true;
    }

    public int primePalindrome2(int N) {
        if (N == 1) {
            return 2;
        }
        while(true) {
            if (checkPalindrome(N) && checkPrime(N)) {
                return N;
            }
            N++;
        }

    }

    boolean checkPalindrome(int N) {
        char[] number = (""+N).toCharArray();
        int i = 0, j = number.length -1;
        while (i<=j) {
            if (number[i] != number[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    boolean checkPrime(int N) {
            for (int i = 2 ; i <= Math.sqrt(N) ; i++) {
                if (N % i == 0) {
                    return false;
                }
            }
            return true;
    }

    public static void main(String[] args) {
        LC_0886_Prime_Palindrome lc_886_pp = new LC_0886_Prime_Palindrome();
        System.out.println(lc_886_pp.primePalindrome(998990));
    }

}
