package com.algorithm.JIANZHI_OFFER;

/**
 * Author: GAO_TING_T11
 * Date: 2018/1/13
 * Time: 15:11
 */


/**
 * #### 分析：
 - 基本思路：如果一个整数与1做位与运算的结果为1，则表示该整数的最低位为1，否则是0。
 - 注意：左移n位等价于乘以2的n次方，右移n位等价于除以2的n次方，在实际编程中应该尽可能的以移位运算代替乘除法，因为乘除法效率太低。
 - 可能引起死循环的解法：

 先判断整数的最右位是不是1，接着把输入的整数右移一位，此时原来处于从右边数起的第二位被移到最右边了，再判断是不是1；这样每次移动一位，直到整个整数变成0为止。

 问题是：输入负数的话，右移，最高位每次补的是1，一直做右移运算的话，这个数字会变成0XFFFFFFFF而陷入死循环

 - 常规解法：为了避免死循环，我们可以将1反复左移，去判断其中1位是不是1
 *
 *
 */
public class Solution_numberOf1 {
    public int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while(flag != 0){
            if((n & flag) != 0){
                count ++;
            }
            flag = flag << 1;   //将1左移，依次与最低位进行位与运算

        }
        return count;

    }

}
