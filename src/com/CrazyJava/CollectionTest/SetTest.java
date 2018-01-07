package com.CrazyJava.CollectionTest;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args){
        Set<String> books = new HashSet<>();
        books.add(new String("FENGKUANG"));
        boolean result = books.add(new String("wFENGKUANG"));
        System.out.println(result + "-->" + books);
    }
}
