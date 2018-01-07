package com.itcast.homework_12;

public class Test {
    public static void main(String[] args){
        Employee e = new Employee("zhangsan", "001", 10000);
        System.out.println(e.getName());
        System.out.println(e.getId());
        System.out.println(e.getSalary());

    }
}
