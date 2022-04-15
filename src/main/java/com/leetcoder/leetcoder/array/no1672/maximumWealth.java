package com.leetcoder.leetcoder.array.no1672;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 2:17 下午 2022/4/14
 **/
public class maximumWealth {

    public int maximumWealth(int[][] accounts) {
        int res = 0;
        if (accounts == null || accounts.length == 0) {
            return res;
        }
        for (int[] ints : accounts) {
            int sum = 0;
            for (int account : ints) {
                sum += account;
            }
            res = Math.max(res, sum);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] test = {{1, 2, 3}, {3, 2, 1}};
        maximumWealth f = new maximumWealth();
        f.maximumWealth(test);
    }
}
