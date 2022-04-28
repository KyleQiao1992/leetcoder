package com.leetcoder.leetcoder.hash.no202;

import java.util.HashSet;
import java.util.Set;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 7:11 下午 2022/4/27
 **/
public class Solution {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();


        while (true) {
            int tmp = 0;
            while (n != 0) {
                int remainder = n % 10;
                tmp += remainder * remainder;
                n = n / 10;
            }

            n = tmp;
            if (n == 1) {
                return true;
            }
            if (set.contains(n)) {
                return false;
            }
            set.add(n);
        }
    }

    public static void main(String[] args) {
        Solution f = new Solution();
        boolean res1 = f.isHappy(19);
        boolean res2 = f.isHappy(2);

    }
}
