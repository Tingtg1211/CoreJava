package com.algorithm.qiuzhao2020.LeetCode.twoPointers;


import java.util.List;


/**
 * 题目描述：删除 s 中的一些字符，使得它构成字符串列表 d 中的一个字符串，找出能构成的最长字符串。
 * 如果有多个相同长度的结果，返回字典序的最小字符串。
 */
public class Solution_findLongestWord {
    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for(String target : d) {
            int l1 = longestWord.length();
            int l2 = target.length();
            // 前面的字符串按字典顺序小于后面的字符串 则compareTo小于0
            if(l1 > l2 || (l1 == l2 && longestWord.compareTo(target) < 0))
                continue;

            if (isSubStr(s, target)) {
                longestWord = target;
            }
        }

        return longestWord;

    }

    public boolean isSubStr(String s, String target) {
        int i = 0;
        int j = 0;
        while (i < s.length() && j < target.length()) {
            if(s.charAt(i) == target.charAt(j))
                j ++;
            i ++;
        }
        return j == target.length(); // 判断是否比较到target最后退出的循环

    }

}
