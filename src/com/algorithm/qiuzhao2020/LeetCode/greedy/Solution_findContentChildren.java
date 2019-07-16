package com.algorithm.qiuzhao2020.LeetCode.greedy;

import java.util.Arrays;

/**
 * 题目：分配饼干
 *
 * 题目描述：每个孩子都有一个满足度，每个饼干都有一个大小，只有饼干的大小大于等于一个孩子的满足度，该孩子才会获得满足。
 * 求解最多可以获得满足的孩子数量。
 *
 * Input: [1,2], [1,2,3]
 * Output: 2
 *
 * Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
 * You have 3 cookies and their sizes are big enough to gratify all of the children,
 * You need to output 2.
 */


//给一个孩子的饼干应当尽量小又能满足该孩子，这样大饼干就能拿来给满足度比较大的孩子。
// 因为最小的孩子最容易得到满足，所以先满足最小的孩子。
public class Solution_findContentChildren {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi = 0, si = 0;
        while (gi < g.length && si < s.length) {
            if(g[gi] <= s[si]) {
                gi ++;
            }
            si ++;
        }
        return gi;

    }
}
