package com.algorithm.JIANZHI_OFFER;

import java.util.ArrayList;

public class Solution_minNumberInRotateArray {

    //二分查找
    public int minNumberInRotateArray(int [] array) {
        int index1 = 0;
        int index2 = array.length - 1;
        int indexMid = index1;
        while (array[index1] >= array[index2]){
            if(index2 - index1 == 1){
                indexMid = index2;
                break;
            }

            indexMid = (index1 + index2) / 2;
            if(array[indexMid] == array[index1] && array[indexMid] == array[index2]){
                return minInOrder(array, index1, index2);
            }
            if(array[indexMid] >= array[index1]){
                index1 = indexMid;
            }else if(array[indexMid] <= array[index2]){
                index2 = indexMid;
            }
        }
        return array[indexMid];
    }


    //顺序查找
    public int minInOrder(int [] array, int index1, int index2){
        int result = array[0];
        for(int i = 1; i < array.length - 1; i ++){
            if(array[i] < result)
                result = array[i];
        }
        return result;
    }
}
