package com.leetcoder.leetcoder.others.no398;

import java.util.Random;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 8:40 下午 2022/4/25
 **/
class Solution {
    private int[] nums;
    private Random random;

    public Solution(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {
        int count = 0, res = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                continue;
            }
            count++;
            if (random.nextInt(count) == 0) {
                res = i;
            }
        }
        return res;
    }
}
