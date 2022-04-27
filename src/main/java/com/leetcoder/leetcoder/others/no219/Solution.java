package com.leetcoder.leetcoder.others.no219;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 2:17 下午 2022/4/27
 **/
public class Solution {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> elementMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer key = nums[i];

            if (!elementMap.containsKey(key)) {
                elementMap.put(key, i);
            } else {
                Integer lastIndex = elementMap.get(key);
                if (Math.abs(i - lastIndex) <= k) {
                    return true;
                }
                elementMap.put(key, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution f = new Solution();
        int[] nums = {1, 0, 1, 1};
        int k = 1;
        f.containsNearbyDuplicate(nums, k);
    }
}
