package com.leetcoder.leetcoder.dp.no300;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 7:23 下午 2022/3/20
 **/
public class lengthOfLIS_dp {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            System.out.println("i=" + i);
            for (int j = 0; j < i; j++) {
                System.out.println("j=" + j);
                System.out.println("num[i]=" + nums[i] + ",num[j]=" + nums[j]);
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    System.out.println("dp[]=" + Arrays.stream(dp).boxed().collect(Collectors.toList()) + "\n");
                }
            }
        }

        int res = 0;
        for (int num : dp) {
            res = Math.max(res, num);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 4, 2, 3};
        lengthOfLIS_dp lengthOfLIS_dp = new lengthOfLIS_dp();
        lengthOfLIS_dp.lengthOfLIS(nums);
    }
}
