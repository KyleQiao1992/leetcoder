package com.leetcoder.leetcoder.hash.no290;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 9:41 下午 2022/4/28
 **/
public class Solution {

    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> patternMap = new HashMap<>();
        char[] patternList = pattern.toCharArray();
        String[] strs = s.split(" ");

        if (patternList.length != strs.length) {
            return false;
        }

        for (int i = 0; i < patternList.length; i++) {
            char patterChar = patternList[i];
            String str = strs[i];

            if (!patternMap.containsKey(patterChar)) {
                patternMap.put(patterChar, str);
            } else {
                if (!patternMap.get(patterChar).equals(str)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution f = new Solution();
        f.wordPattern("abba", "dog dog dog dog");
    }
}
