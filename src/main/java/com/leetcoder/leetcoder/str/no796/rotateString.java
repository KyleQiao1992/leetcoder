package com.leetcoder.leetcoder.str.no796;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 2:45 下午 2022/4/7
 **/
public class rotateString {

    public boolean rotateString(String s, String goal) {
        if (s == null && goal == null) {
            return true;
        }
        if (s == null || goal == null || s.length() != goal.length()) {
            return false;
        }
        Queue<String> queue = new LinkedList<String>();
        char[] sList = s.toCharArray();
        for (char sChar : sList) {
            queue.add(String.valueOf(sChar));
        }
        for (int i = 0; i < s.length(); i++) {
            StringBuilder moveStr = new StringBuilder();
            for (String str : queue) {
                moveStr.append(str);
            }
            if (moveStr.toString().equals(goal)) {
                return true;
            }
            String topElement = queue.poll();
            queue.add(topElement);
        }
        return false;
    }

    public static void main(String[] args) {
        rotateString rotateString = new rotateString();
        Boolean res1 = rotateString.rotateString("abcde", "cdeab");
        Boolean res2 = rotateString.rotateString("abcde", "abced");
    }
}
