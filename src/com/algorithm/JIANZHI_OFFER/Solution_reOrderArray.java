package com.algorithm.JIANZHI_OFFER;

/**
 * Created by gtt on 2018/1/14.
 */


/**
  * 1.要想保证原有次序，则只能顺次移动或相邻交换。
  * 2.i从左向右遍历，找到第一个偶数。
  * 3.j从i+1开始向后找，直到找到第一个奇数。
  * 4.将[i,...,j-1]的元素整体后移一位，最后将找到的奇数放入i位置，然后i++。
  * 5.終止條件：j向後遍歷查找失敗。
  */
public class Solution_reOrderArray {
    public void reOrderArray(int [] array) {
        int i = 0, j = 1;
        if(array.length == 0)
            return;
        while(i < array.length){
            while (i < array.length && !isEven(array[i])){
                i ++;
            }
            //找到第一个偶数时，j从i+1开始向后找
            j = i + 1;
            while (j < array.length && isEven(array[j])){
                j++;
            }
            //直到找到第一个奇数
            if(j < array.length){

            //将[i,...,j-1]的元素整体后移一位，最后将找到的奇数放入i位置，然后i++。
                int tmp = array[j];


                for(int j2 = j - 1; j2 >= i; j2 -- ){
                    array[j2 + 1] = array[j2];

                }
                array[i] = tmp;
                i ++;

            }else {
                break;
            }

        }


    }
    public boolean isEven(int n){

        if(n % 2 == 0 )
            return true;
        return false;

    }
}
