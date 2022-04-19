package com.leetcoder.leetcoder.str.no821;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 10:35 上午 2022/4/19
 **/
public class shortestToChar {

    public int[] shortestToChar(String s, char c) {
        if (!s.contains(String.valueOf(c))) {
            return new int[0];
        }

        List<Integer> cPositionList = new ArrayList<>();
        char[] sChar = s.toCharArray();
        int[] resList = new int[sChar.length];

        for (int i = 0; i < sChar.length; i++) {
            if (sChar[i] == c) {
                cPositionList.add(i);
            }
        }

        for (int i = 0; i < sChar.length; i++) {
            int res = Integer.MAX_VALUE;
            for (int j = 0; j < cPositionList.size(); j++) {
                res = Math.min(res, Math.abs(cPositionList.get(j) - i));
            }
            resList[i] = res;
        }
        return resList;
    }

    public static void main(String[] args) {
        shortestToChar f = new shortestToChar();
        String s = "aaab";
        char c = 'b';
        f.shortestToChar(s, c);
    }
}
