package com.CrazyJava.CollectionTest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args){
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "aa");
        map.put(2, "bb");
        map.put(3, "cc");
        map.put(4, "dd");

        //1. 调用map集合的方法keySet,所有的键存储到Set集合中
        Set<Integer> set = map.keySet();
        //2. 遍历Set集合,获取出Set集合中的所有元素 (Map中的键)
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()){
            //3. 调用map集合方法get,通过键获取到值
            Integer key = it.next();
            String value = map.get(key);
            System.out.println(key + "..." + value);
        }

        System.out.println("=======================");

        for(Integer key : map.keySet()){
            String value = map.get(key);
            System.out.println(key + "..." + value);
        }

    }
}
