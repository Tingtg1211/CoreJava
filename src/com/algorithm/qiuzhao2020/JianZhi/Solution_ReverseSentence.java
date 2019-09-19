package com.algorithm.qiuzhao2020.JianZhi;

/**
 * 翻转单词顺序
 * student. a am I
 * I am a student.
 */
public class Solution_ReverseSentence {
    public String ReverseSentence(String str) {
        // 1.先翻转整个句子
        // 2.再翻转每个单词
        // 3.根据空格来确定单词

        char[] chars = str.toCharArray();
        Reverse(chars, 0, chars.length - 1);
        int blank = -1;
        for(int i = 0; i < chars.length; i ++) {
            if(chars[i] == ' ') {
                int nextBlank = i;
                Reverse(chars, blank + 1, nextBlank - 1);
                blank = nextBlank;
            }
        }
        Reverse(chars, blank + 1, chars.length - 1);
        return new String(chars);


    }
    private void Reverse(char[] chars, int start, int end){
        char temp;
        while (start <= end) {
            temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start ++;
            end --;
        }

    }
}
