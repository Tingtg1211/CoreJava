package com.itcast.homework_18;

import java.util.ArrayList;
import java.util.List;

public class Homework_02 {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("b");
        list.add("f");
        list.add("e");
        list.add("c");
        list.add("a");
        list.add("d");
        sort(list);
        System.out.println(list); // a, b, c, d, e, f
    }

    private static void sort(List<String> list){
        for (int a = 0; a < list.size(); a++) {
            for (int b = 0; b < list.size(); b++) {
                if (list.get(a).toCharArray()[0] < list.get(b).toCharArray()[0]) {
                    String temp = list.get(a);
                    list.set(a, list.get(b));
                    list.set(b, temp);//  用指定元素替换列表中指定位置的元素（可选操作）。
                }
            }
        }
    }
}
