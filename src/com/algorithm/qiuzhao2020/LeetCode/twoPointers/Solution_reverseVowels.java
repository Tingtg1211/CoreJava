package com.algorithm.qiuzhao2020.LeetCode.twoPointers;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 题目：反转字符串中的元音字符
 *
 * Given s = "leetcode", return "leotcede".
 */
public class Solution_reverseVowels {
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];

        while (i < j) {
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if(!vowels.contains(ci)) {
                result[i ++] = ci;
            }else if(!vowels.contains(cj)){
                result[j --] = cj;
            }else {
                result[i ++] = cj;
                result[j --] = ci;
            }

        }
        return new String(result);

    }
}
