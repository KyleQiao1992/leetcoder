package com.leetcoder.leetcoder.dp.no53;

import java.util.Arrays;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 8:43 下午 2022/4/4
 **/
public class maxSubArray {

    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
        }

        int res = Integer.MIN_VALUE;
        for (int i : dp) {
            res = Math.max(i, res);
        }
        return res;
    }

}
