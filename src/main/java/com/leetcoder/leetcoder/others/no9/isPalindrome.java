package com.leetcoder.leetcoder.others.no9;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 2:21 下午 2022/4/6
 **/
public class isPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;
        int cur = 0;
        int num = x;
        while (num != 0) {
            cur = cur * 10 + num % 10;
            num /= 10;
        }
        return cur == x;
    }


    public static void main(String[] args) {
        isPalindrome isPalindrome = new isPalindrome();
        isPalindrome.isPalindrome(10000);
    }
}
