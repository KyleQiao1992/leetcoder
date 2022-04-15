package com.leetcoder.leetcoder.str.no58;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 4:13 下午 2022/4/5
 **/
public class lengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int res = 0;
        if (s == null) {
            return res;
        }
        String[] strList = s.split(" ");
        for (int i = strList.length - 1; i >= 0; i--) {
            if (!strList[i].contains(" ")) {
                res = strList[i].length();
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "a";
        lengthOfLastWord lengthOfLastWord = new lengthOfLastWord();
        lengthOfLastWord.lengthOfLastWord(s);
    }
}
