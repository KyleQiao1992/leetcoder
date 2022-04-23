package com.leetcoder.leetcoder.others.no396;


import java.util.Arrays;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 2:17 下午 2022/4/22
 **/
public class maxRotateFunction {


    public int maxRotateFunction(int[] nums) {
        //思路:规律推导
        int sum = Arrays.stream(nums).sum();
        int F = 0;
        int len = nums.length;
        //求出F(0)
        for (int i = 0; i < len; i++) {
            F += i * nums[i];
        }
        int ans = F;
        //求出F(k)
        for (int i = len - 1; i > 0; i--) {
            F = F + sum - len * nums[i];
            ans = Math.max(ans, F);
        }
        return ans;
    }

}
