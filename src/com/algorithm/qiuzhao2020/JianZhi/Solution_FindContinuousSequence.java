package com.algorithm.qiuzhao2020.JianZhi;

import java.util.ArrayList;

/**
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 */
public class Solution_FindContinuousSequence {
    // 双指针技术，相当于有一个窗口，窗口的左右两边是两个指针，根据窗口内的值之和来确定窗口的位置和宽度
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int pLow = 1, pHigh = 2;
        while (pHigh > pLow) {
            int cur = (pLow + pHigh) * (pHigh - pLow + 1) / 2;
            if (cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for(int i = pLow; i <= pHigh; i ++) {
                    list.add(i);
                }
                res.add(list);
                pLow ++; // 继续找下一个符合的序列
            } else if (cur < sum) {
                pHigh ++;
            } else {
                pLow ++;
            }

        }
        return res;

    }

}
