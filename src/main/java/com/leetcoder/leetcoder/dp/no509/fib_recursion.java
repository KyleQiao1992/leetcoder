package com.leetcoder.leetcoder.dp.no509;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 3:14 下午 2022/2/10
 **/
public class fib_recursion {

    public int fib(int n) {
        Map<Integer, Integer> memo = new HashMap<>();
        return dp(memo, n);
    }

    private int dp(Map<Integer, Integer> memo, int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        if (memo.containsKey(n)) {
            return memo.get(n);
        }
        memo.put(n, dp(memo, n - 1) + dp(memo, n - 2));
        return memo.get(n);
    }
}
