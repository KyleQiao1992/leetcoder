package com.leetcoder.leetcoder.str.no125;

import java.util.Arrays;
import java.util.List;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 2:04 下午 2022/4/20
 **/
public class isPalindrome {

    private static final List<String> VALID_LIST = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z");


    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        char[] sCharList = s.toCharArray();
        int lIndex = 0;
        int rIndex = sCharList.length - 1;

        while (lIndex <= rIndex) {
            if (!VALID_LIST.contains(String.valueOf(sCharList[lIndex]))) {
                lIndex++;
                continue;
            }
            if (!VALID_LIST.contains(String.valueOf(sCharList[rIndex]))) {
                rIndex--;
                continue;
            }

            if (!String.valueOf(sCharList[lIndex]).equalsIgnoreCase(String.valueOf(sCharList[rIndex]))) {
                return false;
            }
            lIndex++;
            rIndex--;
        }
        return true;
    }

    public static void main(String[] args) {
        isPalindrome f = new isPalindrome();
        String test = "OP";
        f.isPalindrome(test);
    }
}
