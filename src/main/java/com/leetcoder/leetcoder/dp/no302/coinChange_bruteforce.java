package com.leetcoder.leetcoder.dp.no302;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 2:12 下午 2022/2/11
 **/
public class coinChange_bruteforce {

    public int coinChange(int[] coins, int amount) {
        return dp(coins, amount);
    }

    private int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        Integer res = Integer.MAX_VALUE;
        for (Integer coin : coins) {
            int subProblem = dp(coins, amount - coin);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, subProblem + 1);
        }
        return Integer.MAX_VALUE == res ? -1 : res;
    }
}
