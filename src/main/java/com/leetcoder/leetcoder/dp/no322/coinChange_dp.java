package com.leetcoder.leetcoder.dp.no322;

import java.util.Arrays;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 4:57 下午 2022/2/11
 **/
public class coinChange_dp {

    public int coinChange(int[] coins, int amount) {
        //dp 数组的定义：当目标金额为 i 时，至少需要 dp[i] 枚硬币凑出。
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        //外层for循环遍历所有的状态的所有值
        for (int i = 0; i < dp.length; i++) {
            //内层 for循环在求所有选择的最小值
            for (Integer coin : coins) {
                //如果子问题无解
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }
}
