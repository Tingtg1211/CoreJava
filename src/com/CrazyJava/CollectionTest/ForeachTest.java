package com.CrazyJava.CollectionTest;

import java.util.ArrayList;
import java.util.List;

public class ForeachTest {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add(new String("fengkuang"));
        list.add(new String("java"));
        list.add(new String("jiangyi"));
        list.add(new String("Android"));
        for(Object obj : list){
            String book = (String) obj;
            System.out.println(book);
            if(book.equals("java")){
                list.remove(book);//会引发ConcurrentModification异常
            }
        }
        System.out.println(list);
    }
}
