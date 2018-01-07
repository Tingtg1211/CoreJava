package com.CrazyJava.CollectionTest;

import javax.swing.text.html.HTMLDocument;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("fengkuang");
        list.add("java");
        list.add("jiangyi");
        list.add("android");
        Iterator it = list.iterator();//获取集合对应的迭代器
        while (it.hasNext()){
            String book = (String)it.next();//it.next()方法返回的数据类型是object类型
            System.out.println(book);
            if(book.equals("java")){
                it.remove();
            }
            book = "test"; //对book变量赋值，不会改变集合元素本身


        }
        System.out.println(list);//集合重写了toString()方法
    }
}
