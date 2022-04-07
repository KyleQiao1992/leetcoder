package com.leetcoder.leetcoder.search.binarySearch.no35;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 7:57 下午 2022/4/6
 **/
public class searchInsert {

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (nums[len - 1] < target) {
            return len;
        }

        int left = 0;
        int right = len - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
