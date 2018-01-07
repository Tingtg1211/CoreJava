package com.itcast.homework_09;

public class Test {
    public static void main(String[] args){
        Demo d = new Demo();
       int m =  d.sumTwo(1, 2);
       System.out.println(m);
       boolean n = d.equal(2, 3);
       System.out.println(n);
       d.print();
    }
}
