package com.leetcoder.leetcoder.dp.no300;

import java.util.Arrays;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 7:23 下午 2022/3/20
 **/
public class lengthOfLIS_dp {
    //memo[i] 表示以为起点的最长递增子序列的长度
    public int[] dp;

    public int lengthOfLIS(int[] nums) {
        int listLength = nums.length;
        dp = new int[listLength + 1];
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < listLength; i++) {
            res = Math.max(dp[i], res);
        }
        return res;
    }
}
