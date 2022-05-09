package com.leetcoder.leetcoder.array.no442;

import com.leetcoder.leetcoder.array.no905.Solution;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 8:04 下午 2022/5/8
 **/
public class Solution1 {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (nums[Math.abs(num) - 1] < 0) {
                res.add(Math.abs(num));
            } else {
                nums[Math.abs(num) - 1] *= -1;
            }
        }
        return res;
    }
}
