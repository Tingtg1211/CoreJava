package com.itcast.homework_09;

public class Demo {
    public int sumTwo(int a, int b){
        return a + b;
    }
    public boolean equal(int a, int b){
        return a == b;
    }
    public void print(){
        for(int i = 1; i <= 9; i ++){
            for (int j = 1; j <= i; j ++){
                System.out.print(i + "*" + j + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }

}
