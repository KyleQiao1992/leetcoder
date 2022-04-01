package com.leetcoder.leetcoder.others.no693;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 4:55 下午 2022/3/28
 **/
public class hasAlternatingBits {

    public boolean hasAlternatingBits(int n) {
        int pre = n % 2;
        n = n / 2;
        while (n != 0) {
            if (pre == n % 2) {
                return false;
            }
            pre = n % 2;
            n = n / 2;
        }
        return Boolean.TRUE;
    }

    public static void main(String[] args) {
        hasAlternatingBits hasAlternatingBits = new hasAlternatingBits();
        hasAlternatingBits.hasAlternatingBits(7);
    }
}
