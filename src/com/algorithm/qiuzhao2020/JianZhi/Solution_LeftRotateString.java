package com.algorithm.qiuzhao2020.JianZhi;

import java.util.Random;

/**
 * 左旋转字符串
 * 字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 */
public class Solution_LeftRotateString {
    // 先将 "abc" 和 "XYZdef" 分别翻转，得到 "cbafedZYX"，
    // 然后再把整个字符串翻转得到 "XYZdefabc"。

    public String LeftRotateString(String str,int n) {
        char[] chars = str.toCharArray();
        if (chars.length < n)
            return "";
        Reverse(chars,0, n - 1);
        Reverse(chars, n, chars.length - 1);
        Reverse(chars, 0, chars.length - 1);
        return new String(chars);

    }
    private void Reverse(char[] chars, int low, int high) {
        char temp;
        while (low <= high) {
            temp = chars[low];
            chars[low] = chars[high];
            chars[high] = temp;
            low ++;
            high --;
        }

    }
}
