package com.LeetCode;

public class LC_0115_Distinct_Subsequences {

    int count = 0;

    //bahgbag bag
    /*
    0bahgbag
    01111111
   b01111222
   a00111133
   g00001114
     */
    public int numDistinct(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[][] dp = new int[n+1][m+1];

        for (int i = 0; i < n+1; i++) {
            dp[i][0] = 1;
        }

        for (int j = 1; j < m+1; j++) {
            dp[0][j] = 0;
        }

        for (int j = 1; j < m+1; j++) {
            for (int i = 1; i < n+1; i++) {
                dp[i][j] = dp[i-1][j];
                if (s.charAt(i-1) == t.charAt(j-1)) {
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }

        return dp[n][m];

    }

    public int numDistinctRecursion(String s, String t) {
        numDistinctInternal("", s, t, 0);
        return count;
    }

    private void numDistinctInternal(String str, String s, String t, int start) {
        if (str.length() == t.length() && str.equals(t)) {
            count++;
            return;
        }
        for (int i = start ; i < s.length() ; i++) {
            String newStr = str + s.charAt(i);
            if (!newStr.equals(t.substring(0,newStr.length()))) {
                continue;
            }
            numDistinctInternal(newStr, s, t, i+1);
        }
    }

    public static void main(String[] args) {
        LC_0115_Distinct_Subsequences lc_115_ds = new LC_0115_Distinct_Subsequences();
        System.out.println(lc_115_ds.numDistinct("bahgbag", "bag"));
        System.out.println(lc_115_ds.numDistinct("aabdbaabeeadcbbdedacbbeecbabebaeeecaeabaedadcbdbcdaabebdadbbaeabdadeaabbabbecebbebcaddaacccebeaeedababedeacdeaaaeeaecbe","bddabdcae"));
    }

}
