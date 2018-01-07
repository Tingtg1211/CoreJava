package com.itcast;

public class refrigerator {
    public void open(){
        System.out.println("step 1: open the door.");
    }
    public void put(Elephant e){
        System.out.println("step 2: put the elephant : " + e.getName() + "..." + e.getWeight());
    }
    public void close(){
        System.out.println("step 3: close the door.");
    }
}
