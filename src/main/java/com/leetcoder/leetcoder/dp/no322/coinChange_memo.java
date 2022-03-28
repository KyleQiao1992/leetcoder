package com.leetcoder.leetcoder.dp.no322;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 3:19 下午 2022/2/11
 **/
public class coinChange_memo {
    private Map<Integer, Integer> memoMap = new HashMap<>();

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
        if (memoMap.containsKey(amount)) {
            return memoMap.get(amount);
        }

        Integer res = Integer.MAX_VALUE;
        for (Integer coin : coins) {
            Integer subProblem = dp(coins, amount - coin);
            if (subProblem == -1) {
                continue;
            }
            res = Math.min(res, subProblem + 1);
        }
        memoMap.put(amount, res == Integer.MAX_VALUE ? -1 : res);

        return memoMap.get(amount);
    }
}
