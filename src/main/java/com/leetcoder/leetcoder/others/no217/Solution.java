package com.leetcoder.leetcoder.others.no217;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 1:51 下午 2022/4/27
 **/
public class Solution {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return !(numsSet.size() == nums.length);
    }
}
