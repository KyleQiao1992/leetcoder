package com.leetcoder.leetcoder.dp.no931;

import java.util.Arrays;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 8:29 下午 2022/3/29
 **/
public class minFallingPathSum_recursion {
    // 备忘录
    private int[][] memo;

    int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int res = Integer.MAX_VALUE;
        // 备忘录里的值初始化为 66666
        memo = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], 66666);
        }
        // 终点可能在 matrix[n-1] 的任意一列
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp(matrix, n - 1, j));
        }
        return res;
    }

    int dp(int[][] matrix, int i, int j) {
        // 1、索引合法性检查
        if (i < 0 || j < 0 ||
                i >= matrix.length ||
                j >= matrix[0].length) {

            return 99999;
        }
        // 2、base case
        if (i == 0) {
            return matrix[0][j];
        }
        // 3、查找备忘录，防止重复计算
        if (memo[i][j] != 66666) {
            return memo[i][j];
        }
        // 进行状态转移
        memo[i][j] = matrix[i][j] + min(
                dp(matrix, i - 1, j),
                dp(matrix, i - 1, j - 1),
                dp(matrix, i - 1, j + 1)
        );
        return memo[i][j];
    }

    int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static void main(String[] args) {
        int[][] a = {
                {2, 1, 3},
                {6, 5, 4},
                {7, 8, 9}};
        minFallingPathSum_recursion minFallingPathSum_recursion = new minFallingPathSum_recursion();
        minFallingPathSum_recursion.minFallingPathSum(a);
    }
}

