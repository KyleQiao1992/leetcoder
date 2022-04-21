package com.leetcoder.leetcoder.str.no824;


import java.util.Arrays;
import java.util.List;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 4:57 下午 2022/4/21
 **/
public class toGoatLatin {

    private static final List<Character> VOWEL_LIST = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public String toGoatLatin(String sentence) {
        if (sentence == null || sentence.length() == 0) {
            return sentence;
        }
        String[] sentenceList = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        Integer index = 1;
        int lastWordIndex = sentenceList.length - 1;
        for (int i = 0; i <= lastWordIndex; i++) {
            String word = sentenceList[i];
            if (isVoWel(word)) {
                sb.append(vowelChange(word, index));
                if (i < lastWordIndex) {
                    sb.append(" ");
                }
                index++;
                continue;
            }
            sb.append(consonantChange(word, index));
            if (i < lastWordIndex) {
                sb.append(" ");
            }
            index++;
        }
        return sb.toString();
    }

    private Boolean isVoWel(String word) {
        if (word == null || word.length() == 0) {
            return null;
        }
        char c = word.toCharArray()[0];
        return VOWEL_LIST.contains(c);
    }

    private StringBuilder vowelChange(String word, Integer index) {
        StringBuilder sb = new StringBuilder();
        sb.append(word);
        sb.append("ma");
        appendAWithIndex(sb, index);
        return sb;
    }

    private StringBuilder consonantChange(String word, Integer index) {
        String firstChar = word.substring(0, 1);
        word = word.substring(1, word.length());
        StringBuilder sb = new StringBuilder();
        sb.append(word);
        sb.append(firstChar);
        sb.append("ma");
        appendAWithIndex(sb, index);
        return sb;
    }

    private StringBuilder appendAWithIndex(StringBuilder sb, Integer index) {
        for (int i = 0; i < index; i++) {
            sb.append('a');
        }
        return sb;
    }

    public static void main(String[] args) {
        toGoatLatin f = new toGoatLatin();
        String s = "I speak Goat Latin";
        f.toGoatLatin(s);
    }
}
