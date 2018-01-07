package com.itcast.homework_15;

public class PersonTest {
    public static void main(String[] args){
        Person p1 = new Person("zhangsan", 20);
        Person p2 = new Person("lisi",20);
        System.out.println(p1.equals(p2));
    }
}
