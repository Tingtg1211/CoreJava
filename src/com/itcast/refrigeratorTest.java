package com.itcast;

public class refrigeratorTest {
    public static void main(String[] args){
    Elephant ee = new Elephant();
    ee.setName("aa");
    ee.setWeight(20);
    refrigerator r = new refrigerator();
    r.open();
    r.put(ee);
    r.close();
    }
}
