package com.algorithm.JIANZHI_OFFER;

/**
 * Author: GAO_TING_T11
 * Date: 2018/1/9
 * Time: 15:52
 */

public class Solution_replaceSpace {
    public String replaceSpace(StringBuffer str) {
        int oldLen = str.length();
        int spaceNum = 0;
        for(int i = 0; i < str.length(); i ++){
            if(str.charAt(i) == ' ')
                spaceNum ++;
        }
        int newLen = oldLen + spaceNum * 2;  //计算出替换以后的字符串长度
        int oldIndex= oldLen - 1;
        int newIndex = newLen - 1;
        str.setLength(newLen);  //此方法是在原来的字符串上进行替换

        for(; oldIndex >= 0; oldIndex --){
            if(str.charAt(oldIndex) == ' '){
                str.setCharAt(newIndex --, '0');
                str.setCharAt(newIndex --, '2');
                str.setCharAt(newIndex --, '%');

            }else {
                str.setCharAt(newIndex --, str.charAt(oldIndex));
            }

        }
        return str.toString();



    }
}
