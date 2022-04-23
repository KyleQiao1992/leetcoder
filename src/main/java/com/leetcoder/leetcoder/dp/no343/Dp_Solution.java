package com.leetcoder.leetcoder.dp.no343;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 8:26 下午 2022/4/22
 **/
public class Dp_Solution {
    public int integerBreak(int n) {
        if (n < 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = max3(dp[i], j * (i - j), j * dp[i - j]);
            }
        }
        return dp[n];
    }

    private int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        Dp_Solution f = new Dp_Solution();
        f.integerBreak(4);
    }
}
