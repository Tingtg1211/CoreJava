package com.algorithm.JIANZHI_OFFER;

/**
 * Author: GAO_TING_T11
 * Date: 2018/1/9
 * Time: 15:22
 */

public class Solution_find {
    public boolean Find(int target, int [][] array) {
        int row = 0;
        int col = array[0].length - 1;
        while (col >= 0 && row <= array.length - 1){
            if(target == array[row][col]){
                return true;
            }else if(target < array[row][col]){
                col --;
            }else {
                row ++;
            }
        }
        return false;

    }
}
