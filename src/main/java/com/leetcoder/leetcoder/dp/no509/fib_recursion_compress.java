package com.leetcoder.leetcoder.dp.no509;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 5:27 下午 2022/2/10
 **/
public class fib_recursion_compress {

    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int pre = 0;
        int cur = 1;
        for (int i = 2; i <= n; i++) {
            int sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return cur;
    }
}
