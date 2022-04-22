package com.leetcoder.leetcoder.dp.no343;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 8:12 下午 2022/4/21
 **/
public class Recursion_Solution {

    public int integerBreak(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }

        int res = 1;
        for (int i = 1; i < n-1; i++) {
            res = Math.max(res, i * (n - i));
            res = Math.max(res, i * integerBreak(n - i));
        }
        return res;
    }

    public static void main(String[] args) {
        Recursion_Solution f = new Recursion_Solution();
        f.integerBreak(5);
    }
}
