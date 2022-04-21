package com.leetcoder.leetcoder.dp.no80;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 7:24 下午 2022/4/20
 **/
public class climbStairs {

    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        climbStairs f = new climbStairs();
        f.climbStairs(3);
    }
}
