package com.itcast.homework_10;

public class Test {
    public static void main(String[] args){
        Manager e = new Manager();
        e.setName("zhangsan");
        e.setId("zhang001");
        e.setSalary(1000);
        e.setBonus(200);
        e.work();
        Developer d = new Developer();
        d.setName("lisi");
        d.setId("lisi002");
        d.setSalary(10000);
        d.work();
    }
}
