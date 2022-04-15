package com.leetcoder.leetcoder.dp.no516;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 8:02 下午 2022/4/7
 **/
public class longestPalindromeSubseq {

    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; ++i) {
            dp[i][i] = 1;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        String test = "cbbd";
        longestPalindromeSubseq l = new longestPalindromeSubseq();
        l.longestPalindromeSubseq(test);
    }
}
