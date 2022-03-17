package com.leetcoder.leetcoder.dp.no322;

import java.util.Arrays;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 3:19 下午 2022/2/11
 **/
public class coinChange_memo {
    int[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        Arrays.fill(memo, -2);
        return dp(coins, amount);
    }

    private int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != -2) {
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for (Integer coin : coins) {
            Integer subProblem = dp(coins, amount - coin);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, subProblem + 1);
        }
        memo[amount] = res == Integer.MAX_VALUE ? -1 : res;
        return memo[amount];
    }

    public static void main(String[] args) {
        coinChange_memo test = new coinChange_memo();
        int[] coins = new int[]{1, 2, 5};
        test.coinChange(coins, 11);
    }
}
