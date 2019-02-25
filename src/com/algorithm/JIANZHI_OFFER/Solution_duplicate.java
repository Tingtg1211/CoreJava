package jianzhi;

/**
 * 题目:
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */

public class Solution_duplicate {
    // 法一:构造一个容量为N的辅助数组B,原数组A中每个数对应B中下标,首次命中，B中对应元素+1。如果某次命中时，B中对应的不为0，说明前边已经有一样的数字了。
    // 时间复杂度O(n) 空间复杂度O(n)
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        int[] assist = new int[length];
        for (int i = 0; i < length; i ++) {
            if (assist[numbers[i]] == 0) {
                assist[numbers[i]] ++;
            }else {
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }
    
    // 法二:数组中的数字都在0~n-1的范围内,如果这个数组中没有重复的数字，那么当数组排序之后数字i将出现在下标为i的位置
    // 重排数组：从头到尾依次扫描这个数组中的每一个数字，当扫描到下标为i的数字时，首先比较这个数字m是不是等于i，如果是，接着扫描下一个数字；
    // 如果不是，则拿数字m与第m个数字进行比较，如果它和第m个数字相等，就找到了一个重复的数字，如果不相等，则将第i个数字和第m个数字调换位置
    // 这样数字m就放到了属于他的位置
    // 接下来重复这个比较，交换的过程，直到发现一个重复的数字
    // 空间复杂度O(1) 时间复杂度O(N)
    public boolean duplicate_2(int numbers[],int length,int [] duplication) {
        for (int i = 0; i < length; i ++) {
            if (i == numbers[i]) {
                continue;
            }else {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }else {
                    int temp = numbers[i];
                    numbers[i] = numbers[numbers[i]];
                    // 注意numbers[numbers[i]] = temp 是错误的 numbers[i]在上行被更新
                    numbers[temp] = temp;
                    
                }
            }
        }
        return false;
    }
}
