package com.leetcoder.leetcoder.str.no868;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 3:41 下午 2022/4/25
 **/
public class binaryGap {

    public int binaryGap(int n) {
        String binStr = Integer.toBinaryString(n);
        int lastOneIdx = n, max = 0;
        for (int i = 0; i < binStr.length(); i++) {
            if (binStr.charAt(i) == '1') {
                max = Math.max(max, i - lastOneIdx);
                lastOneIdx = i;
            }
        }
        return max;
    }

}
