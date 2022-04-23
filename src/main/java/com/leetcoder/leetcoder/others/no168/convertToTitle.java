package com.leetcoder.leetcoder.others.no168;

import java.util.HashMap;
import java.util.Map;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 7:36 下午 2022/4/23
 **/
public class convertToTitle {
    public static final Map<Integer, String> map = new HashMap<>();

    static {
        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");
        map.put(4, "D");
        map.put(5, "E");
        map.put(6, "F");
        map.put(7, "G");
        map.put(8, "H");
        map.put(9, "I");
        map.put(10, "J");
        map.put(11, "K");
        map.put(12, "L");
        map.put(13, "M");
        map.put(14, "N");
        map.put(15, "O");
        map.put(16, "P");
        map.put(17, "Q");
        map.put(18, "R");
        map.put(19, "S");
        map.put(20, "T");
        map.put(21, "U");
        map.put(22, "V");
        map.put(23, "W");
        map.put(24, "X");
        map.put(25, "Y");
        map.put(26, "Z");

    }


    public String convertToTitle(int columnNumber) {
        StringBuilder row = new StringBuilder();
        while (columnNumber > 0) {
            int remainder = columnNumber % 26;
            if (remainder == 0) {
                remainder = 26;
                columnNumber -= 26;
            }
            row.append(map.get(remainder));
            columnNumber /= 26;
        }
        return row.reverse().toString();
    }

    public static void main(String[] args) {
        convertToTitle f = new convertToTitle();
        String res = f.convertToTitle(701);
    }
}
