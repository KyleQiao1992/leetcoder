package com.leetcoder.leetcoder.array.no905;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 3:44 下午 2022/4/28
 **/
public class Solution {

    public int[] sortArrayByParity(int[] nums) {
        int[] resList = new int[nums.length];
        int lp = 0;
        int rp = nums.length - 1;

        int i = 0;
        while (lp <= rp) {
            if (isEven(nums[i])) {
                resList[lp] = nums[i];
                lp++;
            } else {
                resList[rp] = nums[i];
                rp--;
            }
            i++;
        }
        return resList;
    }

    private Boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static void main(String[] args) {
        Solution f = new Solution();
        int[] test = {3, 1, 2, 4};
        f.sortArrayByParity(test);
    }
}
