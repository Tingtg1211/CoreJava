package com.algorithm.qiuzhao2020.JianZhi;

/**
 * 题目描述
 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 */
public class Solution_PrintMinNumber {
    // 隐形的大数问题:m和n都在int型能表达的范围内但把他们拼接起来有可能溢出
    // 比较两个字符串s1, s2大小的时候，先将它们拼接起来，比较s1+s2,和s2+s1那个大，
    // 如果s1+s2大，那说明s2应该放前面，所以按这个规则，s2就应该排在s1前面。
    public String PrintMinNumber(int [] numbers) {
        String str = "";
        for(int i = 0; i < numbers.length; i ++) {
            for(int j = i + 1; j < numbers.length; j ++) {
                int a = Integer.valueOf(numbers[i] + "" + numbers[j]);
                int b = Integer.valueOf(numbers[j] + "" + numbers[i]);
                if (a > b) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        for(int i = 0; i < numbers.length; i ++) {
            str += String.valueOf(numbers[i]);
        }
        return str;
    }
}
