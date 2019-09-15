package com.algorithm.qiuzhao2020.JianZhi;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum_Solution {
    // 思路一:数组排序后，如果符合条件的数存在，则一定是数组中间的数
    public int MoreThanHalfNum_1(int [] array) {
        Arrays.sort(array);
        int count = 0;
        for(int i = 0; i < array.length; i ++) {
            if(array[i] == array[array.length / 2])
                count ++;

        }
        if(count > array.length / 2)
            return array[array.length / 2];
        return 0;
    }

    // 思路二:用HashMap记录每个数字出现的次数
    public int MoreThanHalfNum_2(int [] array) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < array.length; i ++) {
            Integer tmp = map.get(array[i]);
            if(tmp == null) {
                map.put(array[i], 1);
                tmp = 1;
            }else {
                map.put(array[i], tmp + 1); // 注意这里不能是++tmp，这样会造成下面判断tmp+1的时候值比之前多1
            }
            if (tmp + 1 > array.length / 2) return array[i];
        }
//        Iterator iter = map.entrySet().iterator();
//        while (iter.hasNext()) {
//            Map.Entry entry = (Map.Entry)iter.next();
//            Integer key = (Integer)entry.getKey();
//            Integer val = (Integer) entry.getValue();
//            if(val > array.length / 2)
//                return key;
//        }
        return 0;
    }

    // 思路三:
    //采用阵地攻守的思想：
    //第一个数字作为第一个士兵，守阵地；count = 1；
    //遇到相同元素，count++;
    //遇到不相同元素，即为敌人，同归于尽,count--；当遇到count为0的情况，
    //又以新的i值作为守阵地的士兵，继续下去，到最后还留在阵地上的士兵，有可能是主元素。
    //再加一次循环，记录这个士兵的个数看是否大于数组一半即可。
    public int MoreThanHalfNum_3(int [] array) {
        if (array.length == 0)
            return 0;
        int count = 1;
        int result = array[0];
        // 遍历每个元素，并记录次数；若与前一个元素相同，则次数加一，否则减一
        for (int i = 0; i < array.length; i ++) {
            if(count == 0) {
                count = 1;
                result = array[i];
            } else if (array[i] == result) {
                count ++;
            } else {
                count --;
            }
        }

        // 判断result是否符合条件，即出现次数是否大于数组长度的一半
        count = 0;
        for (int i = 0; i < array.length; i ++) {
            if (array[i] == result) {
                count ++;
            }
        }
        return count > array.length / 2 ? result : 0;
    }


}
