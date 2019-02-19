package jianzhi;

/**
 * 题目：
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 */

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果

/**
 * 首先：位运算中异或的性质：两个相同的数字异或为0，一个数和0异或还是她本身
 *
 * 分析：当只有一个数出现一次时，我们把数组中所有的数，依次异或运算，最后剩下的数就是落单的数，因为成对儿出现的都抵消了
 *
 * 依照这个思路，我们来看两个数(假设是AB）出现一次的数组，首先还是异或，剩下的数字肯定是A、B异或的结果，这个结果的二进制中的1,表现的是A和B的不同
 * 的位。我们就取第一个1所在的位数，假设是第三位，接着把原数组分成两组，分组标准是第3位是否为1。
 * 这样，相同的数肯定在一个组，因为相同数字所有位都相同，而不同的数肯定不在一个组。
 * 然后把这两个组按照最开始的思路，依次异或，剩下的两个结果就是这两个只出现一次的数字。
 */
public class Solution_FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int length = array.length;
        if (length == 2) {
            num1[0] = array[0];
            num2[0] = array[0];
            return;
        }
        int bitResult = 0;
        for (int i = 0; i < length; i ++) {
            bitResult ^= array[i];
        }
        int index = findFirst1(bitResult);
        for (int i = 0; i < length; i ++) {
        
        }
        for (int i = 0; i < length; i ++) {
            if (isBit1(array[i], index)) {
                num1[0] ^= array[i];
            }else {
                num2[0] ^= array[i];
            }
        }
    
    
    }
    
    private int findFirst1(int bitResult) {
        int index = 0;
        while (((bitResult & 1) == 0) && index < 32) {
            bitResult >>= 1;
            index ++;
        }
        return index;
    }
    
    private boolean isBit1(int target, int index) {
        return ((target >> index) & 1) == 1;
    }
    
}
