package com.leetcoder.leetcoder.str.no942;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 11:00 上午 2022/5/9
 **/
public class Solution1 {

    public int[] diStringMatch(String s) {
        int n = s.length(), lo = 0, hi = n;
        int[] perm = new int[n + 1];

        for (int i = 0; i < n; ++i) {
            perm[i] = s.charAt(i) == 'I' ? lo++ : hi--;
        }
        perm[n] = lo; // 最后剩下一个数，此时 lo == hi
        return perm;
    }
}
