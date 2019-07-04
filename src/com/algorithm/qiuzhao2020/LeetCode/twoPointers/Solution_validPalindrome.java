package com.algorithm.qiuzhao2020.LeetCode.twoPointers;

/**
 * 题目描述：可以删除一个字符，判断是否能构成回文字符串。
 *
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 */
public class Solution_validPalindrome {
    public boolean validPalindrome(String s) {
        for(int i = 0, j = s.length() - 1; i < j; i ++, j --) {
            if (s.charAt(i) != s.charAt(j))
                return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
        }
        return true;


    }
    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) { // 删除一个字符后走这个函数只要有一对不相等说明不是回文字符串
            if (s.charAt(i) != s.charAt(j)) return false;
            i ++;
            j --;

        }
        return true;
    }
}
