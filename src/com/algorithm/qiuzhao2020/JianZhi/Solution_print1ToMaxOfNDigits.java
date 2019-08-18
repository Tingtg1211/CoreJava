package com.algorithm.qiuzhao2020.JianZhi;

/**
 * 题目:
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。
 * 比如输入 3，则打印出 1、2、3 一直到最大的 3 位数即 999。
 */
public class Solution_print1ToMaxOfNDigits {
    public static void print1ToMaxOfNDigits(int n) {
        if (n <= 0)
            return;
        char[] number = new char[n]; // 记录1到最大的n位数里的某个可能的值
        print1ToMaxOfNDigits(number, 0);

    }

    // 数字的每一位都可能是0-9中的一个数，然后设置下一位
    private static void print1ToMaxOfNDigits(char[] number, int digit) {
        // 递归结束的条件是已经设置好了数字的最后一位
        if (digit == number.length) {
            printNumber(number);
            return;

        }
        for(int i = 0; i < 10; i ++) {
            number[digit] = (char)(i + '0'); // int转化char +'0',char转化int -'0'
            print1ToMaxOfNDigits(number, digit + 1);
        }

    }

    private static void printNumber(char[] number) {
        int index = 0;
        // 打印的时候，以0开头的不打印
        while (index < number.length && number[index] == '0')
            index ++;
        while (index < number.length)
            System.out.print(number[index ++]);
        System.out.println();

    }

    public static void main(String[] args) {
        print1ToMaxOfNDigits(3);
    }
}
