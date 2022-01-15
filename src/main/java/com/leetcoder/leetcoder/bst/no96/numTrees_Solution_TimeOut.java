package com.leetcoder.leetcoder.bst.no96;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 3:30 下午 2022/1/10
 **/
public class numTrees_Solution_TimeOut {
    int[][] memo;

    public int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return numTrees(1, n);
    }

    /* 计算闭区间 [lo, hi] 组成的 BST 个数 */
    public Integer numTrees(int low, int high) {
        if (low >= high) {
            return 1;
        }

        if (memo[low][high] != 0) {
            return memo[low][high];
        }

        int sum = 0;
        for (int i = low; i <= high; i++) {
            int left = numTrees(low, i - 1);
            int right = numTrees(i + 1, high);
            sum += left * right;
        }
        // 将结果存入备忘录
        memo[low][high] = sum;
        return sum;
    }
}
