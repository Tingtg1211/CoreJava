package jianzhi;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Solution_moreThanHalfNum
{
    /**
     * 法一：
     * 数组中有一个数字出现的次数超过数组长度的一半，也就是说他出现的次数比其他所有数字出现次数的和还要多
     * 我们要找的数字出现的次数比其他所有数字出现的次数之和还要多，那么要找的数字肯定是最后一次把次数设为1时对应的数字
     * 同时需要检验找出的数是否真的为超过一半
     */
    public int MoreThanHalfNum_Solution(int[] array)
    {
        int result = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++)
        {
            if (times == 0)
            {
                result = array[i];
                times = 1;
            }
            else if (array[i] == result)
            {
                times++;
            }
            else
            {
                times--;
            }
        }
        if (!CheckMoreThanHalf(array, result))
        {
            result = 0;
        }
        return result;
        
    }
    
    /**
     * 法二：
     * 数组中有一个数字出现的次数超过了数组长度的一半，如果把这个数组排序
     * 那么排序后的位于数组中间的数字一定就是那个出现次数超过数组长度一半的数字
     */
    public int MoreThanHalfNum_Solution2(int[] array)
    {
        int middle = array.length >> 1; //右移1除以2
        int start = 0;
        int end = array.length - 1;
        int index = Partition(start, end, array);
        while (index != middle)
        {
            if (index > middle)
            {
                end = index - 1;
                index = Partition(start, end, array);
            }
            else
            {
                start = index + 1;
                index = Partition(start, end, array);
            }
        }

        int result = array[middle];
        if (!CheckMoreThanHalf(array, result))
        {
            result = 0;
        }
        return result;
    }

    //一次划分
    private int Partition(int start, int end, int[] array)
    {

        int i, j, temp, t;
        if (start > end)
        {
            return 0;
        }
        i = start;
        j = end;
        temp = array[start];
        while (i < j)
        {
            while (temp <= array[j] && i < j)
            {
                j--;

            }

            while (temp >= array[i] && i < j)
            {
                i++;
            }
            if (i < j)
            {
                t = array[j];
                array[j] = array[i];
                array[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        array[start] = array[i];
        array[i] = temp;
        return i;
    }

    private boolean CheckMoreThanHalf(int[] array, int result)
    {
        int times = 0;
        for (int i = 0; i < array.length; i++)
        {
            if (array[i] == result)
            {
                times++;
            }
        }
        boolean isMoreThanHalf = true;
        if (times * 2 <= array.length)  //注意要超过一半，等于一半也不满足
        {
            isMoreThanHalf = false;
        }
        return isMoreThanHalf;
    }
}
