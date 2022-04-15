package com.leetcoder.leetcoder.str.no13;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 3:36 下午 2022/4/6
 **/
public class romanToInt {

    private static Map<String, Integer> romanIntMap = new HashMap<>();
    private static Map<String, Integer> romanIntOrderMap = new HashMap<>();

    static {
        romanIntMap.put("I", 1);
        romanIntMap.put("V", 5);
        romanIntMap.put("X", 10);
        romanIntMap.put("L", 50);
        romanIntMap.put("C", 100);
        romanIntMap.put("D", 500);
        romanIntMap.put("M", 1000);

        romanIntOrderMap.put("I", 1);
        romanIntOrderMap.put("V", 2);
        romanIntOrderMap.put("X", 3);
        romanIntOrderMap.put("L", 4);
        romanIntOrderMap.put("C", 5);
        romanIntOrderMap.put("D", 6);
        romanIntOrderMap.put("M", 7);
    }

    public int romanToInt(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        char[] sCharList = s.toCharArray();
        int res = 0;
        for (int i = 0, j = i + 1; i < sCharList.length; i++, j++) {
            if (j >= sCharList.length) {
                res += romanIntMap.get(String.valueOf(sCharList[i]));
                break;
            }

            if (romanIntOrderMap.get(String.valueOf(sCharList[i])) < romanIntOrderMap.get(String.valueOf(sCharList[j]))) {
                res += romanIntMap.get(String.valueOf(sCharList[j])) - romanIntMap.get(String.valueOf(sCharList[i]));
                i++;
                j++;
            } else {
                res += romanIntMap.get(String.valueOf(sCharList[i]));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        romanToInt romanToInt = new romanToInt();
        int a= romanToInt.romanToInt("III");
        int b= romanToInt.romanToInt("IV");
        int c= romanToInt.romanToInt("IX");
        int d= romanToInt.romanToInt("LVIII");
        int e= romanToInt.romanToInt("MCMXCIV");

    }
}