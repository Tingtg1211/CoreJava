package com.algorithm.qiuzhao2020.JianZhi;

/**
 * 题目描述:
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */

//        当模式中的第二个字符不是“*”时：
//        1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
//        2、如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。
//
//        而当模式中的第二个字符是“*”时：
//        如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。
//        如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
//        1、模式后移2字符，相当于x*被忽略；
//        2、字符串后移1字符，模式后移2字符；
//        3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；
public class Solution_match {
    public boolean match(char[] str, char[] pattern) {
        if(str == null || pattern == null)
            return false;
        int strIdx = 0;
        int patternIdx = 0;
        return matchCore(str, strIdx, pattern, patternIdx);

    }

    public boolean matchCore(char[] str, int strIdx, char[] pattern, int patternIdx) {
        if(strIdx == str.length && patternIdx == pattern.length) {
            return true;
        }
        if(strIdx != str.length && patternIdx == pattern.length) {
            return false;
        }

        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if(patternIdx + 1 < pattern.length && pattern[patternIdx + 1] == '*') {
            if((strIdx != str.length && pattern[patternIdx] == str[strIdx]) || (pattern[patternIdx] == '.'
                    && strIdx != str.length)) {
                return matchCore(str, strIdx, pattern, patternIdx + 2)//模式后移2，视为x*匹配0个字符
                        || matchCore(str, strIdx + 1, pattern, patternIdx + 2)//视为模式匹配1个字符
                        || matchCore(str, strIdx + 1, pattern, patternIdx);//*匹配1个，再匹配str中的下一个
            }else {
                return matchCore(str, strIdx, pattern, patternIdx + 2);
            }
        }

//模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if ((strIdx != str.length && pattern[patternIdx] == str[strIdx]) || (pattern[patternIdx] == '.' &&
                strIdx != str.length)) {
            return matchCore(str, strIdx + 1, pattern, patternIdx + 1);
        }
        return false;
    }

}
