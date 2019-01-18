package com.LeetCode;

public class LC_010_Regular_Expression_Matching {

    public boolean isMatch(String s, String p) {

        int i = 0, j = 0;

        while (i < s.length()) {

            if(j >= p.length()) {
                return false;
            }

            //case 1 : both matches
            if (s.charAt(i) == p.charAt(j)) {
                if (j+1 < p.length() && p.charAt(j+1) == '*') {
                    j++;
                    continue;
                }
                i++;
                j++;
                continue;
            }

            //case 2 : special characters in p
            if (p.charAt(j) == '.') {
                if(j+1 < p.length() && p.charAt(j+1) == '*') {
                    j++;
                    continue;
                }
                i++;
                j++;
                continue;
            }
            if (p.charAt(j) == '*') {
                int start = i; // to consider the recursive case with 0 repetitions
                while (i <= s.length()) {
                    if (start != i && s.charAt(i-1) != p.charAt(j-1) && p.charAt(j-1) != '.') {
                        return false;
                    }
                    if (isMatch(s.substring(i), p.substring(j+1))) {
                        return true;
                    }
                    i++;
                }
            }
            if(j+1 < p.length() && p.charAt(j+1) == '*') {
                j+=2;
                continue;
            }
            return false;
        }
        while (j < p.length()) {
            if (j+1 < p.length() && p.charAt(j+1) == '*') {
                j+=2;
            } else {
                return false;
            }
        }
        return true;

    }

    public boolean isMatchDP(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*' && j >= 2) {
                dp[0][j] = dp[0][j - 2];
            }
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*' && j >= 2) {
                    if (p.charAt(j - 2) == '.' || p.charAt(j - 2) == s.charAt(i - 1)) {
                        // zero match, one match and multiple matches.
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        LC_010_Regular_Expression_Matching lc_010_rem = new LC_010_Regular_Expression_Matching();
        System.out.println(lc_010_rem.isMatch("aa","a*"));
    }

}
