package jianzhi;

import java.util.ArrayList;

/**
 * 题目:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 *
 * 分析:
 * 双指针技术，相当于有一个窗口，窗口的左右两边是两个指针，根据窗口内的值之和来确定窗口的位置和宽度
 */
public class Solution_FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        // 存放结果
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        // 两个起点，相当于动态窗口的两边，根据其窗口内的值的和来确定窗口的位置和大小
        int plow = 1, phigh = 2;
        while (phigh > plow) {
            // 由于是连续的，差为1的一个序列，那么求和公式是(a0 + an) * n / 2
            int cur = (phigh + plow) * (phigh - plow + 1) / 2;
            // 相等，那么就将窗口范围内的所有数添加进结果集
            if (cur == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = plow; i <= phigh; i ++) {
                    list.add(i);
                }
                result.add(list);
                plow ++;
            } else if (cur < sum) {
                phigh ++;
            } else {
                plow ++;
            }
        }
        return result;
    }
}
