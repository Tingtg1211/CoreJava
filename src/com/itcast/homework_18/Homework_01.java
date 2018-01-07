package com.itcast.homework_18;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Homework_01 {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("b");
        list.add("b");
        list.add("d");
        list.add("d");
        System.out.println(frequency(list, "a"));	// 3
        System.out.println(frequency(list, "b"));	// 2
        System.out.println(frequency(list, "c"));	// 1
        System.out.println(frequency(list, "d"));	// 5
        System.out.println(frequency(list, "xxx"));	// 0
    }
    private static String frequency(List<String> list, String string) {
        Iterator<String> it = list.iterator();
        int count = 0;
        while (it.hasNext()) {
            if (it.next().equals(string))
                count++;

        }

        System.getProperties();
        return string + " " +count;
    }

}
